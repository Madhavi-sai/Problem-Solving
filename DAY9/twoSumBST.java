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
class BinarySearchIterator{
    Stack<TreeNode> stack = new Stack<>();
    boolean forward;
    public void pushAll(TreeNode node){
        while(node != null){
            stack.push(node);
            if (forward){
                node = node.left;
            }
            else{
                node = node.right;
            }
        }
    }
    public BinarySearchIterator(TreeNode root, Boolean bool){
        this.forward = bool;
        pushAll(root);
    }

    public int next(){
        TreeNode t = stack.pop();
        if (forward){
            pushAll(t.right);
        }
        else{
            pushAll(t.left);
        }
        return t.val;
    }

    public boolean hasNext(){
        return !stack.isEmpty();
    }
} 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BinarySearchIterator forward = new BinarySearchIterator(root, true);
        BinarySearchIterator backward = new BinarySearchIterator(root, false);
        int left = forward.next();
        int right = backward.next();
        while(left < right){
            if (left + right == k)
                return true;
            else if (left + right < k){
                left = forward.next();
            } 
            else{
                right = backward.next();
            }   
        }
        return false;
    }
}