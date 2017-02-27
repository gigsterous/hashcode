package com.gigsterous.hashcode.model;

/**
 * Created by michalsvacha on 23.02.17.
 */

public class Video {

    private int id;
    private int size;
    private int attractivity;

    public Video(int id, int size) {
        this.id = id;
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "com.gigsterous.hashcode.model.Video {" +
                "id = " + id +
                ", size = " + size +
                '}';
    }
}
