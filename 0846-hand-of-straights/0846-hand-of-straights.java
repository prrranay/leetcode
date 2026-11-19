class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < hand.length; i++) {
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }

        while (!map.isEmpty()) {
            int first = map.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int curr=first+i;
                if (!map.containsKey(curr))
                    return false;


                int count = map.get(curr);

                if (count > 1) {
                    map.put(curr, map.get(curr) - 1);
                } else {
                    map.remove(curr);
                }
            }
        }

        return true;
    }
}