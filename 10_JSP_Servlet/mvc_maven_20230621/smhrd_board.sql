DROP TABLE board_likes;
DROP SEQUENCE board_likes_num_seq;
DROP TABLE boards; --참조하는 테이블을 먼저 삭제
DROP SEQUENCE boards_num_seq;
DROP TABLE users;
DROP USER c##board_dev CASCADE ;

CREATE USER c##board_dev IDENTIFIED BY oracle01 DEFAULT TABLESPACE USERS TEMPORARY TABLESPACE TEMP PROFILE DEFAULT;
GRANT CONNECT, RESOURCE TO c##board_dev;
ALTER USER c##board_dev ACCOUNT UNLOCK ;

-- CONN c##board_dev/oracle01;


--회원 테이블 생성
CREATE TABLE users(
    u_id VARCHAR2(255) PRIMARY KEY, --회원 아이디
    name VARCHAR2(255) NOT NULL, --이름
    pw VARCHAR2(255) NOT NULL, --비밀번호
    hire_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, --가입일
    birth DATE NOT NULL, --생일
    profile_path VARCHAR2(255), --프로필이미지 경로
    gender CHAR, --성별
    state VARCHAR2(10) DEFAULT 'SIGNUP' NOT NULL, --상태
    private CHAR(1) DEFAULT '0' NOT NULL , --비공개 여부
    CONSTRAINT users_gender_ckeck CHECK ( gender in ('M','F') ),
    CONSTRAINT users_state_check CHECK ( state in ('SIGNUP','LEAVE','BLOCK') )
);
--회원 테이블에 데이터 추가
INSERT INTO users (u_id, name, pw, birth, gender) VALUES ('develckm','최경민','1234','1986-05-25','M');
COMMIT;
BEGIN
    FOR i IN 1..60 LOOP
            INSERT INTO USERS (u_id, name, pw, birth, profile_path, gender)
            VALUES (
                           'U' || LPAD(i, 3, '0'), -- Generate u_id
                           'User' || i, -- Generate name
                           'password' || i, -- Generate pw
                           TO_DATE('1990-01-01', 'YYYY-MM-DD') + TRUNC(DBMS_RANDOM.VALUE(1, 10000)), -- Generate random birth date between 1990-01-01 and 2009-12-31
                           'path/to/profile' || 'U' || LPAD(i, 3, '0') || '.jpg', -- Generate profile_path
                           CASE WHEN MOD(i, 2) = 0 THEN 'M' ELSE 'F' END -- Generate gender (alternate between M and F)
                   );
        END LOOP;
    COMMIT;
END;

--게시판 테이블 생성
CREATE TABLE boards(
    b_num NUMBER PRIMARY KEY, --번호
    title VARCHAR2(255) NOT NULL, --제목
    content VARCHAR2(255) NOT NULL, --내용
    create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, --만든 시간
    update_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, --수정한 시간
    private CHAR(1) DEFAULT '0', --비공개 여부(기본값은 공개)
    views NUMBER DEFAULT 0, --??
    u_id VARCHAR2(255) NOT NULL, --회원 아이디
    CONSTRAINT boards_fk_users FOREIGN KEY (u_id) REFERENCES users(u_id) ON DELETE CASCADE
);
--게시물 번호로 사용할 시퀀스 생성
CREATE SEQUENCE boards_num_seq INCREMENT BY 1 START WITH 1;
--게시판 테이블의 데이터 추가
BEGIN
    FOR i IN 1..60 LOOP
            INSERT INTO boards (b_num, title, content, u_id)
            VALUES (
                       boards_num_seq.nextval,
                       '게시글 제목입니다~ ' || i,
                       '게시글 내용입니다~ 우왕~ 게시판이다~' || i,
                       'U' || LPAD(i, 3, '0')
                   );
        END LOOP;
    COMMIT;
END;

--회원 테이블에서 회원 삭제 시, 그 회원의 게시물도 삭제되는 것 확인하는 코드(참조무결성)
DELETE FROM users WHERE u_id = 'U001';
COMMIT;

--게시물좋아요 테이블 생성
CREATE TABLE board_likes( --게시판 : 좋아요 = 1:N 관계
    bl_num NUMBER PRIMARY KEY,
    state VARCHAR2(10) NOT NULL, --상태(좋아요,나빠요,최고에요,슬퍼요)
    u_id VARCHAR2(255) NOT NULL, --회원아이디
    b_num NUMBER NOT NULL, --게시물번호

    CONSTRAINT board_likes_state_check CHECK ( state in ('LIKE','BAD','BEST','SAD') ),
    CONSTRAINT board_likes_uk_u_id_b_num UNIQUE (u_id, b_num)

);
--bl_num필드의 시퀀스 생성
CREATE SEQUENCE board_likes_num_seq;
--게시물좋아요 테이블의 데이터 추가
BEGIN
    FOR i IN 2..30 LOOP
            INSERT INTO board_likes (bl_num, state, u_id, b_num)
            VALUES (
                       board_likes_num_seq.nextval,
                       'LIKE',
                       'U' || LPAD(i, 3, '0'),
                        2
                   );
        END LOOP;
    COMMIT;
END;
BEGIN
    FOR i IN 31..40 LOOP
            INSERT INTO board_likes (bl_num, state, u_id, b_num)
            VALUES (
                       board_likes_num_seq.nextval,
                       'BAD',
                       'U' || LPAD(i, 3, '0'),
                       2
                   );
        END LOOP;
    COMMIT;
END;
BEGIN
    FOR i IN 41..45 LOOP
            INSERT INTO board_likes (bl_num, state, u_id, b_num)
            VALUES (
                       board_likes_num_seq.nextval,
                       'SAD',
                       'U' || LPAD(i, 3, '0'),
                       2
                   );
        END LOOP;
    COMMIT;
END;
BEGIN
    FOR i IN 46..60 LOOP
            INSERT INTO board_likes (bl_num, state, u_id, b_num)
            VALUES (
                       board_likes_num_seq.nextval,
                       'BEST',
                       'U' || LPAD(i, 3, '0'),
                       2
                   );
        END LOOP;
    COMMIT;
END;