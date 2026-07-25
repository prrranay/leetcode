class Solution {
    Stack<Integer> stack = new Stack<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] pre : prerequisites) {
            if (graph.containsKey(pre[1])) {
                graph.get(pre[1]).add(pre[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(pre[0]);
                graph.put(pre[1], list);
            }
        }
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!solve(graph, i, state)) {
                return new int[0];
            }
        }
        int[] ans = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pop();
        }
        return ans;
    }

    public boolean solve(Map<Integer, List<Integer>> graph, int course, int[] state) {
        if (state[course] == 1) {
            return false;
        }
        if (state[course] == 2) {
            return true;
        }

        state[course] = 1;
        if (graph.get(course) != null) {
            for (int i : graph.get(course)) {
                if (!solve(graph, i, state)) {
                    return false;
                }
            }
        }
        stack.push(course);
        state[course] = 2;
        return true;
    }
}