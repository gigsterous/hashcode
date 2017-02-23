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

    public void setLatency(int latency) {
        this.latency = latency;
    }

    public Cache getCache() {
        return cache;
    }

    public void setCache(Cache cache) {
        this.cache = cache;
    }
}
