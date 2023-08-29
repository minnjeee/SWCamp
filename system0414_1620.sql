-- HELP ���̺� �� ����Ͽ� SELECT �� �����ϱ�

-- SELECT �÷��� FROM ���̺�� : ���̺��� ��� ���ڵ��� ������ �÷� ��ȸ
-- help���̺��� ��� �÷� ��ȸ
SELECT * FROM HELP;
-- help���̺��� topic �÷� ��ȸ
select topic from help;
-- help���̺��� topic, seq �÷� ��ȸ
select topic, seq from help;

-- SELECT �÷��� FROM ���̺�� WHERE ���ǽ� : ���̺��� ������ �����ϴ� ���ڵ��� ������ �÷��� ��ȸ
-- help���̺��� topic�� 'BREAK' �� �������� topic, seq �÷� ��ȸ
select topic, seq from help where topic = 'BREAK';
-- as : Į����/���̺�� ��Ī ����
select topic as "����", seq as "����" from help where topic = 'BREAK';
select topic "����", seq "����" from help where topic = 'BREAK'; -- ��Ī ���� ��, as ���� ����

-- SELECT [ALL | DISTINCT] �÷��� FROM ���̺��
-- all : ����Ʈ ��, �ߺ� ����Ͽ� ��� ������ ��ȸ
select all topic from help;
-- distinct : �ߺ� �����Ͽ� ������ ��ȸ
select distinct topic from help;

-- SELECT �÷��� FROM ���̺�� ORDER BY �����÷� [ASC | DESC] : �����÷� �������� ���ڵ带 ���� (ASC : ��������, DESC : ��������)
-- help���̺��� topic �÷��� �ߺ��� �����Ͽ� topic �������� �������� ����
select distinct topic from help order by topic desc;

----------------------------------------------------------------------------------

-- �������� 1)
-- HELP ���̺��� ����, ����, �����̶�� �ʵ��̸��� ����ؼ� ��� �����͸� ���
-- ��, SEQ�� ���� ��������, ���� ���� �������� ����
SELECT TOPIC "����" , SEQ "����", INFO "����" FROM HELP ORDER BY SEQ DESC, TOPIC;

-- �������� 2)
--HELP ���̺��� ����Ͽ� ��ȣ�� 2���� TOPIC�� INFO�� ���
SELECT TOPIC, INFO FROM HELP WHERE SEQ = 2;

