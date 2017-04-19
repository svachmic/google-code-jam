import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michalsvacha on 08.04.17.
 */

public class Main {
    static List<PancakeRow> testCases = new ArrayList<PancakeRow>();

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
                String[] testCase = line.split(" ");

                PancakeRow row = new PancakeRow(testCase[0], Integer.parseInt(testCase[1]));
                testCases.add(row);
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

            PancakeRow row = testCases.get(i);
            String flips = row.getFlipCount();

            sb.append(flips);
            sb.append("\n");
        }

        for (PancakeRow p : testCases) {
            System.out.println(p.getFlipCount());
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
