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
    int max=Integer.MIN_VALUE;
    public int maxGain(TreeNode node){
        if(node == null) return 0;

        int left=Math.max(maxGain(node.left),0);
        int right=Math.max(maxGain(node.right),0);

        int currPath=node.val+left+right;
        max=Math.max(max,currPath);

        return node.val+Math.max(left,right);
    }
    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return max;
    }
}