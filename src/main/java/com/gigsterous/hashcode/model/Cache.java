package com.gigsterous.hashcode.model;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by smajl on 23.2.17.
 */
public class Cache {

    private int id;
    private int capacity;
    private Map<Integer, Video> videos;

    public Cache(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;

        videos = new HashMap<Integer, Video>();
    }

    public int getId() {
        return id;
    }

    public boolean containsVideo(int videoId) {
        return videos.containsKey(videoId);
    }

    public void addVideo(Video video) {
        videos.put(video.getId(), video);
    }

    public void removeVideo(Video video) {
        videos.remove(video.getId());
    }

    public boolean isEmpty() {
        return videos.isEmpty();
    }

    public Collection<Video> getVideos() {
        return videos.values();
    }

    public int remainingCapacity() {
        int usage = 0;
        for (Video v: videos.values()) {
            usage += v.getSize();
        }
        return capacity - usage;
    }

    public boolean willFit(Video video) {
        return remainingCapacity() - video.getSize() > 0;
    }
}
