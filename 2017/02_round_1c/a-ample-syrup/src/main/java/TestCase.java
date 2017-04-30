import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by michalsvacha on 30.04.17.
 */
public class TestCase {
    int pancakeCount, orderedCount;
    List<Pancake> pancakes = new ArrayList<>();

    public TestCase(int pancakeCount, int orderedCount) {
        this.pancakeCount = pancakeCount;
        this.orderedCount = orderedCount;
    }

    public void addPancake(Pancake pancake) {
        this.pancakes.add(pancake);
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "pancakeCount=" + pancakeCount +
                ", orderedCount=" + orderedCount +
                ", pancakes=" + pancakes +
                "}\n";
    }

    public void sortPancakes() {
        Comparator comparator = Comparator.comparing(Pancake::getRadius).thenComparing(Pancake::getHeight);
        Collections.sort(pancakes, comparator.reversed());
    }
}
