#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
from httplib import HTTPConnection
from sys import argv
import socket
import network_tool

try:
    import DNS
except ImportError:
    DNS = False


class CheckResult:
    def __init__(self, is_success, reason=""):
        self.is_success = is_success
        self.reason = reason


def is_valid_ipv4_address(address):
    try:
        socket.inet_pton(socket.AF_INET, address)
    except AttributeError:  # no inet_pton here, sorry
        try:
            socket.inet_aton(address)
        except socket.error:
            return False
        return address.count('.') == 3
    except socket.error:  # not a valid address
        return False

    return True


def is_valid_ipv6_address(address):
    try:
        socket.inet_pton(socket.AF_INET6, address)
    except socket.error:  # not a valid address
        return False
    return True


def address_check(addr):
    if is_valid_ipv4_address(addr):
        return True
    else:
        ip = network_tool.canIHasIP(addr)
        if ip:
            return True
        else:
            return False


def http_check(url, _port=80):
    sr = socket_check(url, _port)

    if not sr.is_success:
        return CheckResult(sr.is_success, sr.reason)

    conn = HTTPConnection(url, _port, True, 10)
    conn.request('GET', '/')
    httpres = conn.getresponse()

    is_success = False
    if httpres.status in [200, 301, 302]:
        is_success = True
    return CheckResult(is_success, httpres.reason)


def socket_check(url, _port):
    if not address_check(url):
        return CheckResult(False, ("Server %s cant access." % url))

    sk = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    sk.settimeout(1)
    is_success = False
    try:
        sk.connect((url, _port))
        reason = "Server port %i ok!" % _port
        is_success = True
    except IOError:
        reason = "Server port %i not connect!" % _port

    sk.close()
    return CheckResult(is_success, reason)


if __name__ == '__main__':
    if len(argv) >= 3:
        result = None
        port = 80 if len(argv) is 3 else int(argv[3])
        if argv[1] == "socket":
            result = socket_check(argv[2], port)
        elif argv[1] == "http":
            result = http_check(argv[2], port)
        if result is not None:
            print("%s check \"%s\", Result is %s, Reason: %s" % (argv[1], argv[2], result.is_success, result.reason))
