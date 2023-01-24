class BinaryTree
{
    static int sumBT(Node head){
        if (head == null){
            return 0;
        }
        int left = sumBT(head.left);
        int right = sumBT(head.right);
        return left + right + head.data;
    }
}
