import java.util.Comparator;

/**
 * Created by michalsvacha on 23.02.17.
 */

public class Video implements Comparator<Video> {

    private int id;
    private int size;
    private int attractivity;

    public Video(int id, int size) {
        this.id = id;
        this.size = size;

        attractivity = 0;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public int getAttractivity() {
        return attractivity;
    }

    public void addAttractivity(int attractivity) {
        this.attractivity += attractivity;
    }

    @Override
    public String toString() {
        return "Video {" +
                "id = " + id +
                ", size = " + size +
                '}';
    }

    public int compare(Video o1, Video o2) {
        return o2.getAttractivity() - o1.getAttractivity();
    }
}
