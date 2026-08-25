class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c))
                map.put(c, 0);
            map.put(c, map.get(c) + 1);
        }
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) == 0) {
                    return c;
                }
                map.put(c, map.get(c) - 1);
            }else{
                return c;
            }
        }
        return 'c';
    }
}