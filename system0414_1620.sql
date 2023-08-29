-- HELP 테이블 을 사용하여 SELECT 문 연습하기

-- SELECT 컬럼명 FROM 테이블명 : 테이블에서 모든 레코드의 지정한 컬럼 조회
-- help테이블의 모든 컬럼 조회
SELECT * FROM HELP;
-- help테이블의 topic 컬럼 조회
select topic from help;
-- help테이블의 topic, seq 컬럼 조회
select topic, seq from help;

-- SELECT 컬럼명 FROM 테이블명 WHERE 조건식 : 테이블에서 조건을 만족하는 레코드의 지정한 컬럼만 조회
-- help테이블에서 topic이 'BREAK' 인 데이터의 topic, seq 컬럼 조회
select topic, seq from help where topic = 'BREAK';
-- as : 칼럼명/테이블명에 별칭 지정
select topic as "제목", seq as "순서" from help where topic = 'BREAK';
select topic "제목", seq "순서" from help where topic = 'BREAK'; -- 별칭 지정 시, as 생략 가능

-- SELECT [ALL | DISTINCT] 컬럼명 FROM 테이블명
-- all : 디폴트 값, 중복 허용하여 모든 데이터 조회
select all topic from help;
-- distinct : 중복 제거하여 데이터 조회
select distinct topic from help;

-- SELECT 컬럼명 FROM 테이블명 ORDER BY 정렬컬럼 [ASC | DESC] : 정렬컬럼 기준으로 레코드를 정렬 (ASC : 오름차순, DESC : 내림차순)
-- help테이블에서 topic 컬럼을 중복을 제거하여 topic 기준으로 내림차순 정렬
select distinct topic from help order by topic desc;

----------------------------------------------------------------------------------

-- 연습문제 1)
-- HELP 테이블에서 제목, 순서, 내용이라는 필드이름을 사용해서 모든 데이터를 출력
-- 단, SEQ에 대해 내림차순, 제목에 대해 오름차순 정렬
SELECT TOPIC "제목" , SEQ "순서", INFO "내용" FROM HELP ORDER BY SEQ DESC, TOPIC;

-- 연습문제 2)
--HELP 테이블을 사용하여 번호가 2번인 TOPIC과 INFO만 출력
SELECT TOPIC, INFO FROM HELP WHERE SEQ = 2;

