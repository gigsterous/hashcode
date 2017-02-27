package com.gigsterous.hashcode.model;

/**
 * Created by smajl on 23.2.17.
 */
public class Latency {

    private int latency;
    private Cache cache;

    public Latency(int latency, Cache cache) {
        this.latency = latency;
        this.cache = cache;
    }

    public int getLatency() {
        return latency;
    }

    public Cache getCache() {
        return cache;
    }

    @Override
    public String toString() {
        return "com.gigsterous.hashcode.model.Latency{" +
                ", latency=" + latency +
                ", cache=" + cache +
                '}';
    }
}
