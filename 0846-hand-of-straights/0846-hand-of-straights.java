class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        while(!map.isEmpty()){
            int first=map.firstKey();
            for(int i=0;i<groupSize;i++){
                int curr=first+i;
                if(!map.containsKey(curr)) return false;

                int count=map.get(curr);
                if(count == 1){
                    map.remove(curr);
                }else{
                    map.put(curr,count-1);
                }
            }
        }
        return true;
    }
}