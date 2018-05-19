#!/usr/bin/env python
# -*- coding: utf-8 -*-

# see also https://mail.python.org/pipermail/python-list/2009-November/559669.html
# pip install pydns

import signal
import socket

try:
    import DNS
except:
    DNS = False


def DNSResolve(s):
    if DNS:
        DNS.ParseResolvConf()  # Windows?
        r = DNS.DnsRequest(name=s, qtype='A')
        a = r.req()
        return a.answers[0]['data']
    else:
        return socket.gethostbyname(s)


def dns_timeout(a, b):
    raise Exception("Oh Noes! a DNS lookup timeout!")


def canIHasIP(domain_name, timeout=3):
    signal.signal(signal.SIGALRM, dns_timeout)
    signal.alarm(timeout)
    try:
        ip = DNSResolve(domain_name)
    except Exception as exc:
        # print(exc)
        return False
    signal.alarm(0)
    return ip
