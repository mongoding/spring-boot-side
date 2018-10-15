#!/bin/bash
if [ $# -eq 0 ];then
    echo "please enter classpath dir"
    exit -1
fi

if [ ! -d "$1" ]; then
    echo "not a directory"
    exit -2
fi

tmpfile="/tmp/.cp$(date +%s)"
tmphash="/tmp/.hash$(date +%s)"
verbose="/tmp/cp-verbose.log"

declare -a files=(`find "$1" -name "*.jar"`)
for ((i=0; i < ${#files[@]}; i++)); do
    jarName=`basename ${files[$i]}`
    list=`unzip -l ${files[$i]} | awk -v fn=$jarName '/\.class$/{print $NF,fn}'`
    size=`echo "$list" | wc -l`
    echo $jarName $size >> $tmphash
    echo "$list"
done | sort | awk 'NF{
    a[$1]++;m[$1]=m[$1]","$2}END{for(i in a) if(a[i] > 1) print i,substr(m[i],2)
}' > $tmpfile

awk '{print $2}' $tmpfile |
awk -F',' '{i=1;for(;i<=NF;i++) for(j=i+1;j<=NF;j++) print $i,$j}' |
sort | uniq -c | sort -nrk1 | while read line; do
    dup=${line%% *}
    jars=${line#* }
    jar1=${jars% *}
    jar2=${jars#* }
    len_jar1=`grep -F "$jar1" $tmphash | grep ^"$jar1" | awk '{print $2}'`
    len_jar2=`grep -F "$jar2" $tmphash | grep ^"$jar2" | awk '{print $2}'`
    # Modified by Robert 2017.4.9
    #len=$(($len_jar1 > $len_jar2 ? $len_jar1 : $len_jar2))
    len_jar1=`echo $len_jar1 | awk -F' ' '{print $1}'`
    len_jar2=`echo $len_jar2 | awk -F' ' '{print $1}'`
    if [ $len_jar1 -gt $len_jar2 ]
    then
      len=$len_jar1
    else
      len=$len_jar2
    fi
    per=$(echo "scale=2; $dup/$len" | bc -l)
    echo ${per/./} $dup $jar1 $jar2
done | sort -nr -k1 -k2 |
awk 'NR==1{print "Similarity DuplicateClasses File1 File2"}{print "%"$0}'| column -t

sort $tmpfile | awk '{print $1,"\n\t\t",$2}' > $verbose
echo "See $verbose for more details."

rm -f $tmpfile
rm -f $tmphash
