class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) return false;

        HashMap<Integer,Integer> map= new HashMap<>();

        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num:hand){
            int start=num;
            while(map.containsKey(start-1) && map.get(start-1) != 0){
                start--;
            }

            while(start <=num){
                while(map.containsKey(start) && map.get(start) != 0){
                    for(int i=start;i<start+groupSize;i++){
                        if(!map.containsKey(i) || map.get(i) == 0){
                            return false;
                        }
                        map.put(i, map.get(i)-1);
                    }
                }

                start++;
            }
        }

        return true;
    }
}