package queue.ex.괄호회전하기;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution2 {
    public int solution(String s) {
        int answer = 0;

        int len = s.length();

        // 괄호 문자열을 x2 해서 붙이기
        String ss = s + s;

        // 원래 괄호 문자열 길이(len) 만큼만 보는거야~~
        for(int i = 0; i < len; i++) {
            // i부터~ len만큼이 유효하면
            if(isValid(ss.substring(i, len + i))) {
                answer++; //answer +1~
            }
        }

        return answer;
    }

    // 유효한 괄호인지 판별하는 메서드 구현
    public boolean isValid(String s) {
        Deque<Character> st = new ArrayDeque<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                st.push(c);
            } else if (st.isEmpty() ||
                    (c == ')' && st.peek() != '(') ||
                    (c == ']' && st.peek() != '[') ||
                    (c == '}' && st.peek() != '{')) {
                return false;
            } else {
                st.pop();
            }
        }

        return st.isEmpty();
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        String s = "{}([][])";
        int result = solution.solution(s);
        System.out.println(result);
    }
}