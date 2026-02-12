#!/bin/sh
# shellcheck disable=SC2046
kill -9 $(lsof -ti:8088,8081,8080) && nohup java -jar skynet.jar &
