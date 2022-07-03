package by.khaletski.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;
    private Music music1;
    private Music music2;
    private Music music3;

    public MusicPlayer(@Qualifier("classicalMusic") Music music1,
                       @Qualifier("jazzMusic") Music music2,
                       @Qualifier("rockMusic") Music music3) {
        this.music1 = music1;
        this.music2 = music2;
        this.music3 = music3;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    public String playMusic() {
        return "Playing: " + music1.getSong() + ", " + music2.getSong() + ", " + music3.getSong();
    }
}
