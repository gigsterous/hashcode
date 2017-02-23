/**
 * Created by michalsvacha on 23.02.17.
 */
public class RequestDescription {

    private int videoID;
    private int endpointID;
    private int requestsCount;

    public RequestDescription(int videoID, int endpointID, int requestsCount) {
        this.videoID = videoID;
        this.endpointID = endpointID;
        this.requestsCount = requestsCount;
    }

    public int getVideoID() {
        return videoID;
    }

    public int getEndpointID() {
        return endpointID;
    }

    public int getRequestsCount() {
        return requestsCount;
    }
}
