package ioc1.tv;

import ioc1.speaker.Speaker;

// spring container 에 등록하지도 않았고 annotation 도 없으므로 이 객체는 컨테이너에 포함되지 않는다
public class GoogleTV implements TV {
    private Speaker speaker;
    private int price;

    public GoogleTV() {
        System.out.println("===> GoogleTV 생성");
    }

    public void setSpeaker(Speaker speaker) {
        System.out.println("---> setSpeaker() speaker setter");
        this.speaker = speaker;
    }

    public void setPrice(int price) {
        System.out.println("---> setPrice() price setter");
        this.price = price;
    }

    public void powerOn() {
        System.out.println("GoogleTV---power on");
    }

    public void powerOff() {
        System.out.println("GoogleTV---power off");
    }

    public void volumeUp() {
        speaker.volumeUp();
    }

    public void volumeDown() {
        speaker.volumeDown();
    }
}
