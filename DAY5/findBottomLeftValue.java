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
    public int findBottomLeftValue(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() != 0){
            int size = queue.size();
            TreeNode curr = queue.poll();
            arr.add(curr.val);
            if(curr.left != null)
                queue.add(curr.left);
            if (curr.right != null)
                queue.add(curr.right);  
            for (int i = 1; i < size; i++){
                TreeNode cur = queue.poll();
                if(cur.left != null)
                    queue.add(cur.left);
                if (cur.right != null)
                    queue.add(cur.right);    
            }
        }   
        return arr.get(arr.size() - 1);
    }
}
