import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michalsvacha on 30.04.17.
 */

public class Main {
    static List<TestCase> testCases = new ArrayList<>();

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
                String[] testCaseMetadata = line.split(" ");

                TestCase testCase = new TestCase();
                int activitiesCountCameron = Integer.parseInt(testCaseMetadata[0]);
                int activitiesCountJamie = Integer.parseInt(testCaseMetadata[1]);

                for (int j = 0; j < activitiesCountCameron; j++) {
                    line = bf.readLine();
                    testCaseMetadata = line.split(" ");
                    int activityStart = Integer.parseInt(testCaseMetadata[0]);
                    int activityEnd = Integer.parseInt(testCaseMetadata[1]);
                    Activity activity = new Activity(activityStart, activityEnd);
                    testCase.addActivity(0, activity);
                }

                for (int j = 0; j < activitiesCountJamie; j++) {
                    line = bf.readLine();
                    testCaseMetadata = line.split(" ");
                    int activityStart = Integer.parseInt(testCaseMetadata[0]);
                    int activityEnd = Integer.parseInt(testCaseMetadata[1]);
                    Activity activity = new Activity(activityStart, activityEnd);
                    testCase.addActivity(1, activity);
                }

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
            sb.append(testCase.getMaximumExchangesCount());

            if (i != testCases.size() - 1) {
                sb.append("\n");
            }
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
