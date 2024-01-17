package co.kr.smhrd.mvc_maven_20230621.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
/*
* 팩토리 메서드 패턴 dto, vo
* PlanOloJavaObject(POJO) : 자바에서 예날부터 사용하던 디자인 패턴
* boolean은 is로 함수 이름을 정의
* **jdbc패키지에서 Data객체를 제공하고 있는데, 많은 개발자들이 사용하지 않음 (java.sql.Date가 아닌 java.util.Date 사용)
*
* */

@Getter@Setter@ToString //lombok - 컴파일 시 자동 완성
public class UsersDto {
//    @Override
//    public String toString() {
//        return "UsersDto{" +
//                "uId='" + uId + '\'' +
//                ", name='" + name + '\'' +
//                ", pw='" + pw + '\'' +
//                ", hireDate=" + hireDate +
//                ", birth=" + birth +
//                ", profilePath='" + profilePath + '\'' +
//                ", gender=" + gender +
//                ", state='" + state + '\'' +
//                ", Private=" + Private +
//                '}';
//    }

    //u_id : db는 대소문자 구분이 없어서 _규칙 사용 (자바에서는 낙타표기법)
    private String uId;
    private String name;
    private String pw;
    private Date hireDate;
    private Date birth; //String인 것을 권장! (오라클 date는 문자열에 가까움)
    private String profilePath;
    private char gender;
    private String state;
    private boolean Private; //oracle char(1) -> java boolean

//    public String getUId() {
//        return uId;
//    }
//
//    public void setUId(String uId) {
//        this.uId = uId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getPw() {
//        return pw;
//    }
//
//    public void setPw(String pw) {
//        this.pw = pw;
//    }
//
//    public Date getHireDate() {
//        return hireDate;
//    }
//
//    public void setHireDate(Date hireDate) {
//        this.hireDate = hireDate;
//    }
//
//    public Date getBirth() {
//        return birth;
//    }
//
//    public void setBirth(Date birth) {
//        this.birth = birth;
//    }
//
//    public String getProfilePath() {
//        return profilePath;
//    }
//
//    public void setProfilePath(String profilePath) {
//        this.profilePath = profilePath;
//    }
//
//    public char getGender() {
//        return gender;
//    }
//
//    public void setGender(char gender) {
//        this.gender = gender;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public boolean isPrivate() {
//        return Private;
//    }
//
//    public void setPrivate(boolean aPrivate) {
//        Private = aPrivate;
//    }
}
