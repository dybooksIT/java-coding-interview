package coding.challenge.jukebox;

public class Song {
    private final String title;
    private final CD cd;

    // Song에 대한 더 자세한 내용
    public Song(String title, CD cd) {
        this.title = title;
        this.cd = cd;
    }   

    public CD getCd() {
        return cd;
    }

    public String getTitle() {
        return title;
    }
}