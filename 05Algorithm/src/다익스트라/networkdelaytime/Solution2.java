package 다익스트라.networkdelaytime;

class Solution2 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 각 노드까지의 최소 시간을 저장할 배열 (INF로 초기화)
        int[] minTime = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            minTime[i] = Integer.MAX_VALUE;
        }

        // 시작 노드의 시간은 0으로 설정
        minTime[k] = 0;

        // n번 반복해서 모든 노드를 확인
        for (int i = 1; i <= n; i++) {
            for (int[] time : times) {
                int u = time[0]; // 출발 노드
                int v = time[1]; // 도착 노드
                int w = time[2]; // 소요 시간

                // 출발 노드를 거쳐가는 경로가 더 짧으면 갱신
                if (minTime[u] != Integer.MAX_VALUE && minTime[u] + w < minTime[v]) {
                    minTime[v] = minTime[u] + w;
                }
            }
        }

        // 모든 노드 중 가장 늦게 도착하는 시간을 찾음
        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (minTime[i] == Integer.MAX_VALUE) {
                return -1; // 도달할 수 없는 노드가 있다면 -1 반환
            }
            result = Math.max(result, minTime[i]);
        }

        return result; // 가장 늦게 도착하는 시간을 반환
    }


    public static void main(String[] args) {
        Solution2 solution = new Solution2();
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
