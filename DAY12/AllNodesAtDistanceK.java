class Solution {
    Map<TreeNode,TreeNode> parents = new HashMap<>();
    public void buildParentMap(TreeNode root,TreeNode parent){
        if(root == null)
            return;
        this.parents.put(root, parent);
        buildParentMap(root.left,root); 
        buildParentMap(root.right,root);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        buildParentMap(root, root);
         for (Map.Entry<TreeNode, TreeNode> mapElement : parents.entrySet()) {
                TreeNode key = mapElement.getKey();
                TreeNode value = (mapElement.getValue());
                System.out.println(key.val + " : " + value.val);
        }
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        visited.add(target);
        int level = 0;
        while(q.size() != 0){
            if(level == k){
                int n = q.size();
                for(int i = 0; i < n; i++){
                    res.add(q.poll().val);
                }
                break;
            } 
            int size = q.size();
            for(int i = 0; i < size; i++){                
                TreeNode t = q.poll();
                if(t.left != null && !visited.contains(t.left)){
                    q.add(t.left);
                    visited.add(t.left);
                }
                if(t.right != null && !visited.contains(t.right)){
                    q.add(t.right);
                    visited.add(t.right);
                }
                TreeNode parent = parents.get(t);
                if(!visited.contains(parent)){ 
                    q.add(parent);
                    visited.add(parent);
                }
            }
            level++;
        }
        return res; 
    }
}
