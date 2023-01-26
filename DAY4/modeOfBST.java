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
    int maxCount = -1000000;
    public void inorder(HashMap<Integer, Integer> map, TreeNode root)
    {
        if(root==null)
             return;
        inorder(map,root.left);
        if (map.containsKey(root.val)){
            map.put(root.val, map.get(root.val) + 1);
        }    
        else{
            map.put(root.val, 1);
        }    
        if (map.get(root.val) > maxCount)
            maxCount = map.get(root.val);        
        inorder(map ,root.right);
    }
    
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        inorder(map,root);
  
        // count
        List<Integer> resultList = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxCount) {
            resultList.add(key);
            }
        }
        

        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = resultList.get(i);
        }
        return result;

        
    }
}