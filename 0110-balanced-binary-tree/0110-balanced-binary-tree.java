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
    public int calcH(TreeNode node){
        if(node == null){
            return 0;
        }

        int left=calcH(node.left)+1;
        int right=calcH(node.right)+1;

        return Math.max(left,right);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null ) return true;

        int left=calcH(root.left);
        int right=calcH(root.right);
        int d=Math.abs(left-right);

        if(d>1){
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }
}