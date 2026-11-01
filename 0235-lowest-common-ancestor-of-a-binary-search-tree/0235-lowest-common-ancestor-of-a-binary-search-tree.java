/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int parVal=root.val;
        int pVal=p.val;
        int qVal=q.val;

        if(parVal > pVal && parVal>qVal){
            return lowestCommonAncestor(root.left,p,q);
        }

        if(parVal< pVal && parVal < qVal){
            return lowestCommonAncestor(root.right,p,q);
        }

        return root;
    }
}