/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer,Integer> count=new HashMap<>();
    int max=0;

    public int[] findFrequentTreeSum(TreeNode root) {
        dfs(root);
        List<Integer> res=new ArrayList<>();

        for(int sum:count.keySet()){
            if(count.get(sum) ==  max){
                res.add(sum);
            }
        }
        
        int n=res.size();
        int[] ans=new int[n];

        for(int i=0;i<n;i++){
            ans[i]=res.get(i);
        }

        return ans;
    }

    int dfs(TreeNode node){
        if(node == null) return 0;

        int sum=dfs(node.left)+dfs(node.right)+node.val;

        count.put(sum,count.getOrDefault(sum,0)+1);
        max=Math.max(max,count.get(sum));

        return sum;
    }
}