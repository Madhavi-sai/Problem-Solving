/*  
	class Node
		public  int frequency; // the frequency of this tree
    	public  char data;
    	public  Node left, right;
    
*/ 

    void decode(String s, Node root) {
        int count = 0;
        String str = "";
        while(count < s.length()){
            Node begin = root;
            while(begin.left != null && begin.right != null){    
                if (s.charAt(count) == '0')
                    begin = begin.left;
                else
                    begin = begin.right;
                count += 1;
            } 
            str += Character.toString(begin.data);
        }
        System.out.println(str);

    }