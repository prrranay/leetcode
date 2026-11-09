class Solution {
    String[] letterSet={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> ans=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        solve(0,digits,"");
        return ans;
    }

    void solve(int idx, String digits,String curr){
        if(curr.length() ==  digits.length()){
            ans.add(curr);
            return;
        }

        String letters=letterSet[digits.charAt(idx)-'0'];

        for(char letter:letters.toCharArray()){
            solve(idx+1,digits,curr+letter);
        }
    }
}