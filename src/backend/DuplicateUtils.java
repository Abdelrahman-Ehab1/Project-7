package backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateUtils {
    /*
  Finds all duplicated numbers in an array and their positions (1 based).
  Positions are either column numbers for rows or row numbers for columns
 or box positions 1–9 for boxes.
 */
    public static Map<Integer, List<Integer>> findDuplicatePositions(int[] arr) {
        Map<Integer, List<Integer>> positionsMap = new HashMap<>();
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            if (seen.containsKey(num)) {
                // awel mara ala2y duplicate a7ot el previous index
                if (!positionsMap.containsKey(num)) {
                    positionsMap.put(num, new ArrayList<>());
                    positionsMap.get(num).add(seen.get(num) + 1); // 1 based
                }
                // add current index
                positionsMap.get(num).add(i + 1); // 1 based
            }
            else {
                seen.put(num, i);
            }
        }
        return positionsMap;
    }
}
