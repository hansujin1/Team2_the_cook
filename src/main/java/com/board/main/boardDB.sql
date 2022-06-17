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


-- ��¥ �������� ���� 
select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table where board_category = '1' order by board_date desc )) where rn between 1 and 30
-- ��ȸ�� ��������
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

























-- between, and ? ?  ==> rn�� ������� ������� �����ų����




select count(*) from board_table where board_category = ?



alter table board_table add board_category varchar2(10) not null;
create sequence board_table_seq;


select * from board_table;

insert into board_table values (board_table_seq.nextval,'mz',sysdate,'����','����','����',1,1,'1');

insert into board_table values (board_table_seq.nextval,'mz',sysdate,'����','����','karina.jpg',1,1,'1');

select * from board_table where board_number =131




-- Ư�� ������ �����ֱ�
select * from board_table where board_category = '1' and rownum <=10



--��ȸ�� ������Ʈ

update board_table set board_count = board_count + 1 where board_number = ?

--yk ���� �� ��

select * from board_table where board_id = ?




