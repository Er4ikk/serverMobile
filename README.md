# serverMobile

to run the project in Intellij or Eclipse:
mvn tomcat7:run 
or
Run Configuration>Maven>New Configuration
Goals: tomcat7:run

WHEN IMPORTING DATABASE BE SURE TO SELECT coding to utf8mb4_general_ci

to check if everything works:
http://localhost:8080/serverMobile/rest/myresource

get All users :

http://localhost:8080/serverMobile/rest/users/all


get User by Id:
{id}=16
http://localhost:8080/serverMobile/rest/users/{id}


create User :

http://localhost:8080/serverMobile/rest/users/create

Example object to send (Postman):
{
    "id": null,
    "name": "enrico",
    "surname": "fasano",
    "password": "pircio",
    "mail": "enzo"
}

id is null because the db is autoincrement

delete user by Id
http://localhost:8080/serverMobile/rest/users/delete/{id}

get User by Mail and Password (bugged)
http://localhost:8080/serverMobile/rest/users/enzo/enzo

Example of response : 
[
    {
        "id": 15,
        "name": "asdasd",
        "surname": "sadasdasd",
        "mail": "enzo",
        "password": "enzo"
    }
]

------------------------------------------------------------------------------------------

RESULT TABLE

get all REsults:
http://localhost:8080/serverMobile/rest/results/all

Example of response :
[
{
        "date": "2022-05-06 00:00:00",
        "idResult": 28,
        "idUser": 13,
        "bytes": null,
        "label": " luca ",
        "phooto": null
    }
]

"bytes" filed contains the image


get result by userID
http://localhost:8080/serverMobile/rest/results/13

REsponse similiar above 


delete REsult by Id of Result:
http://localhost:8080/serverMobile/rest/results/delete/25


create REsult 
http://localhost:8080/serverMobile/rest/results/create

Example of object to send (Postman)

{
    "id_user":13,
    "photo":null,
    "labels":"luca",
    "date":"2022-05-06"
}










