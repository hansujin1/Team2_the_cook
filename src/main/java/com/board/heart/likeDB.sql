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

select * from heart 
select * from heart_table
drop table heart_table cascade constraint purge;

create sequence like_no_seq;

select count(*) from heart_table where like_no  = ?

insert into heart_table values(like_no_seq.nextval,'40','mz','5');

select * from BOARD_TABLE ;

-- 좋아요 수 업데이트

update board_table set board_like = board_like + 1 where board_number = ?

