#!/bin/env python2.7
#-*- coding:utf-8 -*-
from email.mime.multipart import MIMEMultipart
from email.mime.base import MIMEBase
from email.mime.text import MIMEText

from email.utils import COMMASPACE,formatdate
from email import encoders
import smtplib
import argparse
import sys
reload(sys)
sys.setdefaultencoding("utf-8")
import os

def option_parse(argv):
    usage="""%(prog)s -n mailserver -p port --user login_user --passwd login_passwd  -f frommail -t tomail_1 tomail_2......                                 [-s subject] [-c text] [--file attach-file1 attach-file2......]"""
    parser=argparse.ArgumentParser(usage=usage)
    parser.add_argument("-n",action="store",type=str,dest="mailserver",help="指定smtp服务器域名或ip地址",metavar="mailserver")
    parser.add_argument("-p",action="store",type=int,dest="port",help="smtp服务器端口号",default=25,metavar="port")
    parser.add_argument("--user",action="store",type=str,dest="login_user",help="登录smtp服务器的用户名",metavar="login_user")
    parser.add_argument("--passwd",action="store",type=str,dest="login_passwd",help="登录smtp服务器的密码",metavar="login_passwd")
   
    parser.add_argument("-f",action="store",type=str,dest="frommail",help="用来发送邮件的邮件地址",metavar="frommail")
    parser.add_argument("-t",action="store",type=str,dest="tomail",help="发送邮件的目的地址",metavar="tomail")
    parser.add_argument("-s",action="store",type=str,dest="subject",help="邮件主题",metavar="subject")
    parser.add_argument("-c",action="store",type=str,dest="text",help="邮件文本内容",metavar="text")
    parser.add_argument("--file",action="store",type=str,dest="file",help="邮件的附件",metavar="file")
    
    option=parser.parse_args()
    if not option.mailserver or not option.login_user or not option.login_passwd or not option.frommail or not option.tomail:
        parser.print_help()
        exit(1)
    if not option.subject and not option.text and not option.file:
        parser.print_help()
        mesg="邮件主题、邮件文本内容和邮件附件必须至少指定其中之一才能发送"
        print "\033[1;31m参数错误：%s\033[0m" % mesg
        exit(1)
    if not option.subject:option.subject=""
    if not option.text:option.text=""
    if not option.file:option.file=""
    return option

def send_email_over_smtps(server,frommail,tomail,subject,text,files=[]):
    msg = MIMEMultipart()
    msg['From'] = frommail
    msg['Subject'] = subject
    msg['To'] = COMMASPACE.join(tomail)
    msg['Date'] = formatdate(localtime=True)
    msg.attach(MIMEText(text))

    for file in files:
        part = MIMEBase('application','octet-stream')
        part.set_payload(open(file,'rb').read())
        encoders.encode_base64(part)
        part.add_header('Content-Disposition','attachment;filename="%s"' % os.path.basename(file))
        msg.attach(part)
    try:
        smtpserver = smtplib.SMTP(server['name'],server['port']) #此处需要填写服务器地址，587是默认smtps端口
    except smtplib.SMTPConnectError,e:
        print "\033[1;31m连接到smtp %s:%d 出错：%s\033[0m" % (server['name'],server['port'],e)
        exit(1)
    except Exception,e:
        print "\033[1;31m连接到smtp %s:%d 出现未知错误：%s\033[0m" % (server['name'],server['port'],e)
        exit(1)
    try:
        smtpserver.ehlo()
        smtpserver.starttls()
        smtpserver.ehlo()
        smtpserver.login(server['user'], server['passwd'])
        smtpserver.sendmail(frommail,tomail,msg.as_string())
    except Exception,e:
        print '''\033[1;31m使用用户名 "%s" 从 "%s" 发送邮件到 "%s" 时出错，信息: %s\033[0m''' % (server['user'],frommail,tomail,e)
        smtpserver.close()
        exit(1)
    print 'done!'
    smtpserver.close()

if __name__ == "__main__":
    option=option_parse(sys.argv)
    #print option.mailserver,option.frommail,option.tomail,option.login_passwd
    #exit(1)
    server={'name':option.mailserver,'user':option.login_user,'passwd':option.login_passwd,'port':option.port}
    send_email_over_smtps(server,option.frommail,option.tomail.split(),option.subject,option.text,option.file.split()) 
