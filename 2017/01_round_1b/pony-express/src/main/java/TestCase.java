import java.util.ArrayList;
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

    private double shortestTime(int from, int to) {
        boolean[] visited = new boolean[this.cities.size()];
        visited[from] = true;
        return visit(from, to, visited, 0, 0, 0, Double.MAX_VALUE);
    }

    private double visit(int city, int destination, boolean[] visited, double currentTime, int remainingHorseDistance,
                         int horseSpeed, double bestTime) {
        City currentCity = this.cities.get(city);

        if (city == destination) {
            return currentTime < bestTime ? currentTime : bestTime;
        } else if (currentTime > bestTime) {
            return bestTime;
        }

        for (int i = 0; i < this.distances.length; i++) {
            if (i != city && this.distances[city][i] != -1 && !visited[i]) {
                double distanceToCity = (double) this.distances[city][i];

                double currentCityHorseTime = distanceToCity / (double) currentCity.getAverageHorseSpeed();
                int currentCityRemainingHorseDistance = currentCity.getMaxHorseDistance() - (int) distanceToCity;

                double previousCityHorseTime = distanceToCity / (double) horseSpeed;

                visited[i] = true;
                double subTime = visit(i, destination, visited, currentTime + currentCityHorseTime,
                        currentCityRemainingHorseDistance, currentCity.getAverageHorseSpeed(), bestTime);
                if (subTime < bestTime) {
                    bestTime = subTime;
                }
                visited[i] = false;

                if (remainingHorseDistance >= distanceToCity) {
                    visited[i] = true;
                    subTime = visit(i, destination, visited, currentTime + previousCityHorseTime,
                            remainingHorseDistance - (int) distanceToCity, horseSpeed, bestTime);
                    if (subTime < bestTime) {
                        bestTime = subTime;
                    }
                    visited[i] = false;
                }
            }
        }

        return bestTime;
    }

    public String deliveryTimes() {
        StringBuilder sb = new StringBuilder();

        for (Delivery delivery : this.deliveries) {
            double shortestTime = this.shortestTime(delivery.getStart() - 1, delivery.getEnd() - 1);
            sb.append(shortestTime).append(" ");
        }

        return sb.toString();
    }
}
