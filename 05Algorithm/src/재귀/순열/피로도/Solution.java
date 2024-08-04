package 재귀.순열.피로도;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int answer = 0;
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        int cnt = 0;
        backtrack(k, dungeons, visited, cnt);
        return answer;
    }

    void backtrack(int k, int[][] dungeons, boolean[] visited, int cnt) {
        //base case;
       if(answer < cnt) {
           answer = cnt;
       }
        //recursive call
        for(int i = 0; i < dungeons.length; i++) {
            if(!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                backtrack(k - dungeons[i][1], dungeons, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = solution.solution(k, dungeons);
        System.out.println(result);
    }
}
