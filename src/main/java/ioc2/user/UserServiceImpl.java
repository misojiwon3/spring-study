package ioc2.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 4. Service 구현 클래스
@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	public void insertUser(UserVO vo) {
	}

	public void updateUser(UserVO vo) {
	}

	public void deleteUser(UserVO vo) {
	}

	public UserVO getUser(UserVO vo) {
		return userDAO.getUser(vo);
	}

	public List<UserVO> getUserList(UserVO vo) {
		return null;
	}

}
