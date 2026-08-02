class Solution {
    public List<Integer> partitionLabels(String s) {
        int last[]=new int[26];
        int n=s.length();

        for(int i=0;i<n;i++){
            last[s.charAt(i)-'a']=i;
        }
        int end=0;
        int start=0;
        List<Integer> res=new ArrayList<>();
        for(int i=0;i<n;i++){
            end=Math.max(last[s.charAt(i)-'a'],end);
            if(end == i){
                res.add((end-start)+1);
                start=end+1;
            }
        }
        return res;
    }
}