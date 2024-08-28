import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        String result = solution.solution(new_id);
        System.out.println(result);
    }
}

class Edge implements Comparable<Edge> {
    int node, cost;
    public Edge(int node, int cost){
        this.node = node;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

