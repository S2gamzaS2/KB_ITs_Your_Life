package graph.bfs;

import java.util.*;
public class BFSExample {
    //인접리스트
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public static void bfs(int startVertex) {
        //시작점 설정
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startVertex);//예약
        visited.put(startVertex, true); //방문 여부 표시 - 중복 예약 방지 (진짜 방문 후 표시X)

        while(!q.isEmpty()){ //더이상 예약이 없을 때 까지
            //방문
            int curVertex = q.remove();
            System.out.println("이번 노드:" + curVertex);
            if(curVertex == 5) {
                System.out.println("원하는 노드 도착: " + curVertex);
                break;
            }
            //다음 방문예약
            for (int nextVertex: graph.get(curVertex)) {
                if (!visited.containsKey(nextVertex)) {
                    q.add(nextVertex);
                    visited.put(nextVertex, true);
                }
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
        bfs(0);
    }
}
