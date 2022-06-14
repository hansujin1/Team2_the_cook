create table board_table(
board_number number(4) primary key,
board_id varchar2(15char) not null,
board_date date not null,
board_title varchar2(40char) not null,
board_txt varchar2(1000char) not null,
board_file varchar2(40char) not null,
board_like number(4) not null,
board_count number(4) not null
);

alter table board_table add board_category varchar2(10) not null;
create sequence board_table_seq;


select * from board_table;

insert into board_table values (board_table_seq.nextval,'mz',sysdate,'제목','내용','파일',1,1,'1');

select * from board_table where board_number =5











