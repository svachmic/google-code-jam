/**
 * Created by michalsvacha on 22.04.17.
 */

public class City {
    private int maxHorseDistance;
    private int averageHorseSpeed;

    public City(int maxHorseDistance, int averageHorseSpeed) {
        this.maxHorseDistance = maxHorseDistance;
        this.averageHorseSpeed = averageHorseSpeed;
    }

    @Override
    public String toString() {
        return "\nCity{" +
                "maxHorseDistance=" + maxHorseDistance +
                ", averageHorseSpeed=" + averageHorseSpeed +
                '}';
    }

    public int getAverageHorseSpeed() {
        return averageHorseSpeed;
    }

    public int getMaxHorseDistance() {
        return maxHorseDistance;
    }
}
