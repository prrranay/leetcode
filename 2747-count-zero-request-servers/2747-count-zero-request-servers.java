import java.util.*;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int qLen = queries.length;
        int[] arr = new int[qLen];

        // 1. Sort logs by time
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        // 2. Pair each query with its original index and sort by query time
        int[][] sortedQueries = new int[qLen][2];
        for (int i = 0; i < qLen; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        // 3. Sliding window across sorted logs
        int[] count = new int[n + 1]; // Tracks request count per server in current window
        int activeServers = 0;        // Replaces set.size()
        int left = 0, right = 0;

        for (int[] q : sortedQueries) {
            int end = q[0];
            int start = end - x;
            int originalIdx = q[1];

            // Expand window: add logs with time <= end
            while (right < logs.length && logs[right][1] <= end) {
                int serverId = logs[right][0];
                if (count[serverId] == 0) {
                    activeServers++;
                }
                count[serverId]++;
                right++;
            }

            // Shrink window: remove logs with time < start
            while (left < logs.length && logs[left][1] < start) {
                int serverId = logs[left][0];
                count[serverId]--;
                if (count[serverId] == 0) {
                    activeServers--;
                }
                left++;
            }

            arr[originalIdx] = n - activeServers;
        }

        return arr;
    }
}