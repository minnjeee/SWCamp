package co.kr.smhrd.mvc_maven_20230621.model.dao;

import co.kr.smhrd.mvc_maven_20230621.dto.UsersDto;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDaoImp implements UsersDao {
    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    public UsersDaoImp(Connection conn) {
        this.conn = conn;
    }

    @Override
    public UsersDto findByUIdAndPw(String uId, String pw) throws Exception { //로그인
        UsersDto user = null;
        String sql = "SELECT * FROM users WHERE u_id=? AND pw=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uId);
        pstmt.setString(2,pw);
        rs = pstmt.executeQuery();
        if(rs.next()){
            user = parseUsersDto(rs);
        }
        return user;
    }

    @Override
    public UsersDto findByUId(String uId) throws Exception { //개인정보 조회
        UsersDto user = null;
        String sql = "SELECT * FROM users WHERE u_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,uId);
        rs = pstmt.executeQuery();
        if(rs.next()){
            user = parseUsersDto(rs);
        }
        return user;
    }

    private UsersDto parseUsersDto(ResultSet rs) throws SQLException {
        UsersDto user = new UsersDto();
        user.setUId(rs.getString("u_id"));
        user.setName(rs.getString("name"));
        user.setPw(rs.getString("pw"));
        user.setProfilePath(rs.getString("profile_path"));
        user.setState(rs.getString("state"));
        user.setHireDate(rs.getDate("hire_date"));
        user.setBirth(rs.getDate("birth"));
        user.setPrivate(rs.getBoolean("private"));
        user.setGender(rs.getString("gender").charAt(0));
        return user;
    }

    @Override
    public int updateOne(UsersDto user) throws Exception { //개인정보 수정
        int update = 0;
        String sql = "UPDATE users SET state=?, name=?,pw=?,birth=?,profile_path=?,gender=? WHERE u_id=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getState());
        pstmt.setString(2,user.getName());
        pstmt.setString(3, user.getPw());
        pstmt.setDate(4,new java.sql.Date(user.getBirth().getTime()));
        pstmt.setString(5,user.getProfilePath());
        pstmt.setString(6,user.getGender()+"");
        pstmt.setString(7,user.getUId());
        update = pstmt.executeUpdate();
        return update;
    }

    @Override
    public int insertOne(UsersDto user) throws Exception { //회원가입
        int insert = 0;
        String sql = "INSERT INTO users(u_id, name, pw, birth, profile_path, gender) VALUES (?,?,?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1,user.getUId());
        pstmt.setString(2,user.getName());
        pstmt.setString(3, user.getPw());
        pstmt.setDate(4,new java.sql.Date(user.getBirth().getTime()));
        pstmt.setString(5,user.getProfilePath());
        pstmt.setString(6,user.getGender()+"");
        insert = pstmt.executeUpdate();
        return insert;
    }

    @Override
    public int deleteByUIdAndPw(String uId, String pw) throws Exception { //회원 탈퇴
        int delete = 0;
        String sql = "DELETE FROM users WHERE u_id=? AND pw=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, uId);
        pstmt.setString(2,pw);
        delete = pstmt.executeUpdate();
        return delete;
    }
}
