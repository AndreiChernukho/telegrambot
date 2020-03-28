# telegrambot

**Для запуска приложения необходимо в командной строке из дериктории где находится pom.xml запустить**
> mvn spring-boot:run

Приложение запустится по адресу localhost:8080/telegrambot

## Rest API:
### Получить список городов:
GET запрос по адресу localhost:8080/telegrambot/cities

*Пример:*
> curl -X GET localhost:8080/telegrambot/cities

### Получить город по идентификатору:
GET запрос по адресу
localhost:8080/telegrambot/city/get/{id}

id - идентификатор города

*Пример:*
> curl -X GET localhost:8080/telegrambot/city/get/8b8753ad-a11a-4d71-b04d-fe82c8059b3a

### Удалить город по идентификатору:
DELETE запрос по адресу localhost:8080/telegrambot/city/delete/{id}

id - идентификатор города

*Пример:*
> curl -X DELETE localhost:8080/telegrambot/city/delete/8b8753ad-a11a-4d71-b04d-fe82c8059b3a

### Сохранить новый город:
POST запрос по адресу localhost:8080/telegrambot/create

в параметрах city={name:'название города', description:'описание'}

*Пример:*
> curl -X POST localhost:8080/telegrambot/city/create -H 'Content-type:application/json' -d '{"name": "Город", "description": "Описание"}'

### Изменить данные города:
PUT запрос по адресу localhost:8080/telegrambot/update

в параметрах city={id:идентификатор; name:'название города', description:'описание'}

*Пример:*
> curl -X PUT localhost:8080/telegrambot/city/update -H 'Content-type:application/json' -d '{"name": "Город", "description": "Описание"}'

## Запуск бота:
Для запуск бота перейдите в телеграме по адресу <http://t.me/VH5PtAR2U2PsszsTnSlpUyjA0_bot>

Имя бота: VH5PtAR2U2PsszsTnSlpUyjA0_bot

Токен бота: 1078519732:AAGy5nsCK9HTH-OaJs3t3iBRlEgNPFxnW7I
