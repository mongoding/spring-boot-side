#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
import heath_check
import json
from sys import argv


class AppInfo:
    def __init__(self, host, url, port, name, _type="Socket"):
        self.host = host
        self.url = url
        self.port = port
        self.name = name
        self.type = _type


server_list = [
    AppInfo("devops", "nexus", 8081, "Nexus", "Http"),
    AppInfo("devops", "registry", 5000, "Docker仓库")
]

if __name__ == '__main__':

    info = {}

    for serv in server_list:
        result = None
        if serv.type == "Http":
            result = heath_check.http_check(serv.url, serv.port)
        elif serv.type == "Socket":
            result = heath_check.socket_check(serv.url, serv.port)

        if result is not None:
            if serv.host not in info:
                info[serv.host] = []
            info[serv.host].append({
                "name": serv.name,
                "url": serv.url,
                "port": serv.port,
                "is_success": result.is_success,
                "reason": result.reason
            })

    if len(argv) > 1 and argv[1] == 'all':
        json_str = json.dumps(info, indent=4, sort_keys=True)
    else:
        error_apps = {}
        for hostname, app_list in info.items():
            for appinfo in app_list:
                if not appinfo['is_success']:
                    if hostname not in error_apps:
                        error_apps[hostname] = []
                    error_apps[hostname].append(appinfo)
        if len(error_apps) == 0:
            json_str = "All Pass!"
        else:
            json_str = json.dumps(error_apps, indent=4, sort_keys=True)
    print(json_str)
