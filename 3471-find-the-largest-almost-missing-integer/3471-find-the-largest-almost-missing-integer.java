class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }
            for (int num : set) {
                if (!map.containsKey(num)) {
                    map.put(num, 0);
                }
                map.put(num, map.get(num) + 1);
            }
        }
        int max = -1;
        for (int key : map.keySet()) {
            if (map.get(key) == 1)
                max = Math.max(max, key);
        }
        return max;
    }
}