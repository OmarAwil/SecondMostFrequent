import java.util.HashMap;
import java.util.Map;

public class SecondMostFrequent {
    public static void main(String[] args) {
        String str = "successes";
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char ch : str.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        int firstMax = 0, secondMax = 0;
        char firstChar = ' ', secondChar = ' ';

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            int count = entry.getValue();
            if (count > firstMax) {
                secondMax = firstMax;
                secondChar = firstChar;
                firstMax = count;
                firstChar = entry.getKey();
            } else if (count > secondMax && count < firstMax) {
                secondMax = count;
                secondChar = entry.getKey();
            }
        }

        System.out.println("The second most frequent char in the string is: " + secondChar);
    }
}
