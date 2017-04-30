import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michalsvacha on 30.04.17.
 */

public class Main {
    static List<TestCase> testCases = new ArrayList<TestCase>();

    public static void main(String[] args) {
        String path = "src/main/resources/" + "sample.in";
        readInput(path);
        System.out.println(testCases);
    }

    private static void readInput(String file) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));

            int testCasesCount = Integer.parseInt(bf.readLine());
            for (int i = 0; i < testCasesCount; i++) {
                String line = bf.readLine();
                String[] testCaseMetadata = line.split(" ");
                int pancakeCount = Integer.parseInt(testCaseMetadata[0]);
                int orderedCount = Integer.parseInt(testCaseMetadata[1]);
                TestCase testCase = new TestCase(pancakeCount, orderedCount);

                for (int j = 0; j < pancakeCount; j++) {
                    line = bf.readLine();
                    testCaseMetadata = line.split(" ");

                    int radius = Integer.parseInt(testCaseMetadata[0]);
                    int height = Integer.parseInt(testCaseMetadata[1]);
                    Pancake pancake = new Pancake(radius, height);
                    testCase.addPancake(pancake);
                }

                testCase.sortPancakes();
                testCases.add(testCase);
            }
        } catch (Exception e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
    }
}
