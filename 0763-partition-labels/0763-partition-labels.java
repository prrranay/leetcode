class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),i);
        }


        int last=0;
        int size=0;

        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            size++;
            int curr=map.get(s.charAt(i));
            last=Math.max(last,curr);

            if(i == last){
                ans.add(size);
                size=0;
            }
        }

        return ans;
    }
}