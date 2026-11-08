class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans=new ArrayList<>();

        int n=s1.length();

        int i=0;

        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();


        while(i<n){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            i++;
            if(c1 == c2){
                continue;
            }
            
            sb1.append(c1);
            sb2.append(c2);
            if(i<n && s1.charAt(i) == s2.charAt(i)){
                List<String> temp=new ArrayList<>();
                temp.add(sb1.toString());
                temp.add(sb2.toString());
                ans.add(temp);
                sb1=new StringBuilder();
                sb2=new StringBuilder();
            }else if(i == n){
                List<String> temp=new ArrayList<>();
                temp.add(sb1.toString());
                temp.add(sb2.toString());
                ans.add(temp);
            }
        }

        return ans;
    }
}