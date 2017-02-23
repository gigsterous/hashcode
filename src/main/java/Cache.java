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

    public int remainingCapacity() {
        int usage = 0;
        for (Video v: videos) {
            usage += v.getSize();
        }
        return capacity - usage;
    }

    public boolean willFit(Video video) {
        return remainingCapacity() - video.getSize() > 0;
    }
}
