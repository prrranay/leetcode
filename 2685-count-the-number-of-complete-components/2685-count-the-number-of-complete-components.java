class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                vis[i] = true;

                int vertices = 0;
                int edgeCount = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    vertices++;
                    edgeCount += graph[node].size();

                    for (int nei : graph[node]) {
                        if (!vis[nei]) {
                            vis[nei] = true;
                            q.offer(nei);
                        }
                    }
                }

                edgeCount /= 2;

                if (edgeCount == vertices * (vertices - 1) / 2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}