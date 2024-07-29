package CodingTest.Q2과일장수;

import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        Queue<Integer> q = new ArrayDeque<>();

        int answer = 0;
        Arrays.sort(score);
        int len = score.length;

        int a = len / m ;
        int b = a * m;

        for(int i = len - 1; i >= len - b; i--) {
            q.add(score[i]);
        }

        for(int i = 0; i < a; i++) {
            int min = q.remove();
            for(int j = 0; j < m - 1; j++) {
                int num = q.remove();
                if(num < min) {
                    min = num;
                }
            }

            int price = min * m;
            answer += price;
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 3;
        int m = 4;
        int[] score = {1, 2, 3, 1, 2, 3, 1};
        int result = solution.solution(k, m, score);
        System.out.println(result);
    }
}
