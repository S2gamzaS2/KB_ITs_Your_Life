package stack.ex.dailytemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> st = new ArrayDeque<>();

        int len = temperatures.length; //8
        int[] answer = new int[len];

        for(int i = 0; i < len; i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                int j = st.pop();
                answer[j] = i - j;
            }
            st.push(i);
        }
        return answer;

    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] s1 = {73,74,75,71,69,72,76,73}; //[1,1,4,2,1,1,0,0]
        int[] result = sol.dailyTemperatures(s1);
        for(int i: result) {
            System.out.println(i);
        }
    }
}
