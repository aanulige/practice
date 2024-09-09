import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] invalidIndex = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                stack.push(i);
                invalidIndex[i] = true;
            } else if (s.charAt(i) == ')') {
                if(stack.isEmpty()){
                    invalidIndex[i] = true;
                }else{
                    int temp = stack.pop();
                    invalidIndex[temp] = false;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(!invalidIndex[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
