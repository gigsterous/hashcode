import java.util.ArrayList;
import java.util.List;

/**
 * Created by smajl on 23.2.17.
 */
public class Endpoint {

    private int latencyCenter;
    private List<Latency> latencies;

    public Endpoint(int latencyCenter) {
        this.latencyCenter = latencyCenter;
        latencies = new ArrayList<Latency>();
    }

    public int getLatencyCenter() {
        return latencyCenter;
    }

    public void setLatencyCenter(int latencyCenter) {
        this.latencyCenter = latencyCenter;
    }

    public List<Latency> getLatencies() {
        return latencies;
    }

    public void addLatency(Latency latency) {
        latencies.add(latency);
    }

}
