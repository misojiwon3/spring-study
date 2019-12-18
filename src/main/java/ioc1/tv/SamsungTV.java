package ioc1.tv;

import ioc1.speaker.Speaker;

// SamsungTV 를 spring-context.xml 에 Bean 으로 등록해 두었기 때문에 lookup 이 가능
public class SamsungTV implements TV {
    private Speaker speaker;
    private int price;

    public SamsungTV() {
        System.out.println("===> SamsungTV (1) 생성");
    }

    public SamsungTV(Speaker speaker) {
        System.out.println("===> SamsungTV (2) 생성");
        this.speaker = speaker;
    }

    public SamsungTV(Speaker speaker, int price) {
        System.out.println("===> SamsungTV (3) 생성");
        this.speaker = speaker;
        this.price = price;
    }

    public void powerOn() {
        System.out.println("SamsungTV--- power on : " + price);
    }

    public void powerOff() {
        System.out.println("SamsungTV---power off");
    }

    public void volumeUp() {
        speaker.volumeUp();
    }

    public void volumeDown() {
        speaker.volumeDown();
    }
}
