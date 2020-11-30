import javax.sound.midi.*;

public class MMain {

    public static void main(String[] args) {
        Main main = new Main();
        main.play();
    }

    public void play(){
        try {
            Sequencer player = MidiSystem.getSequencer();
            player.open();
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            ShortMessage c = new ShortMessage();
            c.setMessage(192, 1, 50, 100);
            MidiEvent ch = new MidiEvent(c, 1);
            track.add(ch);

            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 40, 100);
            MidiEvent noteOn = new MidiEvent(a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 40, 100);
            MidiEvent noteOff = new MidiEvent(b, 6);
            track.add(noteOff);

            player.setSequence(seq);
            player.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
}
