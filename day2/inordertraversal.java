We use cookies to ensure you have the best browsing experience on our website. By using our site, you acknowledge that you have read and understood our Cookie Policy & Privacy Policy
Got it!



















































/* A Binary Tree node

class Node {
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */
class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> arr = new ArrayList<>();
    public ArrayList<Integer> inOrder(Node root) {
        Solution sol = new Solution();
        inorderTraversal(root);
        return this.arr;
    }
    public void inorderTraversal(Node root) {
        if (root == null){
            return;
        }
        inorderTraversal(root.left);
        this.arr.add(root.data);
        inorderTraversal(root.right);
    }    
}
