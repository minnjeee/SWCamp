package mvc20230619.test;

import java.sql.Connection;

import mvc20230619.dao.DBConnection;
import mvc20230619.dao.StudentDao;
import mvc20230619.dao.StudentDaoImp;
import mvc20230619.dto.StudentDto;

public class StudentDaoTest {

	public static void main(String[] args) {
		try {
			Connection conn = DBConnection.getConn();
			StudentDao dao = new StudentDaoImp(conn);
			//리스트 출력
//			System.out.println(dao.list());
			//상세 출력
//			System.out.println(dao.detail(10000));
			//레코드 삭제
//			System.out.println(dao.delete(10000));
			//레코드 추가
//			StudentDto dto = new StudentDto();
//			dto.setNum(5);
//			dto.setName("신짱구");
//			dto.setPhone("010-1111-3322");
//			dto.setAddress("짱구는 못말려");
//			dto.setBirthday("94/05/05");
//			System.out.println(dao.insert(dto));
//			System.out.println(dao.list());
			//레코드 수정
			StudentDto dto2 = new StudentDto();
			dto2.setNum(20000);
			dto2.setName("민지");
			dto2.setPhone("010-1111-2222");
			dto2.setAddress("서울시 서대문구");
			dto2.setBirthday("98/11/05");
			System.out.println(dao.update(dto2));
			System.out.println(dao.list());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
