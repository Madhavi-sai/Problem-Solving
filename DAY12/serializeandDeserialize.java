public class Codec {

    // Encodes a tree to a single string.
    String str;
    TreeNode temp;
    public String serialize(TreeNode root) {
        if(root == null)
          return "";
        Queue<TreeNode> q = new LinkedList<>();
        String res = "";
        q.add(root);
        while(!q.isEmpty()){
            TreeNode temp = q.poll();
            if (temp == null) {   
                res += "N ";
                continue;
            }
            res += temp.val + " ";
            q.add(temp.left);
            q.add(temp.right);
        }
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == "") 
            return null;
        String ans[] = data.split(" ");
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(ans[0]));
        q.add(root);
        int i = 1;
        while(i < ans.length){
            TreeNode temp = q.poll();
            if(ans[i].equals("N"))
                temp.left = null;
            else{
                TreeNode node = new TreeNode(Integer.parseInt(ans[i]));
                temp.left = node;
                q.add(node);
            }   
            i++; 
            if(ans[i].equals("N"))
                temp.right = null;
            else{
                TreeNode node = new TreeNode(Integer.parseInt(ans[i]));
                temp.right = node;
                q.add(node);
            }  
            i++;
        }

        return root;
    }
}
