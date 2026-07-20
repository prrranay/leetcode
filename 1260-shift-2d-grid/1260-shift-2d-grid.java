class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        k = k % total;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                subList.add(0);
            }
            res.add(subList);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int flat = i * n + j;
                int newFlat = (flat + k) % total;

                int newRow = newFlat / n;
                int newCol = newFlat % n;

                res.get(newRow).set(newCol, grid[i][j]);
            }
        }
        return res;
    }
}