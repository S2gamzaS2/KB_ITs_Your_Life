package 재귀.순열.소수찾기;

import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        List<Integer> answerList = new ArrayList<>();
        int[] nums = new int[numbers.length()];
        for(int i = 0; i < nums.length; i++) {
            char c = numbers.charAt(i);
            nums[i] = c - '0';
        }

        for(int k = 1; k <= nums.length; k++) {
            boolean[] visited = new boolean[numbers.length()];
            List<List<Integer>> result = new ArrayList<>();
            backtrack(nums, k, visited, result, new ArrayList<>());
            for(List<Integer> n: result) {
                String number = "";
                int number_int = 0;
                for(int i : n) {
                    number += i;
                }

                while(number.startsWith("0")) {
                    number = number.substring(1);
                }

                if(number.equals("1") | number.isEmpty()) {
                    continue;
                }

                number_int = Integer.parseInt(number);

                if(isPrime(number_int)) {
                    answerList.add(number_int);
                }
            }

        }
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i : answerList){
            hashSet.add(i);
        }
        return hashSet.size();
    }

    // 소수 판별 메서드
    public boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // 백트래킹 메서드
    public void backtrack(int[] nums, int k, boolean[] visited, List<List<Integer>> result, List<Integer> current) {
        //base case
        if(current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        //recursive call
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) {
                continue;
            }
            current.add(nums[i]);
            visited[i] = true;
            backtrack(nums, k, visited, result, current);
            visited[i] = false;
            current.remove(current.size() - 1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String numbers = "17";
        int result = solution.solution(numbers);
        System.out.println(result);
    }
}
