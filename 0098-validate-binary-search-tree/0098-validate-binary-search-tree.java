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
    Integer prev=null;
    public boolean isValidBST(TreeNode root) {
        return solve(root);
    }

    public boolean solve(TreeNode root){
        if(root == null) return true;

        if(!solve(root.left)){
            return false;
        }
        if(prev != null && root.val <= prev){
            return false;
        }
        prev=root.val;
        return solve(root.right);
    }
}