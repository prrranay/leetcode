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
    public int calcHeight(TreeNode node){
        if(node == null) return 0;

        int left=calcHeight(node.left);
        int right=calcHeight(node.right);

        return Math.max(left,right)+1;
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null ) return true;

        int left=calcHeight(root.left);
        int right=calcHeight(root.right);

        int diff = Math.abs(left - right);
        return diff < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
}