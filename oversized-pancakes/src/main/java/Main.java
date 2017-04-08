import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michalsvacha on 08.04.17.
 */

public class Main {
    static List<PancakeRow> testCases = new ArrayList<PancakeRow>();

    public static void main(String[] args) {
        readInput("src/main/resources/sample.in");
    }

    private static void readInput(String file) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));

            int testCasesCount = Integer.parseInt(bf.readLine());
            for (int i = 0; i < testCasesCount; i++) {
                String line = bf.readLine();
                String[] testCase = line.split(" ");

                PancakeRow row = new PancakeRow(testCase[0], Integer.parseInt(testCase[1]));
                testCases.add(row);
            }
        } catch (Exception e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
    }
}
