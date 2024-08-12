package graph.dfs;

import java.util.*;
public class DFSExample {
    //인접리스트
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public static void dfs(int curVertex) {
        //방문
        visited.put(curVertex, true);

        //현재 노드와 연결된 방문 안 한 노드 찾기
        for (int nextVertex : graph.get(curVertex)) {
            if (!visited.containsKey(nextVertex)) { //방문 안했다면
                //다음 방문 노드
                dfs(nextVertex); //재귀
            }
        }
    }

    public static void makeGraph() {
        graph.put(0, Arrays.asList(1, 3, 6));
        graph.put(1, Arrays.asList(0, 3));
        graph.put(2, Arrays.asList(3));
        graph.put(3, Arrays.asList(0, 1, 2, 7));
        graph.put(4, Arrays.asList(5));
        graph.put(5, Arrays.asList(4, 6, 7));
        graph.put(6, Arrays.asList(0, 5));
        graph.put(7, Arrays.asList(3, 5));
    }

    public static void main(String[] args) {
        makeGraph();
        dfs(0);
    }
}
