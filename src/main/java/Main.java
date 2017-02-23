import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    private static int videosCount;
    private static int endpointsCount;
    private static int requestCount;
    private static int cacheCount;
    private static int cacheCapacity;

    private static Video[] videos;

    private static Cache[] caches;
    private static Endpoint[] endpoints;
    private static RequestDescription[] requests;

    public static void main(String[] args) {
        readInput("kittens.in");
        optimize();
        timeSaved();
    }

    /**
     * Read input from file and initialize all variables.
     *
     * @param file
     */
    private static void readInput(String file) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("src/main/resources/" + file));

            // first line contains configuration
            String line = bf.readLine();
            String[] constants = line.split(" ");

            videosCount = Integer.parseInt(constants[0]);
            endpointsCount = Integer.parseInt(constants[1]);
            requestCount = Integer.parseInt(constants[2]);
            cacheCount = Integer.parseInt(constants[3]);
            cacheCapacity = Integer.parseInt(constants[3]);

            caches = new Cache[cacheCount];

            for (int i = 0; i < cacheCount; i++) {
                caches[i] = new Cache(i, cacheCapacity);
            }

            // VIDEOS
            line = bf.readLine();
            String[] videosInput = line.split(" ");

            videos = new Video[videosCount];
            for (int i = 0; i < videosCount; i++) {
                videos[i] = new Video(i, Integer.parseInt(videosInput[i]));
            }

            // ENDPOINTS
            endpoints = new Endpoint[endpointsCount];
            for (int i = 0; i < endpointsCount; i++) {
                // server input
                line = bf.readLine();
                String[] endpointInput = line.split(" ");

                int latencyCenter = Integer.parseInt(endpointInput[0]);
                int cacheServersNum = Integer.parseInt(endpointInput[1]);

                endpoints[i] = new Endpoint(i, latencyCenter);

                for (int j = 0; j < cacheServersNum; j++) {
                    line = bf.readLine();
                    String[] latencyInput = line.split(" ");

                    int cacheId = Integer.parseInt(latencyInput[0]);
                    int cacheLatency = Integer.parseInt(latencyInput[1]);

                    Latency latency = new Latency(cacheLatency, caches[cacheId]);
                    endpoints[i].addLatency(latency);
                }
            }

            // REQUESTS
            requests = new RequestDescription[requestCount];
            for (int j = 0; j < requestCount; j++) {
                line = bf.readLine();
                String[] requestInput = line.split(" ");

                int videoId = Integer.parseInt(requestInput[0]);
                int endpointId = Integer.parseInt(requestInput[1]);
                int count = Integer.parseInt(requestInput[2]);

                requests[j] = new RequestDescription(videos[videoId], endpoints[endpointId], count);
            }

        } catch (Exception e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
    }

    public void printInput() {
        System.out.println("Videos: ");
        for (Video v: videos) {
            System.out.println(v);
        }

        System.out.println("Endpoints: ");
        for (Endpoint e: endpoints) {
            System.out.println(e);
        }

        System.out.println("Requests: ");
        for (RequestDescription r: requests) {
            System.out.println(r);
        }
    }

    public static void optimize() {
        List<VideoAttractivity> atts = new ArrayList<VideoAttractivity>();
        for (int i = 0; i < videosCount; i++) {
            atts.add(new VideoAttractivity(videos[i]));
        }

        for (RequestDescription r : requests) {
            VideoAttractivity atr = atts.get(r.getVideo().getId());
            atr.addRequest(r);
        }

        Collections.sort(atts);
        System.out.println(atts);

    }

    public static void timeSaved() {
        double requestCount = 0.0;
        ArrayList<Integer> latencyReq = new ArrayList<Integer>();

        for (RequestDescription r : requests) {
            requestCount += r.getRequestsCount();

            int latency = 0;
            for (Latency l : r.getEndpoint().getLatencies()) {
                if (l.getCache().containsVideo(r.getVideo().getId())) {
                    latency = (r.getRequestsCount()) * (r.getEndpoint().getLatencyCenter() - l.getLatency());
                    break;
                }
            }

            latencyReq.add(latency);
        }

        double latencySavings = 0.0;
        for (int lat : latencyReq) {
            latencySavings += lat;
        }

        double savingsPerRequest = latencySavings/requestCount;
        System.out.println("Time saved is " + savingsPerRequest + "ms");
    }

}
