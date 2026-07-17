ass Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Find the minimum of the current row and column sum
                int val = Math.min(rowSum[i], colSum[j]);
                
                // Assign it to the matrix
                matrix[i][j] = val;
                
                // Deduct the value from the remaining sums
                rowSum[i] -= val;
                colSum[j] -= val;
            }
        }
        
        return matrix;
    }
}
