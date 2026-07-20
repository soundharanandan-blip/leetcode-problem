class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // A sign is only valid as the first character or immediately after 'e'/'E'
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == 'e' || c == 'E') {
                // 'e'/'E' can only appear once, and must follow at least one digit
                if (seenExponent || !seenDigit) {
                    return false;
                }
                seenExponent = true;
                // Reset seenDigit to ensure digits follow the exponent
                seenDigit = false;
            } else if (c == '.') {
                // A dot can only appear once and cannot appear after an exponent
                if (seenDot || seenExponent) {
                    return false;
                }
                seenDot = true;
            } else {
                // Any other character is invalid
                return false;
            }
        }

        // Return true if we saw at least one valid digit (and after an exponent if present)
        return seenDigit;
    }
}
