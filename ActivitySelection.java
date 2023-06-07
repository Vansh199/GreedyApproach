import java.util.ArrayList;
import java.util.List;
//time complexity: O(n log n)
//space complexity: O(n)
public class ActivitySelection {
    public static List<Integer> selectActivities(int[] start, int[] finish) {
        List<Integer> selectedActivities = new ArrayList<>();

        int n = start.length;
        if (n == 0) {
            return selectedActivities; // No activities available
        }

        selectedActivities.add(0); // Select the first activity

        int lastFinishTime = finish[0];
        for (int i = 1; i < n; i++) {
            if (start[i] >= lastFinishTime) {
                // If the current activity's start time is after or equal to the last finish time,
                // select the activity
                selectedActivities.add(i);
                lastFinishTime = finish[i];
            }
        }

        return selectedActivities;
    }

    public static void main(String[] args) {
        int[] start = {10, 12, 20};
        int[] finish = {20, 25, 30};

        List<Integer> selectedActivities = selectActivities(start, finish);

        System.out.println("Selected activities: " + selectedActivities);
    }
}
