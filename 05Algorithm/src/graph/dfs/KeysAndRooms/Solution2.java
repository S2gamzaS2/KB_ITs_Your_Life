package graph.dfs.KeysAndRooms;
import java.util.*;
class Solution2 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        bfs(rooms, visited, 0);
        for(int i = 0; i < visited.length; i++) {
            if(!visited[i]) {
                return false;
            }
        }
        return true;
    }

    public void bfs(List<List<Integer>> rooms, boolean[] visited, int v) {
        Queue<Integer> q = new ArrayDeque<>();
        visited[0] = true;
        q.add(v);

        while(!q.isEmpty()) {
            int curVertex = q.remove();
            for(int nextVertex: rooms.get(curVertex)) {
                if(!visited[nextVertex]) {
                    q.add(nextVertex);
                    visited[nextVertex] = true;
                }
            }
        }
    }
}
