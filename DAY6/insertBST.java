class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
            Node parent = null;
            Node curr = root;
            while(curr != null){
                parent = curr;
                if (Key == curr.data)
                    return root;
                if (Key < curr.data)
                    curr = curr.left;
                else
                    curr = curr.right;     
            }
            if (Key < parent.data)
                parent.left = new Node(Key);
            else
                parent.right = new Node(Key);
            return  root;   
            
    }
}
