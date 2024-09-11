import java.util.*;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(1, new ArrayList<>(), n, k, result);

        return result;
    }

    void backtrack(int start, List<Integer> current, int n, int k, List<List<Integer>> result) {
        //basecase
        if(current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        //recursive call
        for(int i = start; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, current, n, k, result);
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int k = 3;
        List<List<Integer>> result = solution.combine(n, k);
        System.out.println(result);
    }
}
