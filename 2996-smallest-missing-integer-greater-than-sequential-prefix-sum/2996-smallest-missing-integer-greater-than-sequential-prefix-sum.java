class Solution {
    public int missingInteger(int[] nums) {
        int sum = nums[0];
        HashSet<Integer> set = new HashSet<>();
        set.add(sum);
        boolean skip = false;
        for (int i = 1; i < nums.length; i++) {
            set.add(nums[i]);
            if (!skip) {
                if (nums[i - 1] + 1 == nums[i]) {
                    sum += nums[i];
                } else {
                    skip=true;
                }
            }else{
                continue;
            }
        }

        while(set.contains(sum)){
            sum++;
        }
        return sum;
    }
}