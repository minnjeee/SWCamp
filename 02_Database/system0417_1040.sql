DROP TABLE EMP_DDL;

-- ���� ���̺�(EMP_DDL) �����ϱ�
CREATE TABLE EMP_DDL(
    EMPNO NUMBER(4),    -- ������ȣ
    ENAME VARCHAR2(20), -- �����̸�
    JOB VARCHAR2(9),    -- ��å
    MGR NUMBER(4),      -- ����ȣ
    HIREDATE DATE,      -- �Ի�����
    SAL NUMBER(7,2),    -- �޿� (NUMBER(7,2) : ��7�ڸ� �߿��� �Ҽ������� 2��° �ڸ�)
    COMM NUMBER(7,2),   -- ����
    DEPTNO NUMBER(2)    -- �μ���ȣ
);

-- ���� ���̺�(EMP_DDL)�� ������ �߰��ϱ�
insert into emp_ddl values(1001, 'kimsoo', 'developer', 2001, '1981-01-01', 500, 20, 30);   -- ���̺�� �ڿ� �÷��� �������ϸ�, values �ڿ� ��� �÷��� �����ǰ� �� ����
insert into emp_ddl values(1002, 'yoonhoil', 'salesman', 2000, '1991-01-01', 400, 10,30);
insert into emp_ddl values(1003, 'jangsosu', 'developer', 2001, '2001-01-01', 300, 20, 30);
insert into emp_ddl(empno, hiredate, sal, comm, deptno) values(1004, '2001-01-01', 300, 20, 30);  -- ���̺��(�÷���1, �÷���2) �÷��� �����ϸ�, values(��1, ��2) �� �ش� �÷��� ���� ����
insert into emp_ddl(job, mgr, ename) values('salesman', 2003, 'hanjinsa');                        -- ���� ���� �÷����� �ڵ����� null�� ���Ե�


---- UPDATE ���̺�� SET �÷���1 = ��1, �÷���2 = ��2 [WHERE ����] : ���̺��� ���ǿ� �����ϴ� ���ڵ��� �÷� �� �����ϱ� ----

-- ���� ���̺�(EMP_DDL)���� ������ȣ(empno)�� 1004�� ������ �̸��� hanjinsa��, ��å�� salesman����, ����ȣ�� 2003���� �����ϱ�
update emp_ddl set ename = 'hanjinsa', job = 'salesman', mgr = 2003 where empno = 1004;

-- �Ի����� 2000�� ������ �Ի��� ������� ����(comm)�� 40���� �����Ͻÿ�
update emp_ddl set comm = 40 where hiredate < '2000-01-01';
select comm, hiredate from emp_ddl where hiredate < '2000-01-01'; --������ ������ Ȯ���ϱ�

-- mgr�� 2001�� ����� �޿�(sal)�� 1.5��� �λ��Ͻÿ�.
update emp_ddl set sal = sal * 1.5 where mgr = 2001;
select sal, mgr from emp_ddl where mgr = 2001; --������ ������ Ȯ���ϱ�

---- DELETE FROM ���̺�� [WHERE ���ǽ�] : ���̺��� ������ �����ϴ� ���ڵ� �����ϱ� ----

-- ������ȣ(empno)�� ����ִ� ���� ������ �����ϱ�
delete from emp_ddl where empno is null;


-----------------------------------------------------------------------------------------
-- delete �� drop table �� ������ �˾ƺ��� !!

-- emp_ddl�� ������ emp���̺��� �����Ͻÿ�. (��, create�� select ���� ����Ͻÿ�.)
create table emp as select * from emp_ddl;
select * from emp_ddl; -- ������ ���̺� Ȯ���ϱ�

-- emp_ddl�� ������ ��� �����Ͻÿ�. (��, delete ����� ����Ͻÿ�.)
delete emp_ddl;
select * from emp_ddl; -- ���̺��� �����Ͱ� �����Ǿ����� Ȯ���ϱ�

-- emp_ddl���̺� ������ �߰��ϱ�
insert into EMP_DDL values(1001, 'kimsoo', 'developer', 2001, '1981-01-01', 500, 20, 30);
insert into emp_ddl values(1002, 'yoonhoil', 'salesman', 2000, '1991-01-01', 400, 10,30);
insert into emp_ddl values(1003, 'jangsosu', 'developer', 2001, '2001-01-01', 300, 20, 30);


---- DROP TABLE ���̺�� : ���̺��� ��Ű�� ������ ������ ��� ���� ----

-- emp_ddl ���̺�� �� ������ ��� �����Ͻÿ�. 
drop table emp_ddl;
select * from emp_ddl;  -- ���̺��� �����Ǿ����� Ȯ��
