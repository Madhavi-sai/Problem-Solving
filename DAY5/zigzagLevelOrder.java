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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> arr = new ArrayList<>();
        if (root == null)
            return arr;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean bool = true;
        while(queue.size() != 0){
            int size = queue.size();
            ArrayList<Integer> arr1 = new ArrayList<>();
            int level = arr.size() - 1;
            for (int i = 0; i < size; i++){
                TreeNode curr = queue.poll();
                arr1.add(curr.val);
                if(curr.left != null)
                    queue.add(curr.left);
                if (curr.right != null)
                    queue.add(curr.right);    
            }
            if (bool == true){
                bool = false;
                arr.add(arr1);
            }
            else{
                bool = true;
                ArrayList<Integer> arr2 = new ArrayList<Integer>();
                for (int i = arr1.size() - 1; i >= 0; i--)
                    arr2.add(arr1.get(i));
                arr.add(arr2);
            }
        }   
        return arr;
        
    }
}
