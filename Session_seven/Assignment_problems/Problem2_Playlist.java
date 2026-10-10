import java.util.Arrays;

public class Problem2_Playlist {
    public static void main(String[] args) {
        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Songs: " + Arrays.toString(copy));

        copy[0] = "Hacked";
        System.out.println("After changing returned copy: " + Arrays.toString(p.getSongs()));
        System.out.println("Song count: " + p.getSongCount());
    }
}

class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int maximumSize) {
        if (maximumSize < 0) {
            throw new IllegalArgumentException("Maximum size cannot be negative.");
        }
        songs = new String[maximumSize];
        songCount = 0;
    }

    public void addSong(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Song not added: title cannot be empty.");
            return;
        }

        if (songCount >= songs.length) {
            System.out.println("Song not added: playlist is full.");
            return;
        }

        songs[songCount] = title;
        songCount++;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public int getSongCount() {
        return songCount;
    }
}
