/*
CREATE SEQUENCE [��������]
INCREMENT BY [��������] --�������ڰ� ����� ���� ������ ���� ����Ʈ�� 1
START WITH [���ۼ���] -- ���ۼ����� ����Ʈ���� �����϶� MINVALUE �����϶� MAXVALUE
NOMINVALUE OR MINVALUE [�ּڰ�] -- NOMINVALUE : ����Ʈ�� ����, �����϶� 1, �����϶� -1028 
                               -- MINVALUE : �ּҰ� ����, ���ۼ��ڿ� �۰ų� ���ƾ��ϰ� MAXVALUE���� �۾ƾ���
NOMAXVALUE OR MAXVALUE [�ִ밪] -- NOMAXVALUE : ����Ʈ�� ����, �����϶� 1027, �����϶� -1
                               -- MAXVALUE : �ִ밪 ����, ���ۼ��ڿ� ���ų� Ŀ���ϰ� MINVALUE���� Ŀ����
CYCLE OR NOCYCLE --CYCLE ������ �ִ밪�� �����ϸ� �ּҰ����� �ٽ� ���� NOCYCLE ������ �ִ밪 ���� �� ������ ��������
CACHE OR NOCACHE --CACHE ������ �޸𸮿� ������ ���� �̸� �Ҵ��ϰ� NOCACHE ������ ���������� �޸𸮿� �Ҵ����� ����
*/

CREATE SEQUENCE EX_SEQ --�������̸� EX_SEQ
    INCREMENT BY 1 --�������� 1
    START WITH 1 --���ۼ��� 1
    MINVALUE 1 --�ּҰ� 1
    MAXVALUE 1000 --�ִ밪 1000
    NOCYCLE --������������
    NOCACHE; --�޸𸮿� �������� �̸��Ҵ�
    
CREATE SEQUENCE EX_SEQ2 --�������̸� EX_SEQ
    INCREMENT BY 2 --�������� 2
    START WITH 1 --���ۼ��� 1
    MINVALUE 1 --�ּҰ� 1
    MAXVALUE 1000 --�ִ밪 1000
    NOCYCLE --������������
    NOCACHE; --�޸𸮿� �������� �̸��Ҵ�
    
CREATE TABLE MEMBER(
    NUM NUMBER NOT NULL,
    NAME VARCHAR2(20)
    );
    
INSERT INTO MEMBER VALUES(EX_SEQ.NEXTVAL, 'ȫ�浿');
INSERT INTO MEMBER VALUES(EX_SEQ.NEXTVAL, '�̱浿');
INSERT INTO MEMBER VALUES(EX_SEQ.NEXTVAL, '��浿');
INSERT INTO MEMBER VALUES(EX_SEQ.NEXTVAL, '�ڱ浿');

SELECT * FROM MEMBER;

INSERT INTO MEMBER VALUES(EX_SEQ2.NEXTVAL, 'ȫ�浿');
INSERT INTO MEMBER VALUES(EX_SEQ2.NEXTVAL, '�̱浿');
INSERT INTO MEMBER VALUES(EX_SEQ2.NEXTVAL, '��浿');
INSERT INTO MEMBER VALUES(EX_SEQ2.NEXTVAL, '�ڱ浿');















