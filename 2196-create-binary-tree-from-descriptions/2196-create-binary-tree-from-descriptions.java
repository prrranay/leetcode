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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> set=new HashSet<>();

        for(int [] arr:descriptions){
            int parent=arr[0];
            int child=arr[1];
            TreeNode parentNode=null;
            TreeNode childNode=null;

            if(!map.containsKey(parent)){
                parentNode=new TreeNode(parent);
                map.put(parent,parentNode);
            }else{
                parentNode=map.get(parent);
            }


            if(!map.containsKey(child)){
                childNode=new TreeNode(child);
                map.put(child,childNode);
            }else{
                childNode=map.get(child);
            }

            if(arr[2] == 1){
                parentNode.left=childNode;
            }else{
                parentNode.right=childNode;
            }

            if(!set.contains(child)){
                set.add(child);
            }
        }

        for(int parent:map.keySet()){
            if(!set.contains(parent)){
                return map.get(parent);
            }
        }
        return null;
    }
}