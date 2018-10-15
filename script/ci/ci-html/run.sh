#! /bin/bash

while [ true ]
do
    cd $local_repo
    git fetch origin $repo_branch
    git reset --hard origin/$repo_branch
    rm -rf /usr/share/nginx/html/*
    cp -r $local_repo/$www_for_repo/* /usr/share/nginx/html
    sleep 5m
done
