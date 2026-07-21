class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') {
                ones++;
            }
        }
        s = '1' + s + '1';
        int i = 0;
        int n = s.length();
        int ans = ones;
        while (i < n && s.charAt(i) == '1') {
            i++;
        }
        int lastBlock = 0;
        while (i < n && s.charAt(i) == '0') {
            i++;
            lastBlock++;
        }
        while (i < n) {
            int temp = 0;
            while (i < n && s.charAt(i) == '1') {
                i++;
                temp++;
            }
            if (temp == 0) {
                return ans;
            }
            int newBlock = 0;
            while (i < n && s.charAt(i) == '0') {
                newBlock++;
                i++;
            }
            if (newBlock == 0) {
                return ans;
            }
            ans = Math.max(ans, ones + newBlock + lastBlock);
            lastBlock = newBlock;
        }
        return ans;
    }
}