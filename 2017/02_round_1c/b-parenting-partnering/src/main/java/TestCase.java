import java.util.ArrayList;
import java.util.List;

/**
 * Created by michalsvacha on 30.04.17.
 */

public class TestCase {
    private List<Activity> activitiesCameron = new ArrayList<>();
    private List<Activity> activitiesJamie = new ArrayList<>();

    public void addActivity(int person, Activity activity) {
        if (person == 0) {
            this.activitiesCameron.add(activity);
        } else {
            this.activitiesJamie.add(activity);
        }
    }

    @Override
    public String toString() {
        return "TestCase{" +
                "activitiesJamie=" + activitiesJamie +
                ", activitiesCameron=" + activitiesCameron +
                '}';
    }
}
