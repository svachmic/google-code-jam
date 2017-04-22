/**
 * Created by michalsvacha on 22.04.17.
 */
public class Delivery {
    private int start;
    private int end;

    public Delivery(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
