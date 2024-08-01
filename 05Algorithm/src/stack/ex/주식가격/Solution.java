package stack.ex.주식가격;

import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int len = prices.length;
        int[] answer = new int[len];

        Deque<Integer> st = new ArrayDeque<>();

        for(int i = 0; i < len; i++) {
            while(!st.isEmpty() && prices[st.peek()] > prices[i]) {
                answer[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }
        int day = 0;
        if(!st.isEmpty()){
            day = st.peek();
        }
        while(!st.isEmpty()) {
            answer[st.peek()] = day - st.peek();
            st.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {1, 2, 3, 2, 3};
        int[] result = solution.solution(prices);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }
}
