package ch08.interfacee.defaultmethod;

public class Audio implements RemoteControl {
    //필드
    private int volume;
    private int memoryVolume;

    //추상 메서드 오버라이딩
    @Override
    public void turnOn() {
        System.out.println("Audio를 켭니다");
    }

    @Override
    public void turnOff() {
        System.out.println("Audio를 끕니다");
    }

    @Override
    public void setVolume(int volume) {
        if(volume > RemoteControl.MAX_VOLUME) {
            this.volume = RemoteControl.MAX_VOLUME;
        } else if (volume < RemoteControl.MIN_VOLUME) {
            this.volume = RemoteControl.MIN_VOLUME;
        } else {
            this.volume = volume;
        }
        System.out.println("현재 AUDIO 볼륨: " + this.volume);
    }

    //디폴트 메서드 재정의
    @Override
    public void setMute(boolean mute) {
        if(mute) {
            this.memoryVolume = this.volume;
            System.out.println("오디오 무음~!");
            setVolume(RemoteControl.MIN_VOLUME);
        } else {
            System.out.println("오디오 무음~해제~!");
            setVolume(this.memoryVolume);
        }
    }
}
