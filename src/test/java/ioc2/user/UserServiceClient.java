package ioc2.user;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceClient {

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
}
