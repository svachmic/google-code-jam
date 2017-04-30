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

    public int getPancakeCount() {
        return pancakeCount;
    }

    public int getOrderedCount() {
        return orderedCount;
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

    public double getMaximumArea() {
        if (this.getOrderedCount() == this.getPancakeCount()) {
            List<Integer> selectedPancakes = new ArrayList<>();
            for (int i = 0; i < this.getOrderedCount(); i++) {
                selectedPancakes.add(i);
            }
            return this.getArea(selectedPancakes);
        }

        return findOptimumCombination(new ArrayList<>(), 0, 0.0);
    }

    public double findOptimumCombination(List<Integer> selectedPancakes, int startIndex, double bestSolution) {
        if (selectedPancakes.size() == this.getOrderedCount()) {
            double area = this.getArea(selectedPancakes);
            return area > bestSolution ? area : bestSolution;
        }

        if ((selectedPancakes.size() + (pancakes.size() - startIndex)) < this.getOrderedCount()) {
            return bestSolution;
        }

        for(int i = startIndex; i < pancakes.size(); i++) {
            selectedPancakes.add(i);
            double candidateSolution = findOptimumCombination(selectedPancakes, startIndex + 1, bestSolution);
            if (candidateSolution > bestSolution) {
                bestSolution = candidateSolution;
            }
            selectedPancakes.remove(selectedPancakes.size() - 1);
        }

        return bestSolution;
    }

    private double getArea(List<Integer> selectedPancakes) {
        double totalArea = 0.0;

        Pancake first = this.pancakes.get(selectedPancakes.get(0));
        totalArea += first.getSideArea();

        for (int i = 1; i < selectedPancakes.size(); i++) {
            Pancake next = this.pancakes.get(selectedPancakes.get(i));
            totalArea += next.getSideArea();
            totalArea += this.getPancakeDifference(first, next);
            first = next;
        }

        totalArea += first.getTopArea();
        return totalArea;
    }

    private double getPancakeDifference(Pancake bottom, Pancake top) {
        return bottom.getTopArea() - top.getTopArea();
    }
}
