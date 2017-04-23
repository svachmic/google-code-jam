import java.util.ArrayList;
import java.util.Collections;
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
        return visit(from, to, visited, 0, 0, 0, 100);
    }

    private double visit(int city, int destination, boolean[] visited, double time, int remainingHorsePower, int speed, double best) {
        City startCity = this.cities.get(city);

        if (city == destination) {
            return time < best ? time : best;
        }

        for (int i = 0; i < this.distances.length; i++) {
            if (i != city && this.distances[city][i] != -1 && !visited[i]) {
                double distanceToCity = (double) this.distances[city][i];

                double thisCityHorseTime = distanceToCity / (double) startCity.getAverageHorseSpeed();
                int hypothetical = startCity.getMaxHorseDistance() - (int) distanceToCity;

                double oldHorseTime = distanceToCity / (double) speed;

                if (remainingHorsePower < distanceToCity) {
                    time += thisCityHorseTime;
                    remainingHorsePower = hypothetical;
                    speed = startCity.getAverageHorseSpeed();

                    visited[i] = true;
                    double a = visit(i, destination, visited, time, remainingHorsePower, speed, best);
                    if (a < best) {
                        best = a;
                    }
                    visited[i] = false;

                } else {

                    int tmpRemaining = remainingHorsePower;
                    int tmpSpeed = speed;

                    time += thisCityHorseTime;
                    remainingHorsePower = hypothetical;
                    speed = startCity.getAverageHorseSpeed();

                    visited[i] = true;
                    double a = visit(i, destination, visited, time, remainingHorsePower, speed, best);
                    if (a < best) {
                        best = a;
                    }
                    visited[i] = false;

                    time -= thisCityHorseTime;
                    time += oldHorseTime;
                    remainingHorsePower = tmpRemaining;
                    remainingHorsePower -= distanceToCity;
                    speed = tmpSpeed;
                    visited[i] = true;
                    a = visit(i, destination, visited, time, remainingHorsePower, speed, best);
                    if (a < best) {
                        best = a;
                    }
                    visited[i] = false;


                    //if (oldHorseTime < thisCityHorseTime) {
                    //    time += oldHorseTime;
                    //    remainingHorsePower -= distanceToCity;
                    //} else {
                    //    time += thisCityHorseTime;
                    //    remainingHorsePower = hypothetical;
                    //    speed = startCity.getAverageHorseSpeed();
                    //}
                }

                //if (i == destination && time < best) {
                //    best = time;
                //} else {
                //    visited[i] = true;
                //    double a = visit(i, destination, visited, time, remainingHorsePower, speed, best);
                //    if (a < best) {
                //        best = a;
                //    }
                //    visited[i] = false;
                //}
            }
        }

        return best;
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
