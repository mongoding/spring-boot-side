#!/bin/bash
mysqladmin -u$1 -p$2 extended-status -i1 |
awk 'BEGIN{local_switch=0;print "QPS Commit Rollback TPS Threads_con Threads_run \n------------------------------------------------------- "}
$2 ~ /Queries$/ {q=$4-lq;lq=$4;}
$2 ~ /Com_commit$/ {c=$4-lc;lc=$4;}
$2 ~ /Com_rollback$/ {r=$4-lr;lr=$4;}
$2 ~ /Threads_connected$/ {tc=$4;}
$2 ~ /Threads_running$/ {tr=$4;
	if(local_switch==0){
	  local_switch=1; 
	  count=0
	} else {
	  if(count>10) {
	    count=0;
	    print "------------------------------------------------------- \nQPS Commit Rollback TPS Threads_con Threads_run \n------------------------------------------------------- ";
	  } else {
	    count+=1;
	    printf "%-6d %-8d %-7d %-8d %-10d %d \n", q,c,r,c+r,tc,tr;
	  }
	}
}'
