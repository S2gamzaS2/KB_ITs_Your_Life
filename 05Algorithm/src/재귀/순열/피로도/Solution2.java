package 재귀.순열.피로도;

class Solution2 {
    int answer = 0;
    boolean[] visited;
    int n;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        visited = new boolean[n];
        backtrack(k, dungeons, 0);
        return answer;
    }

    public void backtrack(int k, int[][] dungeons, int cnt) {
       if(cnt > answer) {
           answer = cnt;
       }

        for (int i = 0; i < n; i++) {
            if(k >= dungeons[i][0] && !visited[i]){
                visited[i] = true;
                backtrack(k - dungeons[i][1], dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int k = 80;
        int[][] dungeons = {{80, 20}, {50, 40}, {30, 10}};
        int result = solution.solution(k, dungeons);
        System.out.println(result);
    }
}
