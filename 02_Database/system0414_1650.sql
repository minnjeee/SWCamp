-- CREATE TABLE ���̺��(�÷��� ������Ÿ�� [NOT NULL], ... ) : ���̺� �����ϱ�
-- ȸ������ ��, ȸ�� �����͸� ������ omember���̺� �����ϱ�
create table omember(
    num int not null,            -- ȸ����ȣ
    email varchar(50) not null,  -- �̸���
    pwd varchar(20) not null,    -- ��й�ȣ
    pwdc varchar(20) not null,   -- ��й�ȣ Ȯ��
    name varchar(20) not null,   -- �̸�
    tel varchar(15) not null,    -- ��ȭ��ȣ
    addr varchar(100),           -- �ּ�
    primary key (num)   -- ȸ����ȣ�� �⺻Ű�� ����
);

-- INSERT INTO ���̺��(�÷���,...) VALUES(��,...) : ���̺� ������ �߰�/�����ϱ�
INSERT INTO OMEMBER VALUES(1, 'minjee3333@gmail.com', 'oracle1', 'oracle1','Kim','010-2900-4039','����� ���빮��');
INSERT INTO OMEMBER VALUES(2, 'minjee3333@naver.com', 'oracle2', 'oracle2','Park','010-9171-6138','���� ������');


-- AS SELECT�� �̿� : ���� ���̺��� ������ �����͸� �����Ͽ� ���ο� ���̺� �����ϱ�

-- omember���̺��� ������ �����ؼ� omembercopy ��� �̸��� ���̺��� �����Ͻÿ�.
-- ��, create���� select���� �ݵ�� ����Ͻÿ�.
create table omembercopy
    as select * from omember;

-- omember���̺��� ��ȣ,�̸�,�̸����� �����ؼ� omemberpart ��� �̸��� ���̺��� �����Ͻÿ�.
-- ��, create���� select���� �ݵ�� ����Ͻÿ�.
create table omemberpart
    as select num, name, email from omember;