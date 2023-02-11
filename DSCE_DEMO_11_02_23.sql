create database Employeeportal;
use Employeeportal;
CREATE TABLE IF NOT EXISTS Employeeinfo(
 name VARCHAR(100) NOT NULL,
 id VARCHAR(200)  NOT NULL, dept varchar(20),
 age INT NOT NULL,
 PRIMARY KEY(id));
use Employeeportal;
/*CALL get_info('Sales');
CALL inc_age_by(2,'MAR35');*/
insert into employeeinfo(name,id,dept,age) values ("ADITHI","ADI21","SDE",21);
insert into employeeinfo(name,id,dept,age) values ("MANAV","MAN34","Sales",34);
insert into employeeinfo(name,id,dept,age) values ("KARTHIK","KAR45","HR",45);
insert into employeeinfo(name,id,dept,age) values ("MARK","MAR35","HR",35);
select * from Employeeinfo;

/*drop table Employeeinfo;
drop database Employeeportal;*/