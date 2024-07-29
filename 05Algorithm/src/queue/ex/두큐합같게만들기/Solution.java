package queue.ex.두큐합같게만들기;

import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        int len = queue1.length;
        int answer = 0;

        // 두 배열을 두 큐에 넣기
        for (int i = 0; i < len; i++) {
            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        // 큐 초기 합
        long sum1 = q1.stream().mapToInt(Integer::intValue).sum();
        long sum2 = q2.stream().mapToInt(Integer::intValue).sum();

        // 두 큐의 총 합이 홀수면 -1 반환
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }

        while (answer <= len * 3) {
            if (sum1 > sum2) {
                int num = q1.remove();
                q2.add(num);
                sum1 -= num;
                sum2 += num;
            } else if (sum1 < sum2) {
                int num = q2.remove();
                q1.add(num);
                sum1 += num;
                sum2 -= num;
            } else { return answer;}

            answer++;
        }
        return -1;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        int result = solution.solution(queue1, queue2);

        System.out.println(result);
    }
}