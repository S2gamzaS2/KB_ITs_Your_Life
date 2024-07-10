package afternoon.access.speaker;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker();

        speaker.getVolume();
        speaker.volumeDown();
//        speaker.mute();
//        speaker.volumeUp();

        speaker.mute();
        speaker.volumeUp();
//        speaker.volumeDown();

    }
}
