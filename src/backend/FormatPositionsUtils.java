package backend;

import java.util.List;

public class FormatPositionsUtils {
    //bgeb el positions of duplicate value
    public static String formatPositions(List<Integer> positions) {
        String s="[";
        for (int i = 0; i < positions.size(); i++) {
            if (i > 0)
                s+=" ";
            s+=positions.get(i);
        }
        s+="]";
        return s;
    }
}
