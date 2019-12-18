package ioc1.speaker;


public class SonySpeaker implements Speaker {
    public SonySpeaker() {
        System.out.println("===> SonySpeaker 생성");
    }

    public void volumeUp() {
        System.out.println("SonySpeaker---volume up.");
    }

    public void volumeDown() {
        System.out.println("SonySpeaker---volume down.");
    }
}
