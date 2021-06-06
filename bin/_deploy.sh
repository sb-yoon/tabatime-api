#!/bin/bash

REPOSITORY=/app/tabatime
SERVICE_NAME=tabatime

cd $REPOSITORY/tabatime-api/

echo "> Git Pull"

git pull

echo "> 프로젝트 Build 시작"

./mvnw clean package

echo "> Build 파일 복사"

cp ./target/*.jar $REPOSITORY/lib/

echo "> 현재 구동중인 애플리케이션 pid 확인"

CURRENT_PID=$(pgrep -f $SERVICE_NAME)

echo "$CURRENT_PID"

if [ -z $CURRENT_PID ]; then
    echo "> 현재 구동중인 애플리케이션이 없으므로 종료하지 않습니다."
else
    echo "> kill -9 $CURRENT_PID"
    kill -9 $CURRENT_PID
    sleep 5
fi

echo "> 새 어플리케이션 배포"

JAR_NAME=$(ls -tr $REPOSITORY/lib | grep $SERVICE_NAME | tail -n 1)

echo "> JAR Name: $JAR_NAME"

nohup java -jar $REPOSITORY/lib/$JAR_NAME &