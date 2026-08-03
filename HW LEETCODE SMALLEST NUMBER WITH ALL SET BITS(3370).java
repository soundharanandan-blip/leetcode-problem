class Solution {
    public int smallestNumber(int n) {
        int x = 1;
        
        // Find the smallest number of the form 2^k - 1 that is >= n
        while (x < n) {
            x = (x << 1) | 1; // Shifts left and sets the lowest bit to 1
        }
        
        return x;
    }
}
