package coding.challenge.jukebox;

import java.util.List;

public class CD {
    private List<Song> songs;

    // CD에 대한 더 자세한 내용
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }
}