class Solution {
    public int climbStairs(int n, int[] costs) {
        final long INF = Long.MAX_VALUE / 4;

        // Before processing j = 1:
        // dpMinus2 = dp[j - 3], dpMinus1 = dp[j - 2], dp0 = dp[j - 1]
        long dpMinus2 = INF;
        long dpMinus1 = INF;
        long dp0 = 0; // dp[0] = 0

        long cur = 0;

        for (int j = 1; j <= n; j++) {
            long best = INF;

            // Come from j - 1, jump length 1
            if (dp0 < INF) {
                best = Math.min(best, dp0 + 1);
            }

            // Come from j - 2, jump length 2
            if (dpMinus1 < INF) {
                best = Math.min(best, dpMinus1 + 4);
            }

            // Come from j - 3, jump length 3
            if (dpMinus2 < INF) {
                best = Math.min(best, dpMinus2 + 9);
            }

            // costs is 1-indexed in the problem, so costs[j - 1] is cost of step j
            cur = best + costs[j - 1];

            // Shift states for next j
            dpMinus2 = dpMinus1;
            dpMinus1 = dp0;
            dp0 = cur;
        }

        return (int) cur;
    }
}