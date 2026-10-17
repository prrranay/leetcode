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
    public void solve(TreeNode node){
        if(node == null) return;
        solve(node.left);
        arr.add(node.val);
        solve(node.right);
        return;
    }
    public int kthSmallest(TreeNode root, int k) {
        solve(root);
        return arr.get(k-1);
    }
}