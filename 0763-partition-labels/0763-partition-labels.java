class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map=new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++){
            char c= s.charAt(i);
            map.put(c,i);
        }

        List<Integer> ans=new ArrayList<>();

        int size=0;
        int end=0;
        for(int i=0;i<n;i++){
            size++;
            end=Math.max(map.get(s.charAt(i)),end);
            if(end == i){
                ans.add(size);
                size=0;
            }
        }
        return ans;
    }
}