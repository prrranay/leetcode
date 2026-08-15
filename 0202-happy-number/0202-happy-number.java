class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen=new HashSet<>();

        while(n != 1 && !seen.contains(n)){
            seen.add(n);
            n= sum(n);
        }

        return n==1;
    }
    
    int sum(int n){
        int ans=0;

        while(n>0){
            int digit=n%10;
            ans+=digit*digit;
            n/=10;
        }
        return ans;
    }
}