/**
 * Created by michalsvacha on 08.04.17.
 */

public class Number {
    private long number;

    public Number(long number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Number{" +
                "number=" + number +
                ",tidy=" + isNumberTidy() +
                '}';
    }

    private boolean isNumberTidy() {
        char[] numberArray = ("" + number).toCharArray();
        char tmp = numberArray[0];
        for (int i = 1; i < numberArray.length; i++) {
            char c = numberArray[i];

            if (c < tmp) {
                return false;
            } else {
                tmp = c;
            }
        }

        return true;
    }
}
