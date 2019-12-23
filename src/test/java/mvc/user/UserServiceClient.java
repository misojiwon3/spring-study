package mvc.user;

import mvc.business.user.UserService;
import mvc.business.user.UserVO;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceClient {

    ClassPathXmlApplicationContext container =
            new ClassPathXmlApplicationContext("business-layer.xml");

    UserService userService = (UserService) container.getBean("userService");

    public static void main(String[] args) {
        // 1. 스프링 컨테이너 구동
        ClassPathXmlApplicationContext container =
                new ClassPathXmlApplicationContext("business-layer.xml");

        // 테스트할 UserService 타입의 객체 Lookup
        UserService userService = (UserService) container.getBean("userService");

        // 3. 검색한 객체 테스트
        UserVO vo = new UserVO();
        vo.setId("test");
        vo.setPassword("test");

        UserVO user = userService.getUser(vo);

        if (user != null) {
            System.out.println(user.getName() + " 로그인 했습니다.");
        } else {
            System.out.println("로그인 실패");
        }
    }

    @Test
    public void insertUser() {
        UserVO vo = new UserVO();
        vo.setId("testuser3");
        vo.setPassword("testuser3");
        vo.setName("testname");

        userService.insertUser(vo);
    }

    @Test
    public void getUser() {
        UserVO vo = new UserVO();
        vo.setId("testuser");

        userService.getUser(vo);
    }

    @Test
    public void getUserList() {
        UserVO vo = new UserVO();
        vo.setName("name");

        for (UserVO user : userService.getUserList(vo)) {
            System.out.println("user : " + user.toString());
        }
        System.out.println("success to get user list");

    }

    @Test
    public void updateUser() {
        UserVO vo = new UserVO();
        vo.setName("testname");
        vo.setId("testuser");

        userService.updateUser(vo);

        System.out.println("success to update user");
    }

    @Test
    public void deleteUser() {
        UserVO vo = new UserVO();
        vo.setId("testuser");

        userService.deleteUser(vo);
        System.out.println("success to delete user");
    }
}

