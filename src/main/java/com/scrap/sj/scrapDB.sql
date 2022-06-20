create table scrap_table(
	scrap_num number(4) primary key,
	scrap_boardNum number(4) not null,
	scrap_id varchar2(30 char) not null,
	
	constraint borardNum_fk foreign key(scrap_boardNum)
	references board_table(board_number) on delete cascade,
	constraint accountId_fk foreign key(scrap_id)
	references account_table(a_id) on delete cascade
);

create SEQUENCE scrap_table_seq INCREMENT by 1 start with 1;

select * from scrap_table;