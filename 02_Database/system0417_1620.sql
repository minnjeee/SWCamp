-----------------------------------------------------------------------------------------
-- ROLLBACK, COMMIT

select * from emp;

-- ������ 50���� ���� (where������ ���� ���� ���ϸ� ��� �����Ϳ� ������ �����)
update emp set comm = 50;
-- ROLLBACK �� ����Ͽ� update�� ����ϱ�
rollback;

-- create�� select ���� �̿��Ͽ� emp���̺��� ������ ������ ������ �����ؼ� emp_ddl���̺��� ����ÿ�
create table emp_ddl as select * from emp where 1<>1;   -- where�� ������ false�� �����ϸ� ������ ����!

-- insert�� select�� Ȱ���Ͽ� emp�� ������ emp_ddl�� �����Ͻÿ�.
insert into emp_ddl select * from emp;
select * from emp_ddl; -- emp ������ ����Ǿ����� Ȯ��

-- empno=1003�� �����͸� �����Ͻÿ�.
delete emp_ddl where empno=1003;
commit;  -- create(ddl���) ������ ��� DML�۾� ���������� ����
rollback; --commit�������� rollback (������� ����!)

---- DESC ���̺�� : ���̺��� ���� Ȯ���ϱ� ----
select * from emp_ddl;
desc emp_ddl; --describe : emp_ddl���̺� ���� Ȯ��



-----------------------------------------------------------------------------------------
-- ���̺� ����

-- emp���̺��� ������ �����͸� �����Ͽ�, emp_alter���̺� ����
create table emp_alter as select * from emp;
select * from emp_alter; -- ���� Ȯ���ϱ�

---- ALTER TABLE ���̺�� ADD �÷��� ������Ÿ�� : ���̺� �÷� �߰��ϱ� ----
-- EMP_ALTER ���̺� HP �ʵ� ���� �߰� (Ÿ���� VARCHAR(20))
alter table emp_alter add hp varchar(20);

-- EMP_ALTER���̺��� HP���� ������ �Է��Ͻÿ�. (��, UPDATE ����� ����Ͻÿ�.)
update emp_alter set hp = '010-1111-2222' where empno=1001;
update emp_alter set hp = '010-2222-2222' where empno=1002;
update emp_alter set hp = '010-3333-2222' where empno=1003;
update emp_alter set hp = '010-4444-2222' where empno=1004; --������ UPDATE�ؾ� �� ��, PYTHON�� FOR������ Ȱ���� �� �ִ�.

---- ALTER TABLE ���̺�� RENAME COLUMN �÷��� TO ���ο��÷��� : �÷��� �����ϱ� ----
-- hp�÷����� tel�� �����ϱ�
alter table emp_alter rename column hp to tel;

---- ALTER TABLE ���̺�� MODIFY �÷��� ���ο����Ÿ�� : �÷��� ������Ÿ�� �����ϱ� ----
-- ������ȣ(empno)�� ������Ÿ���� number(5)�� ����
alter table emp_alter modify empno number(5);
desc emp_alter;  -- �÷� Ÿ�� ����Ǿ����� ���̺� ���� Ȯ��

-- EMP_ALTER ���̺��� ENAME�� VARCHAR2(20)���� �����Ͻÿ�.
alter table emp_alter modify ename varchar2(20);


--- ALTER TABLE ���̺�� DROP COLUMN �÷��� : �÷� �����ϱ� ----
-- emp_alter���̺��� tel �÷� �����ϱ�
alter table emp_alter drop column tel;


---- RENAME ���̺�� TO ���ο����̺�� : ���̺�� �����ϱ� ----
-- emp_alter���̺���� emp_rename���� ����
rename emp_alter to emp_rename;
desc emp_alter;     --����, emp_alter ���̺� �̸��� �ٲپ��� ����.
select * from emp_rename;