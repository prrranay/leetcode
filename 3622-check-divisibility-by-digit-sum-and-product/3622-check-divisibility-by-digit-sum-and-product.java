class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int mul=1;
        int num=n;
        while(n > 0){
            int dig=n%10;
            sum+=dig;
            mul*=dig;
            n/=10;
        }

        return num % (sum+mul) == 0;
    }
}