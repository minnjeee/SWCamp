
--------------------------------------------------------------------------------------------
-- JOIN

-- 1. 각 테이블을 구성하는 모든 행의 조합
select * from emp, dept order by empno; 

-- 2. 등가조인 : 두 테이블의 deptno필드가 같은(=) 데이터만
select * from emp e, dept d where e.deptno = d.deptno order by empno; 
---- 조인 시, 두 테이블에 동일한 컬럼 존재 시 어느 테이블의 컬럼인지 지정하기
select empno, ename, deptno, dname, loc from emp e, dept d where e.deptno = d.deptno; -- deptno 컬럼에서 에러발생!! => 어느 테이블에서 가져올지 지정해야함
select empno, ename, d.deptno, dname, loc from emp e, dept d where e.deptno = d.deptno;
----- where절에 조건 추가 가능
select empno, ename, sal, d.deptno, dname, loc from emp e, dept d where e.deptno = d.deptno and sal >= 3000;
select empno, ename, sal, d.deptno, dname, loc from emp e, dept d where e.deptno = d.deptno and loc='DALLAS'; -- '='조건이 하나라도 있으면 등가조인

-- 3. 비등가조인
select * from emp e, salgrade s where e.sal between s.losal and s.hisal; 

-- 4. 자체조인 : 테이블 하나를 두개 인 것처럼
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1, EMP E2 
 WHERE E1.MGR = E2.EMPNO;
 
-- 5. 왼쪽 외부 조인
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_empno, e2.ename as mgr_ename
    from emp e1, emp e2
  where e1.mgr = e2.empno(+) 
order by e1.empno;

-- 6. 오른쪽 외부 조인
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_empno, e2.ename as mgr_ename
    from emp e1, emp e2
  where e1.mgr(+) = e2.empno 
order by e1.empno;

--------------------------------------------------------------------------------------------

-- 실습 8-11 : NATURAL JOIN (등가조인)
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,
       DEPTNO, D.DNAME, D.LOC
  FROM EMP E NATURAL JOIN DEPT D
ORDER BY DEPTNO, E.EMPNO;

-- 실습 8-12 : JOIN ~ USING(필드명) (등가조인)
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,
       DEPTNO, D.DNAME, D.LOC
  FROM EMP E JOIN DEPT D USING (DEPTNO)
-- WHERE SAL >= 3000
ORDER BY DEPTNO, E.EMPNO;

-- 실습 8-13 : JOIN ~ ON(조건식)
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,
       E.DEPTNO,
       D.DNAME, D.LOC
  FROM EMP E JOIN DEPT D ON (E.DEPTNO = D.DEPTNO)
-- WHERE SAL <= 3000
ORDER BY E.DEPTNO, EMPNO;

-- 실습 8-14 : LEFT OUTER JOIN ~ ON (조건식)
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1 LEFT OUTER JOIN EMP E2 ON (E1.MGR = E2.EMPNO)
ORDER BY E1.EMPNO;

-- 실습 8-15 : RIGHT OUTER JOIN ~ ON (조건식)
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1 RIGHT OUTER JOIN EMP E2 ON (E1.MGR = E2.EMPNO)
ORDER BY E1.EMPNO, MGR_EMPNO;

-- 실습 8-16 : FULL OUTER JOIN ~ ON (조건식)
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1 FULL OUTER JOIN EMP E2 ON (E1.MGR = E2.EMPNO)
ORDER BY E1.EMPNO;