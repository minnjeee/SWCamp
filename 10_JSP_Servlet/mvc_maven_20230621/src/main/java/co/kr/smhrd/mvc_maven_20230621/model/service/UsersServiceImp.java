package co.kr.smhrd.mvc_maven_20230621.model.service;

import co.kr.smhrd.mvc_maven_20230621.dto.UsersDto;
import co.kr.smhrd.mvc_maven_20230621.model.DBConnection;
import co.kr.smhrd.mvc_maven_20230621.model.dao.UsersDao;
import co.kr.smhrd.mvc_maven_20230621.model.dao.UsersDaoImp;

import java.sql.Connection;

public class UsersServiceImp implements UsersService {
    //Connection conn : service 에서 사용하면 commit, rollback 같은 TCL 사용 가능
    // => service 는 DB를 소비하는 마지막 주체
    private UsersDao usersDao = null;
    private Connection conn = null;
    public UsersServiceImp(){
        try {
            conn = DBConnection.getInstance();
            usersDao = new UsersDaoImp(conn);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public UsersDto login(String uId, String pw){
        UsersDto login = null;
        try {
            login = usersDao.findByUIdAndPw(uId, pw);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return login;
    }

    @Override
    public UsersDto detail(String uId) {
        UsersDto detail = null;
        try {
            detail = usersDao.findByUId(uId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return detail;
    }

    @Override
    public int modify(UsersDto user) {
        int modify = 0;
        try {
            modify = usersDao.updateOne(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return modify;
    }

    @Override
    public int signup(UsersDto user) {
        int signup = 0;
        try {
            signup = usersDao.insertOne(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return signup;
    }

    @Override
    public int remove(String uId, String pw) {
        int remove = 0;
        try {
            remove = usersDao.deleteByUIdAndPw(uId,pw);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return remove;
    }
}
