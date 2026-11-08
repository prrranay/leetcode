class Solution {
    public int countServers(int[][] grid) {
        int numRows=grid.length;
        int numCols=grid[0].length;
        int countServers=0;

        for(int row=0;row<numRows;row++){
            for(int col=0;col<numCols;col++){
                if(grid[row][col] == 1){
                    boolean canCommunicate=false;

                    for(int curCol=0;curCol<numCols;curCol++){
                        if(curCol == col) continue;

                        if(grid[row][curCol] == 1){
                            canCommunicate=true;
                            break;
                        }
                    }

                    if(canCommunicate){
                        countServers++;
                    }else{
                        for(int curRow=0;curRow<numRows;curRow++){
                        if(curRow == row) continue;

                        if(grid[curRow][col] == 1){
                            canCommunicate=true;
                            break;
                        }
                    }
                    if(canCommunicate){
                        countServers++;
                    }
                    }
                }
            }
        }
        return countServers;
    }
}