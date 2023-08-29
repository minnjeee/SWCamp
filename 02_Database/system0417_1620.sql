-----------------------------------------------------------------------------------------
-- ROLLBACK, COMMIT

select * from emp;

-- 수당을 50으로 변경 (where문으로 조건 지정 안하면 모든 데이터에 변경이 적용됨)
update emp set comm = 50;
-- ROLLBACK 을 사용하여 update문 취소하기
rollback;

-- create와 select 문을 이용하여 emp테이블의 내용을 제외한 구조만 복사해서 emp_ddl테이블을 만드시오
create table emp_ddl as select * from emp where 1<>1;   -- where문 조건을 false로 지정하면 구조만 복사!

-- insert와 select을 활용하여 emp의 내용을 emp_ddl에 복사하시오.
insert into emp_ddl select * from emp;
select * from emp_ddl; -- emp 내용이 복사되었는지 확인

-- empno=1003인 데이터를 삭제하시오.
delete emp_ddl where empno=1003;
commit;  -- create(ddl명령) 이후의 모든 DML작업 영구적으로 저장
rollback; --commit전까지만 rollback (변경사항 없음!)

---- DESC 테이블명 : 테이블의 구조 확인하기 ----
select * from emp_ddl;
desc emp_ddl; --describe : emp_ddl테이블 구조 확인



-----------------------------------------------------------------------------------------
-- 테이블 변경

-- emp테이블의 구조와 데이터를 복사하여, emp_alter테이블 생성
create table emp_alter as select * from emp;
select * from emp_alter; -- 생성 확인하기

---- ALTER TABLE 테이블명 ADD 컬럼명 데이터타입 : 테이블에 컬럼 추가하기 ----
-- EMP_ALTER 테이블에 HP 필드 삽입 추가 (타입은 VARCHAR(20))
alter table emp_alter add hp varchar(20);

-- EMP_ALTER테이블의 HP열에 내용을 입력하시오. (단, UPDATE 명령을 사용하시오.)
update emp_alter set hp = '010-1111-2222' where empno=1001;
update emp_alter set hp = '010-2222-2222' where empno=1002;
update emp_alter set hp = '010-3333-2222' where empno=1003;
update emp_alter set hp = '010-4444-2222' where empno=1004; --여러번 UPDATE해야 할 때, PYTHON의 FOR문들을 활용할 수 있다.

---- ALTER TABLE 테이블명 RENAME COLUMN 컬럼명 TO 새로운컬럼명 : 컬럼명 변경하기 ----
-- hp컬럼명을 tel로 변경하기
alter table emp_alter rename column hp to tel;

---- ALTER TABLE 테이블명 MODIFY 컬럼명 새로운데이터타입 : 컬럼의 데이터타입 변경하기 ----
-- 직원번호(empno)의 데이터타입을 number(5)로 변경
alter table emp_alter modify empno number(5);
desc emp_alter;  -- 컬럼 타입 변경되었는지 테이블 구조 확인

-- EMP_ALTER 테이블의 ENAME을 VARCHAR2(20)으로 변경하시오.
alter table emp_alter modify ename varchar2(20);


--- ALTER TABLE 테이블명 DROP COLUMN 컬럼명 : 컬럼 삭제하기 ----
-- emp_alter테이블에서 tel 컬럼 제거하기
alter table emp_alter drop column tel;


---- RENAME 테이블명 TO 새로운테이블명 : 테이블명 변경하기 ----
-- emp_alter테이블명을 emp_rename으로 변경
rename emp_alter to emp_rename;
desc emp_alter;     --에러, emp_alter 테이블 이름을 바꾸었기 때문.
select * from emp_rename;