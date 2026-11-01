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
    List<Integer> arr=new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        inOrder(root);
        
        return arr.size() >= k ? arr.get(k-1) : -1;
    }

    public void inOrder(TreeNode node){
        if(node == null) return;

        inOrder(node.left);
        arr.add(node.val);
        inOrder(node.right);
    }
}