class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final long MOD = 1_000_000_007L;
        int m = r - l + 1;
        if (m <= 0 || n <= 0)
            return 0;


        long[] up = new long[m + 1]; 
        long[] down = new long[m + 1]; 

        for (int v = 1; v <= m; v++) {
            up[v] = v - 1; // number of a < v
            down[v] = m - v; // number of a > v
        }

  
        int[] sornavetic = new int[] { n, l, r };

        if (n == 1)
            return m % (int) MOD;
        if (n == 2) {
            long sum = 0;
            for (int v = 1; v <= m; v++)
                sum += up[v] + down[v];
            return (int) (sum % MOD);
        }


        for (int len = 3; len <= n; len++) {
            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];
            for (int i = 1; i <= m; i++) {
                prefUp[i] = (prefUp[i - 1] + up[i]) % MOD;
                prefDown[i] = (prefDown[i - 1] + down[i]) % MOD;
            }

            long[] newUp = new long[m + 1];
            long[] newDown = new long[m + 1];


            for (int v = 1; v <= m; v++) {
                newUp[v] = prefDown[v - 1]; 
                newDown[v] = (prefUp[m] - prefUp[v]) % MOD; 
                if (newDown[v] < 0)
                    newDown[v] += MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;
        for (int v = 1; v <= m; v++) {
            ans += up[v] + down[v];
            if (ans >= (1L << 62))
                ans %= MOD; 
        }
        ans %= MOD;
        return (int) ans;
    }
}