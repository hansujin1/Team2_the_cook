create table account_table(
	a_name varchar2(20 char) not null,
	a_id varchar2(30 char) primary key,
	a_pw varchar2(30 char) not null,
	a_mail varchar2(30 char)not null
);


insert into ACCOUNT_TABLE values('name','mz','1004','mz1004@naver.com');

alter table ACCOUNT_TABLE modify a_mail unique;


select * from account_table;
