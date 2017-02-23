import java.util.ArrayList;
import java.util.List;

/**
 * Created by smajl on 23.2.17.
 */
public class Cache {

    private int id;
    private int capacity;
    private List<Video> videos;

    public Cache(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;

        videos = new ArrayList<Video>();
    }
}
