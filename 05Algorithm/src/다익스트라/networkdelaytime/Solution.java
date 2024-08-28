package 다익스트라.networkdelaytime;

import java.util.*;
class Edge implements Comparable<Edge> {
    int node;
    int cost;
    public Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] times = {
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        };
        int n = 4;
        int k = 2;
        int result = solution.networkDelayTime(times, n, k);
        System.out.println(result);
    }
}
