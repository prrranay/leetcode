class Solution {
    public int minScore(int n, int[][] roads) {
        int ans = Integer.MAX_VALUE;

        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            graph.get(road[1]).add(new int[] { road[0], road[2] });
            graph.get(road[0]).add(new int[] { road[1], road[2] });
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[n + 1];
        stack.push(1);
        vis[1] = true;
        while (!stack.isEmpty()) {
            int node = stack.pop();

            for (int[] next : graph.get(node)) {
                ans = Math.min(ans, next[1]);
                if (!vis[next[0]]) {
                    vis[node] = true;
                    stack.push(next[0]);
                }
            }
        }
        return ans;
    }
}