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


-- 좋아요 수 업데이트

update board_table set board_like = board_like + 1 where board_number = ?

-- 좋아요 한 게시물

select * from board_table where board_number in (select like_bno from heart_table where id ='mz');

-- 가장 최신글 게시물 정렬

select * from (
	select rownum as rn, board_number, board_date from board_table
	order by board_date desc )
		
	
-- 그 중에서 여섯개?정도

select * from (
	select rownum as rn, board_number, board_date from board_table
	order by board_date desc ) 
	WHERE ROWNUM <= 6;
	
-- 좋아요 순 게시물 6개

select * from (
	select rownum as rn, board_like from board_table
	order by board_like desc )
	where rownum <= 6;

