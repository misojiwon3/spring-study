package mvc.business.user;

import java.util.List;

// 3. Service Interface
public interface UserService {

	void insertUser(UserVO vo);

	void updateUser(UserVO vo);

	void deleteUser(UserVO vo);

	UserVO getUser(UserVO vo);

	List<UserVO> getUserList(UserVO vo);

}