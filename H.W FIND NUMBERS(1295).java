 public class Solution {
    public static int findNumbers(int[] nums) {
        int evenDigitCount = 0;
        
        for (int num : nums) {
            // Calculate the number of digits using log10
            int digits = (int) Math.log10(num) + 1;
            
            // Check if the number of digits is even
            if (digits % 2 == 0) {
                evenDigitCount++;
            }
        }
        
        return evenDigitCount;
    }

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        int result = findNumbers(nums);
        
        System.out.println("Output: " + result); 
        // Expected Output: 2 (12 and 7896 have an even number of digits)
    }
}  
    
