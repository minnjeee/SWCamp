package j20230612;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Score{
	
	public static void main(String[] args) {
		try {
			DBConnection dbConnection = new DBConnection();
			Statement stmt = null;
			ResultSet rs = null;
			Connection conn = null;
			Scanner s = new Scanner(System.in);
			String name = null;
			int score = 0;
			
			while(true) {
				System.out.println("명령을 입력하세요(Select, Insert, Delete, Update, Quit)");
				String cmd = s.next();
				conn = dbConnection.getConnection();
				
				if(cmd.equals("select")) {
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from 점수");
					while(rs.next()) {
						System.out.println("이름 : " + rs.getString("name") + ", 점수 : " + rs.getInt("score"));
						System.out.println("===모두 출력 완료===");
					}
					rs.close();
				}
				else if(cmd.equals("insert")) {
					stmt = conn.createStatement();
					System.out.println("추가할 이름 입력 => "); name = s.next();
					System.out.println("추가할 점수 입력 => "); score = s.nextInt();
					stmt.executeUpdate("insert into 점수(name,score) values('" + name + "'," + score + ")");
					System.out.println("===추가 완료===");
				}
				else if(cmd.equals("delete")) {
					stmt = conn.createStatement();
					System.out.println("삭제할 이름 입력 => "); name = s.next();
					stmt.executeUpdate("delete from 점수 where name = '"+name+"'");
					System.out.println("===삭제 완료===");
				}
				else if(cmd.equals("update")) {
					stmt = conn.createStatement();
					System.out.println("변경할 이름 입력 => "); name = s.next();
					System.out.println(name + "님의 점수 => "); score = s.nextInt();
					stmt.executeUpdate("update 점수 set score=" + score + " where name='" + name + "'");
					System.out.println("===변경 완료===");
				}
				else if(cmd.equals("quit")) {
					System.out.println("===종료===");
					break;
				}
				conn.close();
			}
			s.close();
		} catch(SQLException e) {
			System.out.println("에러 발생 => " + e);
		}
		포 기
	}
}
