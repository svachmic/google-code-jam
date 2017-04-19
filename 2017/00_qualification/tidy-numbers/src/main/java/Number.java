import java.util.Arrays;

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
                ",tidy=" + isNumberTidy(this.number) +
                '}';
    }

    private boolean isNumberTidy(long number) {
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

    public long getLastTidyNumber() {
        return this.tidyNumberSearch(this.number);
    }

    private long tidyNumberSearch(long number) {
        char[] numberArray = ("" + number).toCharArray();
        for (int i = 0; i < numberArray.length; i++) {
            if (numberArray[i] == '0') {
                if (i + 1 == numberArray.length) {
                    return tidyNumberSearch(number - 1);
                } else {
                    char[] subtractArray = Arrays.copyOfRange(numberArray, i, numberArray.length);
                    long subtract = Long.parseLong(String.valueOf(subtractArray)) + 1;
                    return tidyNumberSearch(number - subtract);
                }
            }
        }

        char tmp = numberArray[numberArray.length - 1];
        for (int i = numberArray.length - 2; i > -1; i--) {
            char c = numberArray[i];
            if (c > tmp) {
                int endIndex = (numberArray.length - 2) - i;
                long multiplicator = (long) Math.pow(10, endIndex);
                long subtract = ((long) (Character.getNumericValue(tmp) + 1) * multiplicator);
                long newNumber = number - subtract;

                char[] newNumberArray = ("" + newNumber).toCharArray();
                for (int j = i + 1; j < newNumberArray.length; j++) {
                    newNumberArray[j] = '9';
                }
                long normalizedNumber = Long.parseLong(String.valueOf(newNumberArray));

                return tidyNumberSearch(normalizedNumber);
            } else {
                tmp = c;
            }
        }

        return number;
    }
}
