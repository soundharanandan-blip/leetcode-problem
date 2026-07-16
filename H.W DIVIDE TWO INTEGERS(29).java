class Solution {
    public int divide(int dividend, int divisor) {
        // Edge Case: Handle overflow condition (-2^31 / -1 = 2^31, which overflows 32-bit int)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        // True if the signs are different, meaning the final quotient will be negative
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative values to avoid integer overflow 
        // (Because |Integer.MIN_VALUE| cannot fit into a positive 32-bit int)
        long absDividend = Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);

        int quotient = 0;

        // Perform bit-shifted subtraction
        while (absDividend >= absDivisor) {
            long tempDivisor = absDivisor;
            int multiple = 1;

            // Shift tempDivisor until it's just under the remaining dividend
            while (absDividend >= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the largest shifted divisor possible from dividend
            absDividend -= tempDivisor;
            // Add the corresponding multiple to the quotient
            quotient += multiple;
        }

        // Apply the correct sign
        return isNegative ? -quotient : quotient;
    }
}
