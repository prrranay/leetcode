class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;

        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int need;
                if(i == m-1 && j == n-1){
                    need=Math.max(1,1-dungeon[i][j]);
                }else if(i == m-1){
                    need=Math.max(1,dungeon[i][j+1] - dungeon[i][j]);
                }else if(j == n-1){
                    need=Math.max(1,dungeon[i+1][j] - dungeon[i][j]);
                }else{
                    int min=Math.min(dungeon[i+1][j], dungeon[i][j+1]);
                    need=Math.max(1,min-dungeon[i][j]);
                }
                dungeon[i][j]=need;
            }
        }
        return dungeon[0][0];
    }
}