package ioc1;

import ioc1.tv.TV;
import org.springframework.context.support.ClassPathXmlApplicationContext;

// 다형성 = 상속 + Overriding + 형변환
public class TVUser {
	public static void main(String[] args) {

		// 여기서 사용하는 방식은 dependency lookup 방식

		// 1. 스프링 컨테이너를 생성(구동)
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext("spring-context.xml");
		
		// 2. 스프링 컨테이너(xml 파일에 설정)로부터 테스트 할 객체를 검색(Lookup)
		TV tv = (TV) container.getBean("samsungTV");
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
		
		// 3. 스프링 컨테이너 종료
		container.close();
	}
}
