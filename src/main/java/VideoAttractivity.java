
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by michalsvacha on 23.02.17.
 */
public class VideoAttractivity implements Comparable<VideoAttractivity> {

    private Video video;
    private int attractivity = 0;
    private List<RequestDescription> requests = new ArrayList<RequestDescription>();

    public VideoAttractivity(Video video) {
        this.video = video;
    }

    public int getAttractivity() {
        return attractivity;
    }

    public void addRequest(RequestDescription request) {
        this.requests.add(request);
        this.attractivity += request.getRequestsCount();
    }

    @Override
    public String toString() {
        return "VideoAttractivity {" +
                "video=" + video.getId() +
                ", attractivity=" + attractivity +
                '}';
    }

    public int compareTo(VideoAttractivity o) {
        return o.getAttractivity() - this.getAttractivity();
    }
}
