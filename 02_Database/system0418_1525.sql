-- 테이블 emp, dept의 데이터 확인
select * from emp;
select * from dept;


--------------------------------------------------------------------------------------------
-- 집계함수 : sum, count, max, min, avg
-- 집계함수([distinct | all] 컬럼명)

-- 급여 컬럼 조회
select sal from emp;
-- sum함수로 급여함계 조회
select sum(sal) as 급여합계 from emp;

select ename, sum(sal) as 급여합계 from emp; --에러 발생, 데이터 갯수가 다름
select sum(distinct sal), sum(all sal), sum(sal) from emp; --distinct:중복제거, all:빈값도포함

-- 데이터 개수 : count(*)
select count(*) from emp;
select count(distinct sal), count(all sal), count(sal) from emp;

select count(comm) from emp;
select count(comm) from emp where comm is not null; --not null 조건없을 때와 동일한 결과

select max(sal), min(sal) from emp where deptno=10;
select max(hiredate), min(hiredate) from emp; -- max(날짜):가장최근, min(날짜):가장오래된날

-- 각 부서번호(10,20,30)에 해당하는 급여(sal) 평균 조회
SELECT AVG(SAL), '10' AS DEPTNO FROM EMP WHERE DEPTNO = 10 --부서번호=10인 sal평균
UNION ALL --합집합, 중복허용
SELECT AVG(SAL), '20' AS DEPTNO FROM EMP WHERE DEPTNO = 20 --부서번호=20인 sal평균
UNION ALL
SELECT AVG(SAL), '30' AS DEPTNO FROM EMP WHERE DEPTNO = 30; --부서번호=30인 sal평균

-- 부서번호별 SAL평균과 부서번호
select avg(sal), deptno from emp group by deptno;
-- 부서번호별 직업별 sal평균(부서번호로 오름차순, 평균으로 내림차순)
select deptno, job, avg(sal) from emp 
    group by deptno,job 
    order by deptno,avg(sal) desc;
-- 부서번호별 직업별 sal평균이 2000이상인 그룹의 부서번호, 직책, 급여평균(부서번호로 오름차순, 평균으로 내림차순)
select deptno, job, avg(sal) from emp
    group by deptno, job having avg(sal) >=2000 -- 그룹화된조건은 having절에서 써야함(where절에 쓰면 에러발생)
    order by deptno,avg(sal) desc;
-- 급여가 3000이하인 데이터 중에서 부서번호별 직업별 sal평균이 2000이상인 그룹의 부서번호, 직책, 급여평균(부서번호로 오름차순, 평균으로 내림차순)
select deptno,job,avg(sal) from emp where sal<=3000
    group by deptno,job having avg(sal) >=2000
    order by deptno,avg(sal) desc;


--------------------------------------------------------------------------------------------
-- 그룹함수 : rollup, cube, grouping sets

select deptno,job,count(*),max(sal),sum(sal),avg(sal)   
  from emp
    group by deptno,job     
    order by deptno,job;

-- rollup
select deptno,job,count(*),max(sal),sum(sal),avg(sal)   
  from emp 
    group by ROLLUP(deptno,job) 
    order by deptno,job;
-- CUBE
select deptno,job,count(*),max(sal),sum(sal),avg(sal)   
  from emp
    group by CUBE(deptno,job) 
    order by deptno,job;
-- GROUPING SETS
select deptno,job,count(*),max(sal),sum(sal),avg(sal)   
  from emp 
    group by GROUPING SETS(deptno,job,()) 
    order by deptno,job;
    
