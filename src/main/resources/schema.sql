drop table USER if exists;

Create table USER (ID Serial,Name varchar(5),Dept varchar(10) NOT NULL,Salary bigint);