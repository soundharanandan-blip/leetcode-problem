import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        // Count the frequency of each digit (0-9)
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }

        List<Integer> resultList = new ArrayList<>();

        // Iterate through all 3-digit even numbers (100 to 998)
        for (int i = 100; i <= 998; i += 2) {
            int hundred = i / 100;
            int ten = (i / 10) % 10;
            int one = i % 10;

            // Frequency map for current number's digits
            int[] currentCount = new int[10];
            currentCount[hundred]++;
            currentCount[ten]++;
            currentCount[one]++;

            // Check if available digits satisfy the required count
            if (count[hundred] >= currentCount[hundred] &&
                count[ten] >= currentCount[ten] &&
                count[one] >= currentCount[one]) {
                resultList.add(i);
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
