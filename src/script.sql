CREATE DATABASE SipsewanaInstitute;
SHOW DATABASES;
USE SipsewanaInstitute;

/*Student Table*/
DROP TABLE IF EXISTS Student;
CREATE TABLE IF NOT EXISTS Student(
    SId VARCHAR (6) NOT NULL PRIMARY KEY ,
    SName VARCHAR (25) ,
    Address VARCHAR (40) ,
    DOB VARCHAR (15) ,
    NIC VARCHAR (20) ,
    TNo VARCHAR (20)
);

/*Course Table*/
DROP TABLE IF EXISTS Course;
CREATE TABLE IF NOT EXISTS Course(
    CId VARCHAR (6) NOT NULL PRIMARY KEY ,
    CName VARCHAR (25) ,
    Duration VARCHAR (20) ,
    Fee DOUBLE
);

/*Associate Table-RegisterDetails*/
DROP TABLE IF EXISTS Register;
CREATE TABLE IF NOT EXISTS Register(
    SId VARCHAR (6) ,
    CId VARCHAR (6) ,
    RegDate VARCHAR (20) ,
    FOREIGN KEY (SId) REFERENCES Student(SId) ,
    FOREIGN KEY (CId) REFERENCES Course(CId)
);


SHOW TABLES;
DESC Student;
DESC Course;
DESC Register;

/* Join Queries*/
SELECT r.RegId,r.SId,r.CId,r.RegDate,s.SName,c.CName FROM Register r INNER JOIN Student s ON r.SId=s.SId INNER JOIN Course c ON r.CId=c.CId;

FROM C WHERE pId LIKE '%" + s + "%' or pName LIKE '%" + s + "%'

SELECT r.RegId,s.SId,s.SName,c.CId,c.CName,r.RegDate FROM Register r INNER JOIN Student s ON r.student=s.SId INNER JOIN Course c ON r.course=c.CId WHERE CId LIKE '%" + s + "%' or CName LIKE '%" + s + "%'