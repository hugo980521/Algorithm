package bookrelation.dynamicprogram;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:
 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 0; i <= len1; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= len2; i++){
            dp[0][i] = i;
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i - 1][j - 1]));
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        int step=editDistance.minDistance("","ab");
        System.out.println(step);
    }
}
