DROP TABLE EMP_DDL;

-- 직원 테이블(EMP_DDL) 생성하기
CREATE TABLE EMP_DDL(
    EMPNO NUMBER(4),    -- 직원번호
    ENAME VARCHAR2(20), -- 직원이름
    JOB VARCHAR2(9),    -- 직책
    MGR NUMBER(4),      -- 상사번호
    HIREDATE DATE,      -- 입사일자
    SAL NUMBER(7,2),    -- 급여 (NUMBER(7,2) : 총7자리 중에서 소수점이하 2번째 자리)
    COMM NUMBER(7,2),   -- 수당
    DEPTNO NUMBER(2)    -- 부서번호
);

-- 직원 테이블(EMP_DDL)에 데이터 추가하기
insert into emp_ddl values(1001, 'kimsoo', 'developer', 2001, '1981-01-01', 500, 20, 30);   -- 테이블명 뒤에 컬럼명 지정안하면, values 뒤에 모든 컬럼에 대응되게 값 쓰기
insert into emp_ddl values(1002, 'yoonhoil', 'salesman', 2000, '1991-01-01', 400, 10,30);
insert into emp_ddl values(1003, 'jangsosu', 'developer', 2001, '2001-01-01', 300, 20, 30);
insert into emp_ddl(empno, hiredate, sal, comm, deptno) values(1004, '2001-01-01', 300, 20, 30);  -- 테이블명(컬럼명1, 컬럼명2) 컬럼명 지정하면, values(값1, 값2) 로 해당 컬럼의 값만 쓰기
insert into emp_ddl(job, mgr, ename) values('salesman', 2003, 'hanjinsa');                        -- 지정 안한 컬럼들은 자동으로 null값 대입됨


---- UPDATE 테이블명 SET 컬럼명1 = 값1, 컬럼명2 = 값2 [WHERE 조건] : 테이블에서 조건에 만족하는 레코드의 컬럼 값 수정하기 ----

-- 직원 테이블(EMP_DDL)에서 직원번호(empno)가 1004인 직원의 이름을 hanjinsa로, 직책을 salesman으로, 상사번호를 2003으로 변경하기
update emp_ddl set ename = 'hanjinsa', job = 'salesman', mgr = 2003 where empno = 1004;

-- 입사일이 2000년 이전에 입사한 사람들의 수당(comm)을 40으로 변경하시오
update emp_ddl set comm = 40 where hiredate < '2000-01-01';
select comm, hiredate from emp_ddl where hiredate < '2000-01-01'; --수정된 데이터 확인하기

-- mgr이 2001인 사람의 급여(sal)를 1.5배로 인상하시오.
update emp_ddl set sal = sal * 1.5 where mgr = 2001;
select sal, mgr from emp_ddl where mgr = 2001; --수정된 데이터 확인하기

---- DELETE FROM 테이블명 [WHERE 조건식] : 테이블에서 조건을 만족하는 레코드 삭제하기 ----

-- 직원번호(empno)가 비어있는 직원 데이터 삭제하기
delete from emp_ddl where empno is null;


-----------------------------------------------------------------------------------------
-- delete 와 drop table 의 차이점 알아보기 !!

-- emp_ddl과 동일한 emp테이블을 생성하시오. (단, create와 select 문을 사용하시오.)
create table emp as select * from emp_ddl;
select * from emp_ddl; -- 생성한 테이블 확인하기

-- emp_ddl의 내용을 모두 삭제하시오. (단, delete 명령을 사용하시오.)
delete emp_ddl;
select * from emp_ddl; -- 테이블의 데이터가 삭제되었는지 확인하기

-- emp_ddl테이블에 데이터 추가하기
insert into EMP_DDL values(1001, 'kimsoo', 'developer', 2001, '1981-01-01', 500, 20, 30);
insert into emp_ddl values(1002, 'yoonhoil', 'salesman', 2000, '1991-01-01', 400, 10,30);
insert into emp_ddl values(1003, 'jangsosu', 'developer', 2001, '2001-01-01', 300, 20, 30);


---- DROP TABLE 테이블명 : 테이블의 스키마 구조와 데이터 모두 삭제 ----

-- emp_ddl 테이블과 그 내용을 모두 삭제하시오. 
drop table emp_ddl;
select * from emp_ddl;  -- 테이블이 삭제되었는지 확인
