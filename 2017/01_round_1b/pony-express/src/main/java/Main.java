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

                int cityCount = Integer.parseInt(testCaseRaw[0]);
                int q = Integer.parseInt(testCaseRaw[1]);

                TestCase testCase = new TestCase(cityCount);

                for (int j = 0; j < cityCount; j++) {
                    line = bf.readLine();
                    testCaseRaw = line.split(" ");
                    City city = new City(Integer.parseInt(testCaseRaw[0]), Integer.parseInt(testCaseRaw[1]));
                    testCase.addCity(city);
                }

                for (int j = 0; j < cityCount; j++) {
                    line = bf.readLine();
                    testCaseRaw = line.split(" ");

                    for (int k = 0; k < cityCount; k++) {
                        testCase.setDistance(j, k, Integer.parseInt(testCaseRaw[k]));
                    }
                }

                for (int j = 0; j < q; j++) {
                    line = bf.readLine();
                    testCaseRaw = line.split(" ");

                    Delivery delivery = new Delivery(Integer.parseInt(testCaseRaw[0]), Integer.parseInt(testCaseRaw[1]));
                    testCase.addDelivery(delivery);
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
            sb.append(testCase.deliveryTimes());

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
