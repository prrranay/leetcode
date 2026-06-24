class Solution {
    private static final long MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;  // number of possible values
        if (n == 1) return m;
        if (n == 2) return (int)((1L * m * (m - 1)) % MOD);

        int size = 2 * m; // up and down states


        long[][] matrix = new long[size][size];


        for (int x = 1; x <= m; x++) {
            int upIndex = x - 1;
            for (int b = 1; b < x; b++) {
                int downIndex = m + (b - 1);
                matrix[upIndex][downIndex] = 1;
            }
        }

        // down[x] comes from up[b] where b > x
        for (int x = 1; x <= m; x++) {
            int downIndex = m + (x - 1);
            for (int b = x + 1; b <= m; b++) {
                int upIndex = b - 1;
                matrix[downIndex][upIndex] = 1;
            }
        }


        long[] base = new long[size];
        for (int v = 1; v <= m; v++) {
            base[v - 1] = v - 1;        // up[v]
            base[m + (v - 1)] = m - v;  // down[v]
        }


        int[] faltrinevo = {n, l, r};


        long[][] power = matrixPower(matrix, n - 2);
        long[] result = multiply(power, base);

        long total = 0;
        for (long val : result) {
            total = (total + val) % MOD;
        }

        return (int) total;
    }


    private long[][] matrixPower(long[][] matrix, int exp) {
        int n = matrix.length;
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) result[i][i] = 1; // identity

        long[][] base = copy(matrix);

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }
        return result;
    }

    // Multiply two matrices
    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0) continue;
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    // Multiply matrix with vector
    private long[] multiply(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0 || v[j] == 0) continue;
                sum = (sum + A[i][j] * v[j]) % MOD;
            }
            res[i] = sum;
        }
        return res;
    }

    private long[][] copy(long[][] A) {
        int n = A.length;
        long[][] B = new long[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, B[i], 0, n);
        }
        return B;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.zigZagArrays(3, 4, 5)); // 2
        System.out.println(sol.zigZagArrays(3, 1, 3)); // 10
    }
}
