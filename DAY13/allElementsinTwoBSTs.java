class Solution {
    ArrayList<Integer> arr1 = new ArrayList<>();
    ArrayList<Integer> arr2 = new ArrayList<>();
    public void inorder(TreeNode root, ArrayList<Integer> arr){
        if (root == null)
            return;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);    
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1, arr1);
        inorder(root2, arr2);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = arr1.size();
        int m = arr2.size();
        int i = 0;
        int j = 0;
        while(i < n && j < m){
            if (arr1.get(i) <= arr2.get(j)){
                arr.add(arr1.get(i));
                i++;
            }
            else{
                arr.add(arr2.get(j));
                j++;
            }
        }
        while(i < n){
            arr.add(arr1.get(i));
            i++;
        }
        while(j < m){
            arr.add(arr2.get(j));
            j++;
        }
        return arr;
    }
}
