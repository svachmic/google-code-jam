/**
 * Created by michalsvacha on 30.04.17.
 */

public class Pancake {
    private int radius, height;

    public Pancake(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }

    public int getRadius() {
        return radius;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Pancake{" +
                "radius=" + radius +
                ", height=" + height +
                '}';
    }

    public double getSideArea() {
        return (Math.PI * 2.0 * (double) this.getRadius() * this.getHeight());
    }

    public double getTopArea() {
        return (Math.PI * Math.pow(this.getRadius(), 2.0));
    }
}
