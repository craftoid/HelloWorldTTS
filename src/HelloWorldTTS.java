import com.sun.speech.freetts.VoiceManager;

public class HelloWorldTTS {

    public static void main(String[] args) {

        Voice kevin = new Voice("kevin");

        String[] hello = new String[] {
            "Hello World.",
            "This is your Raspberry Pi speaking."
        };

        kevin.say(hello);

    }

}

class Voice {

    private com.sun.speech.freetts.Voice voice;

    public Voice(String name) {
        voice = VoiceManager.getInstance().getVoice(name);
        voice.allocate();
    }

    public void say(String[] sentences) {
        for (int i = 0; i < sentences.length; i++) {
            say( sentences[i] );
        }
    }

    public void say(String sentence) {
        voice.speak(sentence);
    }

    public void dispose() {
        voice.deallocate();
    }
    
}