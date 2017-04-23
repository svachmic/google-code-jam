/**
 * Created by michalsvacha on 23/04/17.
 */

public class TestCase {
    private int total;
    private int red, orange, yellow, green, blue, violet;

    public TestCase(int total, int red, int orange, int yellow, int green, int blue, int violet) {
        this.total = total;
        this.red = red;
        this.orange = orange;
        this.yellow = yellow;
        this.green = green;
        this.blue = blue;
        this.violet = violet;
    }

    public int getTotal() {
        return total;
    }

    public int getRed() {
        return red;
    }

    public int getOrange() {
        return orange;
    }

    public int getYellow() {
        return yellow;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public int getViolet() {
        return violet;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "total=" + total +
                ", red=" + red +
                ", orange=" + orange +
                ", yellow=" + yellow +
                ", green=" + green +
                ", blue=" + blue +
                ", violet=" + violet +
                '}';
    }
}
