/**
 * Created by michalsvacha on 22.04.17.
 */

public class Horse {
    private int position;
    private int speed;

    public Horse(int position, int speed) {
        this.position = position;
        this.speed = speed;
    }

    public int getPosition() {
        return position;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return "Horse{" +
                "position=" + position +
                ", speed=" + speed +
                '}';
    }

    public double getTravelTime(int destination) {
        double distance = (double) (destination - this.getPosition());
        double time = distance / (double) this.getSpeed();
        return time;
    }
}
