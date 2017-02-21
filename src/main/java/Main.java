import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final char TOMATO = 'T';
    private static final char MUSHROOM = 'M';

    private static int rows;
    private static int cols;
    private static int minIngredients;
    private static int maxSize;

    private static char[][] pizza;

    public static void main(String[] args) {
        readInput("example.in");

        printPizza();

        boolean[][] state = new boolean[rows][cols];

        slice(0, 0, state, null, new ArrayList<Slice>());
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
            String[] tmp = line.split(" ");

            rows = Integer.parseInt(tmp[0]);
            cols = Integer.parseInt(tmp[1]);
            minIngredients = Integer.parseInt(tmp[2]);
            maxSize = Integer.parseInt(tmp[3]);

            pizza = new char[rows][cols];

            // populate pizza
            for (int i = 0; i < rows; i++) {
                line = bf.readLine();

                for (int j = 0; j < cols; j++) {
                    pizza[i][j] = line.charAt(j);
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
    }

    /**
     * Prints the original pizza for debugging purposes.
     */
    private static void printPizza() {
        for (int i = 0; i < rows; i++) {
            System.out.println(pizza[i]);
        }
    }

    /**
     *
     * @param x - start X
     * @param y - start Y
     *
     * act slicee (int)
     * slices
     * pizza state - false == not taken
     */
    private static void slice(int x, int y, boolean[][] state, Slice act, List<Slice> slices) {
        if (state[x][y]) return;

        if (act == null) {
            // creating slice

            act = new Slice(x, y, pizza[x][y]);
            state[x][y] = true;

            // send recursion in all dimensions

            // down
            int downX = x + 1;
            if (downX < pizza.length) {
                slice(downX, y, state, act, slices);
            }

            int rightY = y + 1;
            if (rightY < pizza[0].length) {
                slice(x, rightY, state, act, slices);
            }

            if ((downX < pizza.length) && (rightY < pizza[0].length)) {
                slice(downX, rightY, state, act, slices);
            }

        } else {
            // expanding slice

            act.setEndX(x);
            act.setEndY(y);
            updateState(state, act);
            act.updateIngredients(pizza);

            if (act.isComplete(minIngredients)) {
                slices.add(act);

                Point newPoint = getMostLeftUpper(state);
                slice(newPoint.getX(), newPoint.getY(), state, null, slices);
            } else {

                // send recursion in all dimensions

                boolean endOfTheWorld = true;

                // down
                int downX = x + 1;
                if (downX < pizza.length) {
                    endOfTheWorld = false;
                    slice(downX, y, state, act, slices);
                }

                int rightY = y + 1;
                if (rightY < pizza[0].length) {
                    endOfTheWorld = false;
                    slice(x, rightY, state, act, slices);
                }

                if ((downX < pizza.length) && (rightY < pizza[0].length)) {
                    endOfTheWorld = false;
                    slice(downX, rightY, state, act, slices);
                }

                if (endOfTheWorld) {
                    System.out.println(slices);
                }
            }

        }
    }

    public static void updateState(boolean[][] state, Slice slice) {
        for (int i = slice.getOriginX(); i < slice.getEndX(); i++) {
            for (int j = slice.getOriginY(); j < slice.getEndY(); j++) {
                state[i][j] = true;
            }
        }
    }

    public static Point getMostLeftUpper(boolean[][] state) {
        for (int i = 0; i < state.length; i++) {
            for (int j = 0; j < state[0].length; j++) {
                if (!state[i][j]) {
                    return new Point(i, j);
                }
            }
        }

        return null;
    }

}
