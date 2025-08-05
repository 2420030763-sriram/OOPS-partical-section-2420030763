import java.util.LinkedHashMap;
import java.util.Map;

public class swissoutput {
    public static void main(String[] args) {
        String input = "swiss";
        char result = getFirstNonRepeating(input);
        System.out.println(result);
    }

    public static char getFirstNonRepeating(String str) {
        Map<Character, Integer> countMap = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return '-'; // if no non-repeating character found
    }
}

