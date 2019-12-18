package ioc2.user;

import ioc2.common.JDBCUtil;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

// 2. DAO(Data Access Object) Class
@Repository("userDAO")
public class UserDAO {
	// JDBC 관련 변수 선언
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// USERS 테이블 관련 SQL 명령어들
	private final String USER_GET = "select * from users where id=? and password=?";

	// CRUD 기능의 메소드 구현
	// 사용자 등록
	public void insertUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 insertUser() 처리");
	}
	
	// 사용자 정보 수정
	public void updateUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 updateUser() 처리");
	}	
	
	// 사용자 정보 삭제
	public void deleteUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 deleteUser() 처리");
	}	
	
	// 사용자 정보 상세 조회
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC 기반으로 getUser() 처리");
		UserVO user = null;
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
	
	// ȸ�� ��� �˻�
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> JDBC 기반으로 getUserList() 처리");
		return null;
	}
}
