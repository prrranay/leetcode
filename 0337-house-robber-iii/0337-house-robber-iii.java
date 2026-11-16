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
    HashMap<TreeNode, Integer> dp=new HashMap<>();
    public int rob(TreeNode root) {
        return solve(root);
    }

    public int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        if(dp.containsKey(root)){
            return dp.get(root);
        }

        int take=root.val;

        if(root.left != null){
            take+=solve(root.left.left)+solve(root.left.right);
        }
        if(root.right != null){
            take+=solve(root.right.left)+solve(root.right.right);
        }

        int skip=solve(root.left)+solve(root.right);
        int ans=Math.max(take,skip);
        dp.put(root,ans);
        return ans;
    }
}