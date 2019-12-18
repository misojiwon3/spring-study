package ioc2.user;

import java.util.List;

// 3. Service 인터페이스
public interface UserService {

	void insertUser(UserVO vo);

	void updateUser(UserVO vo);

	void deleteUser(UserVO vo);

	UserVO getUser(UserVO vo);

	List<UserVO> getUserList(UserVO vo);
}