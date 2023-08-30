/*
CREATE SEQUENCE [시퀀스명]
INCREMENT BY [증감숫자] --증감숫자가 양수면 증가 음수면 감소 디폴트는 1
START WITH [시작숫자] -- 시작숫자의 디폴트값은 증가일때 MINVALUE 감소일때 MAXVALUE
NOMINVALUE OR MINVALUE [최솟값] -- NOMINVALUE : 디폴트값 설정, 증가일때 1, 감소일때 -1028 
                               -- MINVALUE : 최소값 설정, 시작숫자와 작거나 같아야하고 MAXVALUE보다 작아야함
NOMAXVALUE OR MAXVALUE [최대값] -- NOMAXVALUE : 디폴트값 설정, 증가일때 1027, 감소일때 -1
                               -- MAXVALUE : 최대값 설정, 시작숫자와 같거나 커야하고 MINVALUE보다 커야함
CYCLE OR NOCYCLE --CYCLE 설정시 최대값에 도달하면 최소값부터 다시 시작 NOCYCLE 설정시 최대값 생성 시 시퀀스 생성중지
CACHE OR NOCACHE --CACHE 설정시 메모리에 시퀀스 값을 미리 할당하고 NOCACHE 설정시 시퀀스값을 메모리에 할당하지 않음
*/

CREATE SEQUENCE EX_SEQ --시퀀스이름 EX_SEQ
    INCREMENT BY 1 --증감숫자 1
    START WITH 1 --시작숫자 1
    MINVALUE 1 --최소값 1
    MAXVALUE 1000 --최대값 1000
    NOCYCLE --순한하지않음
    NOCACHE; --메모리에 시퀀스값 미리할당
    
CREATE SEQUENCE EX_SEQ2 --시퀀스이름 EX_SEQ
    INCREMENT BY 2 --증감숫자 2
    START WITH 1 --시작숫자 1
    MINVALUE 1 --최소값 1
    MAXVALUE 1000 --최대값 1000
    NOCYCLE --순한하지않음
    NOCACHE; --메모리에 시퀀스값 미리할당
    
CREATE TABLE MEMBER(
    NUM NUMBER NOT NULL,
    NAME VARCHAR2(20)
    );
    
INSERT INTO MEMBER VALUES(EX_SEQ.NEXTVAL, '홍길동');
INSERT INTO MEMBER VALUES(EX_SEQ.NEXTVAL, '이길동');
INSERT INTO MEMBER VALUES(EX_SEQ.NEXTVAL, '김길동');
INSERT INTO MEMBER VALUES(EX_SEQ.NEXTVAL, '박길동');

SELECT * FROM MEMBER;

INSERT INTO MEMBER VALUES(EX_SEQ2.NEXTVAL, '홍길동');
INSERT INTO MEMBER VALUES(EX_SEQ2.NEXTVAL, '이길동');
INSERT INTO MEMBER VALUES(EX_SEQ2.NEXTVAL, '김길동');
INSERT INTO MEMBER VALUES(EX_SEQ2.NEXTVAL, '박길동');















