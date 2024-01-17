package co.kr.smhrd.mvc_maven_20230621.model.dao;

import co.kr.smhrd.mvc_maven_20230621.dto.UsersDto;
import co.kr.smhrd.mvc_maven_20230621.model.DBConnection;
import org.junit.jupiter.api.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*; //테스트를 상세하게 진행하도록 도움

@TestMethodOrder(MethodOrderer.OrderAnnotation.class) //@Test에 순서 @Order(1~) 지정
class UsersDaoImpTest {
    private static UsersDao usersDao;
    @BeforeAll // @Test 들이 시작되기 전에 시작
    static void init() throws Exception{
        usersDao = new UsersDaoImp(DBConnection.getInstance());
    }

    //@Test : 단위 테스트, @Test 간의 순서가 존재하지 않음 (@TestOrderedMethod 를 사용하면 순서 지정은 가능)
    @Order(2)
    @Test
    void findByUIdAndPw() throws Exception {
        UsersDto user = (usersDao.findByUIdAndPw("U999","1234"));
        System.out.println(user.toString());
        assertNotNull(user); //user가 null이면 test실패, 아니면 성공
    }
    @Order(3)
    @Test
    void findByUId() throws Exception {
        UsersDto user = usersDao.findByUId("U003");
        System.out.println(user);
    }
    
    @Order(4)
    @Test
    void updateOne() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //문자열을 Date객체로 변환
        Date birth = sdf.parse("1998-11-05"); //=>'yyyy-MM-dd' 패턴으로 판단해서 Date객체로 변환
        UsersDto user = new UsersDto();
        user.setUId("U003");
        user.setPw("1234");
        user.setName("김민지");
        user.setBirth(birth); //**dto만들 때 오라클 Date타입은 문자열로 처리하기!
        // Oracle Timestamp == java.util.Date
        user.setProfilePath("/test/경로.jpg");
        user.setState("LEAVE");
        user.setGender('F');
        int update = 0;
        update = usersDao.updateOne(user);
        assertTrue(update>0); //또는 assertEquals(update,1);
    }

    @Order(1)
    @Test
    void insertOne() throws Exception {
        int insert = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = sdf.parse("1998-11-05");
        UsersDto user = new UsersDto();
        user.setUId("U999");
        user.setPw("1234");
        user.setName("test");
        user.setBirth(birth);
        user.setProfilePath("/test/U999.jpg");
        user.setGender('M');
        insert = usersDao.insertOne(user);
        assertTrue(insert>0);
    }
    @Order(5)
    @Test
    void deleteByUIdAndPw() throws Exception {
        int delete = usersDao.deleteByUIdAndPw("U999","1234");
        assertTrue(delete>0);
    }
}