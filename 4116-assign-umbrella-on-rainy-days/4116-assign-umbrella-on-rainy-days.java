class Solution {
    public String[] assignUmbrella(int[] rain) {
        List<String> ans=new ArrayList<>();

        int alice=0;
        int bob=0;
        for(int i=0;i<rain.length-1;i++){
            if(rain[i] == 1){
                if(rain[i+1] == 1){
                    if(bob<alice){
                        ans.add("Bob");
                        bob++;
                    }else{
                        ans.add("Alice");
                        alice++;
                    }
                }else{
                    ans.add("Bob");
                    bob++;
                }
            }else{
                ans.add("None");
            }
        }

        if(rain[rain.length-1] == 1){
            ans.add("Bob");
            bob++;
        }else{
            ans.add("None");
        }

        String[] res=new String[ans.size()];

        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }

        return res;
    }
}