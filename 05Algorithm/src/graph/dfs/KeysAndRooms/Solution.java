package graph.dfs.KeysAndRooms;
import java.util.*;
class Solution {
    static Map<Integer, List<Integer>> graph = new HashMap<>();
    static Map<Integer, Boolean> visited = new HashMap<>();

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        for(int i = 0; i < n; i++) {
            graph.put(i, rooms.get(i) != null ? rooms.get(i) : new ArrayList<>());
            visited.put(i, false);
        }
        bfs(0);

        for (int i = 0; i < n; i++) {
            if (!visited.get(i)) {
                return false;
            }
        }

        return true;
    }

    public static void bfs(int startVertex) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(startVertex);
        visited.put(startVertex, true);

        while (!q.isEmpty()) {
            int curVertex = q.remove();
            if(graph.get(curVertex) != null) {
                for(int nextVertex: graph.get(curVertex)) {
                    if(!visited.get(nextVertex)) {
                        q.add(nextVertex);
                        visited.put(nextVertex, true);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> rooms = Arrays.asList(
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(3),
                Arrays.asList(null)
        );
        boolean result = solution.canVisitAllRooms(rooms);
        System.out.println(result);
    }
}
