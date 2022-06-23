create table heart(
    like_no number(4) primary key,
    like_Bno number(4) not null,
    id varchar2(30 char) not null
    
);

create table heart_table(
    like_no number(4) primary key,
    like_Bno number(4) not null,
    id varchar2(30 char) not null,
    
    constraint heart_like_Bno_fk foreign key(like_bno) 
    references board_table(board_number) 
    on delete cascade,
    constraint heart_id_fk foreign key(id) 
    references account_table(a_id) 
    on delete cascade
   
);

select * from heart_table
select * from BOARD_TABLE

drop table heart_table cascade constraint purge;

create sequence like_no_seq;

select count(*) from heart_table where like_no  = ?

insert into heart_table values(like_no_seq.nextval,'150','mz');


-- ���ƿ� �� ������Ʈ

update board_table set board_like = board_like + 1 where board_number = ?

-- ���ƿ� �� �Խù�

select * from board_table where board_number in (select like_bno from heart_table where id ='mz');

-- ���� �ֽű� �Խù� ����

select * from (
	select rownum as rn, board_number, board_date from board_table
	order by board_date desc )
		
	
-- �� �߿��� ������?����

select * from (
	select rownum as rn, board_number, board_date from board_table
	order by board_date desc ) 
	WHERE ROWNUM <= 6;
	
-- ���ƿ� �� �Խù� 6��

select * from (
	select rownum as rn, board_like from board_table
	order by board_like desc )
	where rownum <= 6;
	
	
select * from ( select rownum as rn, board_number, board_date from board_table order by board_date desc ) WHERE ROWNUM <= 6 

select * from ( select rownum as rn, board_number, board_id, board_date, board_title, board_txt, board_file, board_like, board_count, board_category from ( select * from board_table where board_category = '1' order by board_like desc )) where rn between 1 and 6


-- main ���ƿ� �۾�



insert into board_table values 
(board_table_seq.nextval,'mz',sysdate-1,'����','����','loginPage.jpg',200,1,1);



