import java.util.*;
class Solution2 {
    public int solution(int k, int[][] dungeons) {
        int answer = 0;
        int len = dungeons.length;

        Boolean[] visited = new Boolean[len];

        return answer;
    }

    public void dfs (int a, int k, int[][] dungeons) {
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > k) {
                continue;
            }
            visited[i] == true;
            dfs(i + 1, k - dungeons[i][1], dungeons);
            visited[i] == false;

        }

    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int k = 80;
        int[][] dungeons= {{80, 20},{50, 40},{30, 10}};
        int result = solution.solution(k, dungeons);
        System.out.println(result);
    }
}
