drop table board;
drop table users;

create table users(
	id 			varchar2(28) 	primary key,
	password 	varchar2(8)		not null,
	name 		varchar2(30)	not null,
	role 		varchar2(5)		default 'User'
)

create table board(
	seq			number(5) 		primary key,
	title		varchar2(200)	not null,
	nickname	varchar2(30)	not null,
	content		varchar2(2000)	not null,
	regdate		date 			default sysdate,
	cnt			number(5)		default 0,
	userid		varchar2(8)		default 'guest'
)

insert into users values('hong', 'hong123', '홍길동', 'Admin');
insert into users values('abc', 'abc123', '임꺽정', 'User');
insert into users values('guest', 'guest123', '일지매', 'Guest');

insert into board(seq, title, nickname, content, regdate, userid) 
values(1, '첫 번째 게시물', '홍길동', '첫 번째 게시물 내용.', '2017-02-05', 'hong');

insert into board(seq, title, nickname, content, regdate, userid) 
values(2, '두 번째 게시물', '홍길동', '두 번째 게시물 내용.', '2017-03-15', 'hong');

insert into board(seq, title, nickname, content, regdate, userid) 
values(3, '세 번째 게시물', '홍길동', '세 번째 게시물 내용.', '2017-03-03', 'hong');

insert into board(seq, title, nickname, content, regdate, userid) 
values(4, '네 번째 게시물', '홍길동', '네 번째 게시물 내용.', '2017-05-17', 'hong');

insert into board(seq, title, nickname, content, regdate, userid) 
values(5, '다섯 번째 게시물', '일지매', '다섯 번째 게시물 내용.', '2017-05-19', 'guest');

insert into board(seq, title, nickname, content, regdate, userid) 
values(6, '여섯 번째 게시물', '일지매', '여섯 번째 게시물 내용.', '2017-12-25', 'guest');

insert into board(seq, title, nickname, content, regdate, userid) 
values((select nvl(max(seq), 0)+1 from board), '일곱 번째 게시물', '일지매', '일곱 번째 게시물 내용.', '2017-12-25', 'guest');


select * from users;

select * from board order by seq desc;


select * from board where title like '%번째%' order by seq desc

-- 1명 조회
select * from board where seq = 10;

-- 게시물 삽입
-- nvcl (널이 아니면 꺼낼 값, 널인 경우 처리할 값)
insert into board(seq, title, nickname, content)
values( (select nvl( max(seq), 0) + 1 from board), '테스트타이틀', '테스트', '테스트 컨텐츠')

-- 수정
update board set title = '새로운 타이틀', content = '새로운 컨텐츠' where seq = 10

-- 삭제
delete from board where seq = 12

-- 사용자 체크
select * from users where id = 'guest' and password = 'guest12'