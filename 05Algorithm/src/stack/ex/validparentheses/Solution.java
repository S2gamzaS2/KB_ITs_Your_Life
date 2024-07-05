package stack.ex.validparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        int len = s.length();

        for(int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (st.isEmpty()){
                return false;
            } else if(c == ')') {
                if (st.peek() == '(') {
                        st.pop();
                    } else return false;
            } else if(c == '}') {
                if (st.peek() == '{') {
                        st.pop();
                    } else return false;
            } else if(c == ']') {
                if (st.peek() == '[') {
                        st.pop();
                    } else return false;
            }
        }

        return st.isEmpty();

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s1 = "([{}]){[]}";
        boolean result = sol.isValid(s1);
        System.out.println(result);
    }
}
