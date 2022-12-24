# Messenger

Pet project on Java & Spring Boot stack.

### How to run locally:
1. Download and run docker desktop.
   https://www.docker.com/products/docker-desktop/
2. Once docker demon is up, in terminal in the root folder run:
``` 
docker-compose up -d
```
Now MySQL database is running on the http://localhost:3306
and can be connected to using MySQL Workbench, 
Intellij Idea "Database" tab or any other DB viewer software.

3. Run Spring Boot application in MessagerApplication.class  
Now Messenger application is available on http://localhost:8080/messenger/
