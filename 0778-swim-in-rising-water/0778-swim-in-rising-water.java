class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int left = grid[0][0], right = n * n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canSwim(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean canSwim(int[][] grid, int t) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        return dfs(grid, 0, 0, visited, t);
    }

    public boolean dfs(int[][] grid, int i, int j, boolean[][] visited, int t) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || visited[i][j] || grid[i][j] > t) {
            return false;
        }

        if (i == n - 1 && j == n - 1) {
            return true;
        }
        visited[i][j]=true;

        return dfs(grid, i + 1, j, visited, t) || dfs(grid, i - 1, j, visited, t) || dfs(grid, i, j + 1, visited, t)
                || dfs(grid, i, j - 1, visited, t);
    }
}