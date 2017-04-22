import java.util.ArrayList;
import java.util.List;

/**
 * Created by michalsvacha on 22.04.17.
 */

public class TestCase {
    private int distance;
    private List<Horse> horses = new ArrayList<Horse>();

    public TestCase(int distance) {
        this.distance = distance;
    }

    public void addHorse(Horse horse) {
        this.horses.add(horse);
    }

    public int getDistance() {
        return distance;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "distance=" + distance +
                ", horses=" + horses +
                '}';
    }

    public double getAverageSpeed() {
        double travelTimeMax = 0;
        for (Horse horse : this.getHorses()) {
            double travelTime = horse.getTravelTime(this.getDistance());
            travelTimeMax = travelTime > travelTimeMax ? travelTime : travelTimeMax;
        }
        double averageSpeed = (double) this.getDistance() / travelTimeMax;

        return averageSpeed;
    }
}
