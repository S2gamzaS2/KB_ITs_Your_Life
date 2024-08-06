package 재귀.순열.permutaions;

import java.util.*;
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        backtrack(new ArrayList<>(), nums, visited, result);

        return result;
    }

    // 순열 만들어서 result에 추가
    void backtrack(List<Integer> current, int[] nums, boolean[] visited, List<List<Integer>> result) {
        //basecase
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current)); //배열은 참조, current를 추가하면 뒤에 current값이 바뀌면 얘도 바뀜
            return;
        }

        //recursive call
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue; //방문했으면 건너뛰기
            }
            current.add(nums[i]); //추가
            visited[i] = true;
            backtrack(current, nums, visited, result);
            current.remove(current.size() - 1); //마지막 원소 제거
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }
}
