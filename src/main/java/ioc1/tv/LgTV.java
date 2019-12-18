package ioc1.tv;

import ioc1.speaker.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// xml 에 Bead 으로 등록하진 않았지만 annotation 을 추가했기 때문에
// context namespace 의 component-scan 에 의해 자동으로 스프링 컨테이너의 Bean 으로 등록
@Component("lgTV")
public class LgTV implements TV {
    @Autowired // spring-context.xml 에 SonySpeaker 가 Bean 으로 등록되어 있으므로 Autowired annotation 은 해당 Bean 과 이 객체를 바인딩해준다
//	@Qualifier("apple") // id 를 입력하여 스프링 컨테이너의 어떤 Bean 을 참조할 것인지 지정
//	@Resource(name = "apple") // 위 두 annotation 을 합친 것
    private Speaker speaker;

    public LgTV() {
        System.out.println("===> LgTV 생성");
    }

    public void powerOn() {
        System.out.println("LgTV---power on");
    }

    public void powerOff() {
        System.out.println("LgTV---power off");
    }

    public void volumeUp() {
        speaker.volumeUp();
    }

    public void volumeDown() {
        speaker.volumeDown();
    }
}
