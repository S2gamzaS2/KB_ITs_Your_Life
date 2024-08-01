package stack.ex.기능개발;

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int answer[] = {};
        Deque<Integer> st = new ArrayDeque<>();
        int len = progresses.length;
        for(int i = 0; i < len; i++) {

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] progresses = {20, 99, 93, 30, 55, 10};
        int[] speeds = {5, 10, 1, 1, 30, 5};
        int[] result = solution.solution(progresses, speeds);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }
}
