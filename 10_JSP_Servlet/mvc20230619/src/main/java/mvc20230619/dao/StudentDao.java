package mvc20230619.dao;

import java.util.List;

import mvc20230619.dto.StudentDto;

//dao : DB Applicaton Object
public interface StudentDao { //CRUD형태
	//db에서 제공하는 서비스는 거기서 거기더라~ => 미리 명시 (추상화)
	//DQL list, detail
	//DML update,delete,insert
	//**db접속 오류를 동반한다.
	List<StudentDto> list() throws Exception;
	StudentDto detail(int num) throws Exception;
	int delete(int num) throws Exception;
	int update(StudentDto student) throws Exception;
	int insert(StudentDto student) throws Exception;
}
