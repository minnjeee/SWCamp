-- ���̺� emp, dept�� ������ Ȯ��
select * from emp;
select * from dept;


--------------------------------------------------------------------------------------------
-- �����Լ� : sum, count, max, min, avg
-- �����Լ�([distinct | all] �÷���)

-- �޿� �÷� ��ȸ
select sal from emp;
-- sum�Լ��� �޿��԰� ��ȸ
select sum(sal) as �޿��հ� from emp;

select ename, sum(sal) as �޿��հ� from emp; --���� �߻�, ������ ������ �ٸ�
select sum(distinct sal), sum(all sal), sum(sal) from emp; --distinct:�ߺ�����, all:�󰪵�����

-- ������ ���� : count(*)
select count(*) from emp;
select count(distinct sal), count(all sal), count(sal) from emp;

select count(comm) from emp;
select count(comm) from emp where comm is not null; --not null ���Ǿ��� ���� ������ ���

select max(sal), min(sal) from emp where deptno=10;
select max(hiredate), min(hiredate) from emp; -- max(��¥):�����ֱ�, min(��¥):��������ȳ�

-- �� �μ���ȣ(10,20,30)�� �ش��ϴ� �޿�(sal) ��� ��ȸ
SELECT AVG(SAL), '10' AS DEPTNO FROM EMP WHERE DEPTNO = 10 --�μ���ȣ=10�� sal���
UNION ALL --������, �ߺ����
SELECT AVG(SAL), '20' AS DEPTNO FROM EMP WHERE DEPTNO = 20 --�μ���ȣ=20�� sal���
UNION ALL
SELECT AVG(SAL), '30' AS DEPTNO FROM EMP WHERE DEPTNO = 30; --�μ���ȣ=30�� sal���

-- �μ���ȣ�� SAL��հ� �μ���ȣ
select avg(sal), deptno from emp group by deptno;
-- �μ���ȣ�� ������ sal���(�μ���ȣ�� ��������, ������� ��������)
select deptno, job, avg(sal) from emp 
    group by deptno,job 
    order by deptno,avg(sal) desc;
-- �μ���ȣ�� ������ sal����� 2000�̻��� �׷��� �μ���ȣ, ��å, �޿����(�μ���ȣ�� ��������, ������� ��������)
select deptno, job, avg(sal) from emp
    group by deptno, job having avg(sal) >=2000 -- �׷�ȭ�������� having������ �����(where���� ���� �����߻�)
    order by deptno,avg(sal) desc;
-- �޿��� 3000������ ������ �߿��� �μ���ȣ�� ������ sal����� 2000�̻��� �׷��� �μ���ȣ, ��å, �޿����(�μ���ȣ�� ��������, ������� ��������)
select deptno,job,avg(sal) from emp where sal<=3000
    group by deptno,job having avg(sal) >=2000
    order by deptno,avg(sal) desc;


--------------------------------------------------------------------------------------------
-- �׷��Լ� : rollup, cube, grouping sets

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
    
