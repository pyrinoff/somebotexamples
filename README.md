# SOMEBOT EXAMPLE 1

Примеры кода и деплоя.
Example1 - пример кода посложнее - показано, как переопределить сущность пользователя и не только.
Example2 - простой бот.

## НАСТРОЙКА
* __Если не используем docker-compose и/или не хотим передавать параметры в командной строке__ - копируем содержимое application.properties.example в файл application.properties и правим его:
```
cp src/main/resources/application.properties.example src/main/resources/application.properties
```
* __Если используем docker-compose__ - копируем содержимое .env2.example в файл .env2 и правим его:
```
cp upload/opt/docker/.env2.example upload/opt/docker/.env2
```

## КОМПИЛЯЦИЯ

```
./gradlew clean build
```

Т.к. зашито сразу 2 примера, я использую переменную activatedExample для выбора класса, который будет запускаться. 

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