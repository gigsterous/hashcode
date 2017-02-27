package com.gigsterous.hashcode.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smajl on 23.2.17.
 */
public class Endpoint {

    private int id;
    private int latencyCenter;
    private List<Latency> latencies;

    public Endpoint(int id, int latencyCenter) {
        this.id = id;
        this.latencyCenter = latencyCenter;
        latencies = new ArrayList<Latency>();
    }

    public int getId() {
        return id;
    }

    public int getLatencyCenter() {
        return latencyCenter;
    }

    public List<Latency> getLatencies() {
        return latencies;
    }

    public void addLatency(Latency latency) {
        latencies.add(latency);
    }

    public boolean hasVideoAccess(Video v) {
        boolean flag = false;
        for (Latency l : getLatencies()) {
            if (l.getCache().containsVideo(v.getId())) {
                flag = true;
            }
        }

        return flag;
    }

    @Override
    public String toString() {
        return "com.gigsterous.hashcode.model.Endpoint{" +
                "id=" + id +
                ", latencyCenter=" + latencyCenter +
                ", latencies=" + latencies +
                '}';
    }
}
