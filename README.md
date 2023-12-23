# SOMEBOT EXAMPLE #1

Пример бота (код и деплой) на библиотеке somebot. 
В папках customization - пример переопределения сообщений, можно безболезненно удалить.

## НАСТРОЙКА
* __Если не используем docker-compose и/или не хотим передавать параметры в командной строке__ - копируем содержимое application.properties.example в файл application.properties и правим его:
```
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
* __Если используем docker-compose__ - копируем содержимое .env2.example в файл .env2 и правим его:
```
cp upload/opt/docker/.env2.example upload/opt/docker/.env2
```

В обоих случаях особое внимание уделяем пунктам настройки БД - если она не нужна, используем блок In-memory.

## КОМПИЛЯЦИЯ

```
./gradlew clean build
```

## ИСПОЛЬЗОВАНИЕ
```
cd upload/opt/docker/javaservice/bot
./example1.bat                               #Win
./example1                                   #Unix
```
Или же заливаем содержимое /upload в корень VPS на Unix (на которой установлен docker, я обычно использую Ubuntu v18/20) и выполняем:
```
cd /opt/docker
docker-compose up -d
```
(в качестве доп фичи добавил автостарт docker-compose при рестарте сервера, см. папку /etc/systemd/system/)