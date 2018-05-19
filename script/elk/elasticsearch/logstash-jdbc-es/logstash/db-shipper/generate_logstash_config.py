#!/usr/bin/env python
# -*- coding: utf-8 -*-

from __future__ import print_function
from string import Template
import glob
from os.path import basename, splitext
import ConfigParser

files_path = 'sql/'
dist_file_path = 'pipeline/logstash.conf'
config_file_path = 'db.ini'
default_schedule = '*/2 * * * *'
es_host = '172.16.238.10:9200'
cf = ConfigParser.ConfigParser()
cf.read(config_file_path)


def get_table_schedule_map():
    schedules = cf.options("schedule")
    m = {}
    for option in schedules:
        m[option] = cf.get('schedule', option)
    return m


def generate_input_configs():
    sql_files = glob.glob(files_path + '/*.sql')

    it = Template(open('assets/input-template.conf').read())

    input_str = ''

    print(len(sql_files))

    d = get_table_schedule_map()

    driver_type = cf.get("db", "driver_type")
    driver_mysql_name = cf.get("lib", "mysql")
    driver_oracle_name = cf.get("lib", "oracle")
    if driver_type == 'mysql':
        driver_name = driver_mysql_name
        driver_class = 'com.mysql.jdbc.Driver'
    elif driver_type == 'oracle':
        driver_name = driver_oracle_name
        driver_class = 'Java::oracle.jdbc.driver.OracleDriver'
    else:
        raise Exception("unsupported driver name %s yet!" % driver_type)

    db_connect_url = cf.get("db", "connect_url")
    db_user = cf.get("db", "user")
    db_pwd = cf.get("db", "password")

    for file_url in sql_files:
        file_name_with_ext = basename(file_url)
        file_name = splitext(file_name_with_ext)[0]
        schedule = d.get(file_name.lower(), default_schedule)
        input_str += it.substitute(table_name=file_name, schedule=schedule, driver_name=driver_name,
                                   driver_class=driver_class, db_connect_url=db_connect_url, db_user=db_user,
                                   db_pwd=db_pwd)

    return input_str


if __name__ == '__main__':
    input_configs = generate_input_configs()
    es_index_name = cf.get('es', 'index_name')
    f = open(dist_file_path, 'w+')

    filein = open('assets/logstash-template.conf')
    s = Template(filein.read())
    ls_str = s.substitute(inputs=input_configs, es_host=es_host, es_index_name=es_index_name)

    f.write(ls_str)
    f.close()

