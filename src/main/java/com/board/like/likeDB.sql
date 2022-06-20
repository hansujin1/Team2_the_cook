create table heart(
	
	like_no auto_increment primary key,
	like_Bno not null,
	id varchar2(30 char),
	
	constraint heart_like_Bno_fk foreign key(like_bno) 
	references board_table(board_number) 
	on delete cascade,
	constraint heart_id_fk foreign key(id) 
	references account_table(a_id)
	on delete cascade on update cascade
	
);


------------------------------------------------