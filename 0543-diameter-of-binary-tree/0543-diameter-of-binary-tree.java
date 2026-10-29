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
    int maxDia=0;

    public int calcHeight(TreeNode node){
        if(node == null) return 0;

        int left=calcHeight(node.left);
        int right=calcHeight(node.right);

        maxDia=Math.max(maxDia,left+right);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        calcHeight(root);
        return maxDia;
    }
}