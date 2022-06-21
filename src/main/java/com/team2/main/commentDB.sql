
create table comment_table(
	c_no number(3) primary key,
	c_boardnumber number(4) not null,
	c_id varchar2(20 char) not null,
	c_contents varchar2(300 char) not null,
	c_date date not null,
    
    
    constraint c_board_fk foreign key(c_boardnumber) 
    references board_table(board_number) 
    on delete cascade,
    constraint c_id_fk foreign key(c_id) 
    references account_table(a_id) 
    on delete cascade
);

create sequence comment_table_seq;

select * from comment_table

insert into comment_table values(comment_table_seq.nextval, 124, 'mz', '³»¿ë', sysdate);

select * from comment_table where c_boardnumber = 183


