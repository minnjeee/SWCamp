-- CREATE TABLE 테이블명(컬럼명 데이터타입 [NOT NULL], ... ) : 테이블 생성하기
-- 회원가입 시, 회원 데이터를 저장할 omember테이블 생성하기
create table omember(
    num int not null,            -- 회원번호
    email varchar(50) not null,  -- 이메일
    pwd varchar(20) not null,    -- 비밀번호
    pwdc varchar(20) not null,   -- 비밀번호 확인
    name varchar(20) not null,   -- 이름
    tel varchar(15) not null,    -- 전화번호
    addr varchar(100),           -- 주소
    primary key (num)   -- 회원번호를 기본키로 설정
);

-- INSERT INTO 테이블명(컬럼명,...) VALUES(값,...) : 테이블에 데이터 추가/삽입하기
INSERT INTO OMEMBER VALUES(1, 'minjee3333@gmail.com', 'oracle1', 'oracle1','Kim','010-2900-4039','서울시 서대문구');
INSERT INTO OMEMBER VALUES(2, 'minjee3333@naver.com', 'oracle2', 'oracle2','Park','010-9171-6138','고양시 내유동');


-- AS SELECT문 이용 : 기존 테이블의 구조와 데이터를 복사하여 새로운 테이블 생성하기

-- omember테이블의 내용을 복사해서 omembercopy 라는 이름의 테이블을 생성하시오.
-- 단, create문과 select문을 반드시 사용하시오.
create table omembercopy
    as select * from omember;

-- omember테이블에서 번호,이름,이메일을 복사해서 omemberpart 라는 이름의 테이블을 생성하시오.
-- 단, create문과 select문을 반드시 사용하시오.
create table omemberpart
    as select num, name, email from omember;