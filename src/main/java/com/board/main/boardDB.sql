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


select rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from(select  rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from BOARD_TABLE where board_category = ?) where rn between ? and ?
-------------------------------------

select rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from(
select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category
from BOARD_TABLE 
where board_category = '1') 
where rn between 1 and 50


-- 날짜 내림차순 정렬 
select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table where board_category = '1' order by board_date desc )) where rn between 1 and 30
-- 조회수 내림차순
select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table where board_category = ? order by board_count desc )) where rn between ? and ?

--------------
select *
from (
select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category
from (
select *
from board_table
where board_category = ?
order by board_count desc
))
where rn between ? and ?

---------------------

























-- between, and ? ?  ==> rn의 몇번부터 몇번까지 노출시킬건지




select count(*) from board_table where board_category = ?



alter table board_table add board_category varchar2(10) not null;
create sequence board_table_seq;


select * from board_table;

insert into board_table values (board_table_seq.nextval,'mz',sysdate,'제목','내용','파일',1,1,'1');

insert into board_table values (board_table_seq.nextval,'mz',sysdate,'제목','내용','karina.jpg',1,1,'1');

select * from board_table where board_number =131




-- 특정 갯수만 보여주기
select * from board_table where board_category = '1' and rownum <=10



--조회수 업데이트

update board_table set board_count = board_count + 1 where board_number = ?

--yk 내가 쓴 글

select * from board_table where board_id = ?




