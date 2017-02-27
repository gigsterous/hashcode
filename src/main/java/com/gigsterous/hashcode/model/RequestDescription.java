package com.gigsterous.hashcode.model;

/**
 * Created by michalsvacha on 23.02.17.
 */
public class RequestDescription {

    private Video video;
    private Endpoint endpoint;
    private int requestsCount;

    public RequestDescription(Video video, Endpoint endpoint, int requestsCount) {
        this.video = video;
        this.endpoint = endpoint;
        this.requestsCount = requestsCount;
    }

    public Video getVideo() {
        return video;
    }

    public Endpoint getEndpoint() {
        return endpoint;
    }

    public int getRequestsCount() {
        return requestsCount;
    }

    @Override
    public String toString() {
        return "Request {" +
                "VID = " + video.getId() +
                ", EID = " + endpoint.getId() +
                ", REQ = " + requestsCount +
                '}';
    }
}
