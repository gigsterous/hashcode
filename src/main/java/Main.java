import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    private static int V;
    private static int endpointsCount;
    private static int R;
    private static int cacheCount;
    private static int X;

    private static int cacheServersNum;

    private static Video[] videos;

    private static Cache[] caches;
    private static Endpoint[] endpoints;

    public static void main(String[] args) {
        readInput("kittens.in");

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

            V = Integer.parseInt(constants[0]);
            endpointsCount = Integer.parseInt(constants[1]);
            R = Integer.parseInt(constants[2]);
            cacheCount = Integer.parseInt(constants[3]);
            X = Integer.parseInt(constants[3]);

            caches = new Cache[cacheCount];

            for (int i = 0; i < cacheCount; i++) {
                caches[i] = new Cache(i, X);
            }

            // videos
            line = bf.readLine();
            String[] videosInput = line.split(" ");

            videos = new Video[videosInput.length];
            for (int i = 0; i < videosInput.length; i++) {
                videos[i] = new Video(i, Integer.parseInt(videosInput[i]));

            }

            // endpoints
            endpoints = new Endpoint[endpointsCount];
            for (int i = 0; i < endpointsCount; i++) {
                // server input
                line = bf.readLine();
                String[] endpointInput = line.split(" ");

                int latencyCenter = Integer.parseInt(endpointInput[0]);
                int cacheServersNum = Integer.parseInt(endpointInput[1]);

                endpoints[i] = new Endpoint(latencyCenter);

                for (int j = 0; j < cacheServersNum; j++) {
                    line = bf.readLine();
                    String[] latencyInput = line.split(" ");

                    int cacheId = Integer.parseInt(latencyInput[0]);
                    int cacheLatency = Integer.parseInt(latencyInput[1]);

                    Latency latency = new Latency(cacheLatency, caches[cacheId]);
                    endpoints[i].addLatency(latency);
                }



                System.out.println("Endpoint info: " + line);
            }



        } catch (Exception e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
    }

}
