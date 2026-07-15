class Solution {
    public int gcdOfOddEvenSums(int n) {
        int sumEven=n*(n+1);
        int sumOdd=n*n;
        return gcd(sumEven,sumOdd);
    }
    public int gcd(int n, int m){
        if(n%m == 0){
            return m;
        }

        return gcd(m,n%m);
    }
}