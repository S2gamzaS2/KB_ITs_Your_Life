package afternoon.access.speaker;

public class Speaker {
    private int volume;

    public Speaker() {
        this.volume = 100;
    }
    public void volumeUp() {
        if (isValidVolume(this.volume + 1)) {
            volume += 1;
            getVolume();
        } else {
            System.out.println("더 이상 볼륨 조절이 불가능합니다");
        }
    }

    public void volumeDown() {
        if (isValidVolume(this.volume - 1)) {
            volume -= 1;
            getVolume();
        } else {
            System.out.println("더 이상 볼륨 조절이 불가능합니다");
        }
    }

    public void mute() {
        volume = 0;
        System.out.println("스피커가 Mute 되었습니다");
    }

    public void getVolume() {
        System.out.println("현재볼륨: " + this.volume);
    }

    private boolean isValidVolume(int vol) {
        return vol >= 0 && vol <= 100;
    }

}
