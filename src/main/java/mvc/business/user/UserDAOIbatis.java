package mvc.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import java.util.List;

// 2. DAO(Data Access Object) Class
public class UserDAOIbatis implements UserDAO {

	@Autowired
	private SqlMapClientTemplate iBatis;

	public void insertUser(UserVO vo) {
		System.out.println("===> iBatis 기반으로 insertUser() 처리");
		iBatis.insert("insertUser", vo); // 해당하는
	}
	
	public void updateUser(UserVO vo) {
		System.out.println("===> iBatis 기반으로 updateUser() 처리");
		iBatis.update("updateUser", vo);
	}	
	
	public void deleteUser(UserVO vo) {
		System.out.println("===> iBatis 기반으로 deleteUser() 처리");
		iBatis.delete("deleteUser", vo);
	}	
	
	public UserVO getUser(UserVO vo) {
		System.out.println("===> iBatis 기반으로 getUser() 처리");
		return (UserVO) iBatis.queryForObject("getUser", vo);
	}
	
	public List<UserVO> getUserList(UserVO vo) {
		System.out.println("===> iBatis 기반으로 getUserList() 처리");
		return iBatis.queryForList("getUserList", vo);
	}
}
