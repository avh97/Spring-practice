package by.khaletski.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {
    // @Autowired
    private ClassicalMusic classicalMusic;
    private JazzMusic jazzMusic;
    private RockMusic rockMusic;

    @Autowired
    public MusicPlayer(ClassicalMusic classicalMusic, JazzMusic jazzMusic, RockMusic rockMusic) {
        this.classicalMusic = classicalMusic;
        this.jazzMusic = jazzMusic;
        this.rockMusic = rockMusic;
    }

    // @Autowired
    // public void setRockMusic(RockMusic rockMusic) {
    //     this.rockMusic = rockMusic;
    // }

    public String playMusic() {
        return "Playing: " + classicalMusic.getSong() + ", " + jazzMusic.getSong() + ", " + rockMusic.getSong();
    }
}
