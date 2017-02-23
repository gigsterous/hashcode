import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    private static int V;
    private static int endpointsCount;
    private static int R;
    private static int C;
    private static int X;

    private static int cacheServersNum;

    private static int[] videos;

    private static char[][] latencies;

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
            C = Integer.parseInt(constants[3]);
            X = Integer.parseInt(constants[3]);

            // videos
            line = bf.readLine();
            String[] videosInput = line.split(" ");

            videos = new int[videosInput.length];
            for (int i = 0; i < videosInput.length; i++) {
                videos[i] = Integer.parseInt(videosInput[i]);
            }

            for (int i = 0; i < endpointsCount; i++) {
                // server input
                line = bf.readLine();
                String[] endpointInput = line.split(" ");

                int latencyCenter = Integer.parseInt(endpointInput[0]);
                int cacheServersNum = Integer.parseInt(endpointInput[1]);

                System.out.println("Endpoint info: " + line);
            }



        } catch (Exception e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
    }

}
