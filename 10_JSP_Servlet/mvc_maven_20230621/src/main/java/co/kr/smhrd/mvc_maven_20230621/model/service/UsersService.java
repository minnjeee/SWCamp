package co.kr.smhrd.mvc_maven_20230621.model.service;

import co.kr.smhrd.mvc_maven_20230621.dto.UsersDto;

public interface UsersService {
    //로그인, 개인정보 조회, 개인정보 수정, 회원가입, 회원탈퇴, 회원조회리스트(팔로우)
    // dao : 쿼리 실행 단위
    // service : 유저에게 제공되는 서비스 단위 (==transaction)
    // ex. 은행 업무
    //   계좌 이체(서비스) : 여러 dao가 합쳐져서 하나의 서비스를 완성
    //      내 계좌의 돈을 업데이터 (dao)
    //      은행에 계좌이제 내역 저장(dao)
    //      받는 사람의 계좌의 돈을 업데이터 (dao)
    //wepapp 을 만들다 보면 대부분 das : service = 1:1 But, 아닌 것들도 존재해서 꼭 서비스 만든다.
    UsersDto login(String uId, String pw); //로그인
    UsersDto detail(String uId); //개인정보 조회
    int modify(UsersDto user); //개인정보 수정
    int signup(UsersDto user); //회원가입
    int remove(String uId, String pw); //회원탈퇴

}
