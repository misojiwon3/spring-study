package ioc1.speaker;

import org.springframework.stereotype.Component;

@Component("appleSpeaker")
public class AppleSpeaker implements Speaker {
    public AppleSpeaker() {
        System.out.println("===> AppleSpeaker 생성");
    }

    public void volumeUp() {
        System.out.println("AppleSpeaker---volume up");
    }

    public void volumeDown() {
        System.out.println("AppleSpeaker---volume down");
    }
}
