import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by michalsvacha on 22.04.17.
 */
public class TestCase {
    private List<City> cities = new ArrayList<City>();
    private int[][] distances;
    private List<Delivery> deliveries = new ArrayList<Delivery>();

    public TestCase(int cityCount) {
        this.distances = new int[cityCount][cityCount];
    }

    public void addCity(City city) {
        this.cities.add(city);
    }

    public void setDistance(int x, int y, int distance) {
        this.distances[x][y] = distance;
    }

    public void addDelivery(Delivery delivery) {
        this.deliveries.add(delivery);
    }

    @Override
    public String toString() {
        return "\nTestCase{" +
                "cities=" + cities + "\n" +
                ", distances=\n" + this.prettyDistances() +
                ", deliveries=" + deliveries +
                "}\n";
    }

    public String prettyDistances() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < this.distances.length; i++) {
            for (int j = 0; j < this.distances.length; j++) {
                sb.append(this.distances[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
