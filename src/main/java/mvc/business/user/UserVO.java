package mvc.business.user;

import lombok.Data;

// 1. VO Class
@Data
public class UserVO {
	private String id;
	private String password;
	private String name;
	private String role;
}
