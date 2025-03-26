#!/bin/sh
# shellcheck disable=SC2046
kill -9 $(lsof -ti:8088,8081) && nohup java -jar skynet-web-1.1.0.jar &
