import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michalsvacha on 22.04.17.
 */

public class Main {
    static List<TestCase> testCases = new ArrayList<TestCase>();

    public static void main(String[] args) {
        String path = "src/main/resources/" + "sample.in";
        readInput(path);
        saveOutput(path);
    }

    private static void readInput(String file) {
        try {
            BufferedReader bf = new BufferedReader(new FileReader(file));

            int testCasesCount = Integer.parseInt(bf.readLine());
            for (int i = 0; i < testCasesCount; i++) {
                String line = bf.readLine();
                String[] testCaseRaw = line.split(" ");

                TestCase testCase = new TestCase(
                        Integer.parseInt(testCaseRaw[0]),
                        Integer.parseInt(testCaseRaw[1]),
                        Integer.parseInt(testCaseRaw[2]),
                        Integer.parseInt(testCaseRaw[3]),
                        Integer.parseInt(testCaseRaw[4]),
                        Integer.parseInt(testCaseRaw[5]),
                        Integer.parseInt(testCaseRaw[6])
                );

                testCases.add(testCase);
            }
        } catch (Exception e) {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
    }

    private static void saveOutput(String file) {
        StringBuilder sb = new StringBuilder("");

        for (int i = 0; i < testCases.size(); i++) {
            sb.append("Case #").append(i + 1).append(": ");

            TestCase testCase = testCases.get(i);
            sb.append(testCase.getRingPlacement());

            sb.append("\n");
        }

        try {
            PrintWriter out = new PrintWriter(file + ".out");

            out.write(sb.toString());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
