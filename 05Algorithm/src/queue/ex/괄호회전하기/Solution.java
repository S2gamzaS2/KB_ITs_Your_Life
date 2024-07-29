package queue.ex.괄호회전하기;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

class Solution {
    public int solution(String s) {
        Queue<Character> q = new ArrayDeque<>();
        Deque<Character> st = new ArrayDeque<>();
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            q.add(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            int temp = 0;
            for(char c: q) {
                if (c == '[' || c == '(' || c == '{') {
                    st.push(c);
                } else if (st.isEmpty() ||
                        (c == ']' && st.peek() != '[') ||
                        (c == ')' && st.peek() != '(') ||
                        (c == '}' && st.peek() != '{')) {
                    temp = 1;
                    break;
                } else {
                    st.pop();
                }
            }

            if(st.isEmpty() && temp == 0) {
                answer++;
            }
            char c = q.remove();
            q.add(c);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "[)(]";
        int result = solution.solution(s);
        System.out.println(result);
    }
}