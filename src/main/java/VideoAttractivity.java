
import java.util.*;

/**
 * Created by michalsvacha on 23.02.17.
 */
public class VideoAttractivity implements Comparable<VideoAttractivity> {

    private Video video;
    private int attractivity = 0;
    private List<RequestDescription> requests = new ArrayList<RequestDescription>();
    private Set<Endpoint> endpoints = new HashSet<Endpoint>();

    public VideoAttractivity(Video video) {
        this.video = video;
    }

    public int getAttractivity() {
        int divisor = endpoints.size() > 0 ? endpoints.size() : 1;
        return (attractivity / video.getSize()) / divisor;
    }

    public void addRequest(RequestDescription request) {
        this.requests.add(request);
        this.attractivity += request.getRequestsCount();
        endpoints.add(request.getEndpoint());
    }

    public Set<Endpoint> getEndpoints() {
        return endpoints;
    }

    public Video getVideo() {
        return video;
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
