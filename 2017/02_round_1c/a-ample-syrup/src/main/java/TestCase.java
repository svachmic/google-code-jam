import java.util.ArrayList;
import java.util.List;

/**
 * Created by michalsvacha on 30.04.17.
 */
public class TestCase {
    int pancakeCount, orderedCount;
    List<Pancake> pancakes = new ArrayList<Pancake>();

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
}
