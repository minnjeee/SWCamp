
--------------------------------------------------------------------------------------------
-- JOIN

-- 1. �� ���̺��� �����ϴ� ��� ���� ����
select * from emp, dept order by empno; 

-- 2. ����� : �� ���̺��� deptno�ʵ尡 ����(=) �����͸�
select * from emp e, dept d where e.deptno = d.deptno order by empno; 
---- ���� ��, �� ���̺� ������ �÷� ���� �� ��� ���̺��� �÷����� �����ϱ�
select empno, ename, deptno, dname, loc from emp e, dept d where e.deptno = d.deptno; -- deptno �÷����� �����߻�!! => ��� ���̺��� �������� �����ؾ���
select empno, ename, d.deptno, dname, loc from emp e, dept d where e.deptno = d.deptno;
----- where���� ���� �߰� ����
select empno, ename, sal, d.deptno, dname, loc from emp e, dept d where e.deptno = d.deptno and sal >= 3000;
select empno, ename, sal, d.deptno, dname, loc from emp e, dept d where e.deptno = d.deptno and loc='DALLAS'; -- '='������ �ϳ��� ������ �����

-- 3. ������
select * from emp e, salgrade s where e.sal between s.losal and s.hisal; 

-- 4. ��ü���� : ���̺� �ϳ��� �ΰ� �� ��ó��
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1, EMP E2 
 WHERE E1.MGR = E2.EMPNO;
 
-- 5. ���� �ܺ� ����
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_empno, e2.ename as mgr_ename
    from emp e1, emp e2
  where e1.mgr = e2.empno(+) 
order by e1.empno;

-- 6. ������ �ܺ� ����
select e1.empno, e1.ename, e1.mgr, e2.empno as mgr_empno, e2.ename as mgr_ename
    from emp e1, emp e2
  where e1.mgr(+) = e2.empno 
order by e1.empno;

--------------------------------------------------------------------------------------------

-- �ǽ� 8-11 : NATURAL JOIN (�����)
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,
       DEPTNO, D.DNAME, D.LOC
  FROM EMP E NATURAL JOIN DEPT D
ORDER BY DEPTNO, E.EMPNO;

-- �ǽ� 8-12 : JOIN ~ USING(�ʵ��) (�����)
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,
       DEPTNO, D.DNAME, D.LOC
  FROM EMP E JOIN DEPT D USING (DEPTNO)
-- WHERE SAL >= 3000
ORDER BY DEPTNO, E.EMPNO;

-- �ǽ� 8-13 : JOIN ~ ON(���ǽ�)
SELECT E.EMPNO, E.ENAME, E.JOB, E.MGR, E.HIREDATE, E.SAL, E.COMM,
       E.DEPTNO,
       D.DNAME, D.LOC
  FROM EMP E JOIN DEPT D ON (E.DEPTNO = D.DEPTNO)
-- WHERE SAL <= 3000
ORDER BY E.DEPTNO, EMPNO;

-- �ǽ� 8-14 : LEFT OUTER JOIN ~ ON (���ǽ�)
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1 LEFT OUTER JOIN EMP E2 ON (E1.MGR = E2.EMPNO)
ORDER BY E1.EMPNO;

-- �ǽ� 8-15 : RIGHT OUTER JOIN ~ ON (���ǽ�)
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1 RIGHT OUTER JOIN EMP E2 ON (E1.MGR = E2.EMPNO)
ORDER BY E1.EMPNO, MGR_EMPNO;

-- �ǽ� 8-16 : FULL OUTER JOIN ~ ON (���ǽ�)
SELECT E1.EMPNO, E1.ENAME, E1.MGR,
       E2.EMPNO AS MGR_EMPNO,
       E2.ENAME AS MGR_ENAME
  FROM EMP E1 FULL OUTER JOIN EMP E2 ON (E1.MGR = E2.EMPNO)
ORDER BY E1.EMPNO;