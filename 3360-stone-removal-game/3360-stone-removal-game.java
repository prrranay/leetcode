class Solution {
    boolean win=false;
    public boolean canAliceWin(int n) {
        solve(n,10);
        return win;
    }

    public void solve(int n, int count){
        if(n<=0){
            return;
        }
        if(count>n){
            return;
        }
        win=!win;
        solve(n-count,count-1);
    }
}