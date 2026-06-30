class Solution {
    public int numberOfSubstrings(String s) {
        int[] counts = new int[3];
        int left = 0;
        int totalSubstrings = 0;
        int n = s.length();
        
        // Expand the window using the right pointer
        for (int right = 0; right < n; right++) {
            // Map 'a' -> 0, 'b' -> 1, 'c' -> 2
            counts[s.charAt(right) - 'a']++;
            
            // While the window contains at least one of each character
            while (counts[0] > 0 && counts[1] > 0 && counts[2] > 0) {
                // Shrink the window from the left
                counts[s.charAt(left) - 'a']--;
                left++;
            }
            
            // After the while loop breaks, 'left' represents the exact number 
            // of valid substrings ending at the current 'right' index.
            totalSubstrings += left;
        }
        
        return totalSubstrings;
    }
}