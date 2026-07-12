class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] dum=arr.clone();
        Arrays.sort(dum);
        int ans[]=new int[arr.length];
        Map<Integer,Integer> map=new HashMap<>();
        int i=1;
        for(int d:dum){
            if(!map.containsKey(d)){
                map.put(d,i);
                i++;
            }
        }

        for(i=0;i<arr.length;i++){
            ans[i]=map.get(arr[i]);
        }
        return ans;
    }
}