create table comment_db(
	c_no number(3) primary key,
	c_boardnumber number(4) not null,
	c_id varchar2(20 char) not null,
	c_contents varchar2(300 char) not null,
	c_date date not null

);

create sequence comment_db_seq;

insert into comment_db values(comment_db_seq.nextval, 1, 'mz', '³»¿ë', sysdate);

select * from comment_db;

select * from comment_db where c_boardnumber = ?