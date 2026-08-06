class Solution {
    public int smallestNumber(int n, int t) {
        while(n<=100){
            int pro=product(n);
            if(pro%t == 0){
                break;
            }
            n++;
        }
        return n;
    }
    int product(int n){
        int ans=1;
        while(n>0){
            ans*=(n%10);
            n/=10;
        }
        return ans;
    }
}