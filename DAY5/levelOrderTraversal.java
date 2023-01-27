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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if (root == null)
            return arr;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            arr.add(new ArrayList<>());
            int level = arr.size() - 1;
            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                arr.get(level).add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);    
            }
        }   
        return arr;
    }
}
