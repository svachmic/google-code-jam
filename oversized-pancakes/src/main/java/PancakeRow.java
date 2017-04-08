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
}
