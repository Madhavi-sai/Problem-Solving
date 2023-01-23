class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(stack.isEmpty() || stack.peek() != ch)
                 stack.add(ch);
            else 
                stack.pop();
        }
        char[] arr = new char[stack.size()];
        for(int i=stack.size() - 1; i>=0; i--)
            arr[i] = stack.pop();
        return new String(arr);     
    }
}