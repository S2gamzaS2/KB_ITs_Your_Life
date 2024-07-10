package ch08.interfacee.defaultmethod;

public interface RemoteControl  {
    //상수 필드
    int MAX_VOLUME = 10;
    int MIN_VOLUME = 0;

    //추상 메서드
    void turnOn();
    void turnOff();
    void setVolume(int volume);

    //디폴트 인스턴스 메서드 (구현체가 구현 안 해도 됨..?)
    default void setMute(boolean mute) {
        if(mute) {
            System.out.println("리모트 무음~!");
            setVolume(MIN_VOLUME);
        } else {
            System.out.println("리모트 무음 해제~!");
        }
    }
}
