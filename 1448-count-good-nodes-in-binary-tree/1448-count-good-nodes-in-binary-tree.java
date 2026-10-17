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
    public int countGood(TreeNode root, int maxSoFar){
        int count=0;
        if(root == null) return 0;

        if(maxSoFar <= root.val){
            count++;
            maxSoFar=root.val;
        }

        count+=countGood(root.left,maxSoFar);
        count+=countGood(root.right,maxSoFar);

        return count;
    }

    public int goodNodes(TreeNode root) {
       return countGood(root,Integer.MIN_VALUE);
    }
}