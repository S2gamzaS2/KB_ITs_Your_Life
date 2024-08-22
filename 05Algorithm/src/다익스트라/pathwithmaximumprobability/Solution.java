package 다익스트라.pathwithmaximumprobability;

import java.util.*;
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        //성공 확률 저장 배열
        double[] dp = new double[n];

        dp[start] = 1; //시작노드 확률 = 1

        while (true) {
            boolean updated = false;

            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double prob = succProb[j];

                // u에서 v로 가는 경로가 더 높은 확률을 제공하면 갱신
                if (dp[u] * prob > dp[v]) {
                    dp[v] = dp[u] * prob;
                    updated = true;
                }

                // v에서 u로 가는 경로가 더 높은 확률을 제공하면 갱신
                if (dp[v] * prob > dp[u]) {
                    dp[u] = dp[v] * prob;
                    updated = true;
                }
            }

            // 갱신X - 루프 종료
            if (!updated) break;
        }

        return dp[end];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int[][] edges = {
                {0, 1},
                {1, 2},
                {0, 2}
        };
        double[] succProb = {0.5, 0.5, 0.2};
        int start_node = 0;
        int end_node = 2;
        double result = solution.maxProbability(n, edges, succProb, start_node, end_node);
        System.out.println(result);
    }
}

