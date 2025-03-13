import java.util.*;;

class Model {
    private List<Song> songs = new ArrayList<>();

    public void addSong(Song song) {
        songs.add(song);
    }

    public int calculateScore(List<String> singers, int duration) {
        int score = 0;
        int singersLength = singers.stream().mapToInt(String::length).sum();
    
        if (singers.size() == 1) {
            score = (songs.stream().mapToInt(Song::getDuration).sum() + duration) % 100;
        } else if (singers.size() == 2) {
            score = (duration * singersLength) % 100;
        } else if (singers.size() == 3) {
            int prevSingersLength = songs.stream().flatMap(s -> s.getSingers().stream()).mapToInt(String::length).sum();
            score = (prevSingersLength * singersLength) % 100;
        }
        return score;
    }
    
}

class Song {
    private int duration;
    private List<String> singers;

    public Song(String name, int duration, List<String> singers) {
        this.duration = duration;
        this.singers = singers;
    }

    public int getDuration() {
        return duration;
    }

    public List<String> getSingers() {
        return singers;
    }
}

