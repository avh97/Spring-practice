package by.khaletski.practice;

import java.util.ArrayList;
import java.util.List;

public class MusicPlayer {
    private List<Music> playlist = new ArrayList<>();
    private String name;
    private int volume;

    public MusicPlayer() {
    }

    // IoC
    public MusicPlayer(List<Music> playlist) {
        this.playlist = playlist;
    }

    public List<Music> getPlaylist() {
        return playlist;
    }

    public void setPlaylist(List<Music> playlist) {
        this.playlist = playlist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void playMusic() {
        for (Music music : playlist) {
            System.out.println("Playing: " + music.getSong());
        }
    }
}
