/**
 * Created by michalsvacha on 08.04.17.
 */

public class PancakeRow {
    private String pancakes;
    private int k;

    public PancakeRow(String pancakes, int k) {
        this.pancakes = pancakes;
        this.k = k;
    }

    @Override
    public String toString() {
        return "PancakeRow{" +
                "pancakes='" + pancakes + '\'' +
                ", k=" + k +
                '}';
    }

    public String getFlipCount() {
        int flips = 0;
        char[] ps = this.pancakes.toCharArray();

        for (int i = 0; i < ps.length - k + 1; i++) {
            if (ps[i] == '-') {
                flips++;
                for (int j = i; j < i + k; j++) {
                    char flip = ps[j] == '-' ? '+' : '-';
                    ps[j] = flip;
                }
            }
        }

        return isFacingAllUp(ps) ? "" + flips : "IMPOSSIBLE";
    }

    private boolean isFacingAllUp(char[] row) {
        for (char c : row) {
            if (c == '-') {
                return false;
            }
        }

        return true;
    }
}
