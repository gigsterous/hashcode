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

}
