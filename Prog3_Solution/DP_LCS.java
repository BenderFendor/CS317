class Solution {
    // public int longestCommonSubsequence(String text1, String text2) {
        
    // }
    // Approach 1: 2D DP table (0-indexed)  —  O(m*n) time, O(m*n) space
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = (i > 0 && j > 0 ? dp[i-1][j-1] : 0) + 1;
                } else {
                    int up   = i > 0 ? dp[i-1][j] : 0;
                    int left = j > 0 ? dp[i][j-1] : 0;
                    dp[i][j] = Math.max(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }

}
