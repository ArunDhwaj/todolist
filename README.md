=========================
README: IGT TODOLIST 
==========================

**************************************Back-end README: Start **************************************
/////////////////////////////////////////////////////
1.1.0) Setting up the back-end: Application Server //// 

1.1.1) Technology Stacks: Spring Boot: 2.05.RELEASE
1.1.2) IDE: STS-3.9/5.RELEASE
1.1.3) Development OS: Ubuntu 18.04 LTS

////////////////////////////////////////////////////////
1.2.0) Setting up: H2 Memory database //////////////////

1.2.1) Open the h2_console on chrome browser using following url 
http://localhost:9090/h2_console/login.jsp?jsessionid=1a9e4784152774c1673522b20c7458f0

a) Saved settings: Select=> Generic H2 (Embeded)
b) Setting name: Fill=> Generic H2 (Embeded)
c) Driver Class: org.h2.Driver
d) JDBC URL: jdbc:h2:mem:igttodolist_db2
e) User Name: arundhwaj
d) password: arundhwaj

/////////////////////////////////////////////////////////////////////////
1.3.0) "build" and "run" the ToDoList back-end app ////////////////////////

**** Run on the terminal *****
1.3.1) $ cd igttodolist
1.3.1) $ mvn clean install
1.3.2) On successful build: $cd target
1.3.3) $ java -jar igttodolist-0.0.1-SNAPSHOT.jar

**************************************Back-end README: End **************************************



**************************************Front-end README: Start **************************************
////////////////////////////////////////////////////////////
1.1.0) Setting up the front-end: Web Server //// 

1.1.1) Technology Stacks: NPM, Node
1.1.2) angular 

**************************************Front-end README: End **************************************

Angular CLI: 6.2.4
Node: 8.10.0
OS: linux x64
Angular: 
... 

Package                      Version
------------------------------------------------------
@angular-devkit/architect    0.8.4
@angular-devkit/core         0.8.4
@angular-devkit/schematics   0.8.4
@schematics/angular          0.8.4
@schematics/update           0.8.4
rxjs                         6.2.2
typescript                   2.9.2

================================================================

