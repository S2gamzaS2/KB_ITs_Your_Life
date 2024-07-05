package stack.ex.올바른괄호;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> st = new ArrayDeque<>();

        //for문 - 문자 하나하나에 접근
        //열린 괄호 -> 스택에 추가
        //닫힌 괄호 -> pop

        final int LEN = s.length();
        for(int i = 0; i < LEN; i++) {
            char c = s.charAt(i);
            if(c == '(') {
                st.push(c);
            } else  {
                if(st.isEmpty()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }

        //스택이 비어있지 않으면 false
        return st.isEmpty();

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s1 = "(())()";
        boolean result = solution.solution(s1);
        System.out.println(result);
    }
}
