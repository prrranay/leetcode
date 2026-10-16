class Solution {
    Map<String,Integer> map=new HashMap<>();
    public int calculateMinimumHP(int[][] dungeon) {
      return solve(0,0,dungeon);  
    }

    int solve(int i, int j, int[][] dungeon){
        if(i >= dungeon.length || j>= dungeon[0].length) return Integer.MAX_VALUE;

        String key=i+"key"+j;
        if(map.containsKey(key)){
            return map.get(key);
        }

        int health=Math.min(solve(i+1,j,dungeon),solve(i,j+1,dungeon));

        if(health == Integer.MAX_VALUE) health=1;

        int res=Math.max(health - dungeon[i][j], 1);
        map.put(key,res);
        return res;
    }
}