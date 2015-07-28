# Proof of Concept REST + Jersey + Hibernate

### REST specification

* Create an Office
A HTTP Post request must be executed using the following PATH:

http://HOST:PORT/rest/office_manager/office

with the next JSON Payload:

```JSON
{
"location":"<location>"
"openFrom":"<HH:MM>"
"openUntil":"<HH:MM>"
"timeDifference":SignedInteger
}
```

The time must be specified following the ISO format 24hs.
If the creation is successful the request will return a JSON response with the information of the new office that will include the "officeId". For example:

```JSON
{
"location":"Nice",
"officeId":1,
"openFrom":"10:00:00",
"openUntil":"22:00:00",
"timeDifference":3
}
```

* List Offices
It's possible to display all the available offices in the database. The following GET request has to be executed:

http://HOST:PORT/rest/office_manager/office

The result will be a JSON array containing all the offices. For example:

```JSON
[
{
"location":"Nice",
"officeId":1,
"openFrom":"10:00:00",
"openUntil":"22:00:00",
"timeDifference":3
},
{
"location":"Buenos Aires",
"officeId":2,
"openFrom":"10:00:00",
"openUntil":"22:00:00",
"timeDifference":-3
},
{
"location":"Berlin",
"officeId":3,
"openFrom":"09:00:00",
"openUntil":"14:00:00",
"timeDifference":2
}
]
```

* List Open Offices now
In order to display all the offices open at this moment, the parameter "open" with the value "now" has to be specified in the previous URL:

http://HOST:PORT/rest/office_manager/office?open=now

The result will be a JSON array with the offices that are open. See the example in the point 2.

* See details of an office.
If the officeId is known, it's possible to get the details of an office. The URL has to include the number in the following way:

http://HOST:PORT/rest/office_manager/office/<officeId>

The result will display only the office for the specified ID. If there is no offices that matches the criteria, the response will be a HTTP 404 error.

### Table creation.

This is a fully functional application that needs a MySQL table to be created. It can be done running the script Tables.sql available in the root of the Maven project.
Database configuration.
The project uses Hibernate as ORM Framework. This means that the database configuration must be changed in the file located in the path "/src/main/resources/hibernate.cfg.xml". A new war package must be created using the maven commands.
Project compilation and unit tests running.
The project uses Maven what means that the following command will be enough for the WAR component generation and also the Unit tests running:

```
mvn clean package
```

You will need Maven 3.0.4 or plus installed in your machine.

### Project running.

It's possible to run the project without installing a container due the Jetty plugin is configured in the project. It will be enough to run the following Maven command:

```
mvn jetty:run
```

It will create a web server listening in port 8080.

