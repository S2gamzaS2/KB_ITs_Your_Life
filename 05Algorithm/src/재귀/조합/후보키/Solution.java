//package 재귀.조합.후보키;
//
//import java.util.*;
//
//class Solution {
//    public int solution(String[][] relation) {
//        int answer = 0;
//        int cols = relation[0].length;
//        System.out.println(cols);
//        for(int i = 1; i <= cols; i++) {
//            List<List<Integer>> result = new ArrayList<>();
//            combination(0, cols - 1, i, new HashSet<>(), result);
//            System.out.println(result);
//
//            for(int j = 0; j < relation.length; j++) {
//
//            }
//        }
//
//        return answer;
//    }
//
//    void combination(int start, int n, int k, Set<Integer> current, List<List<Integer>> result) {
//        if(current.size() == k) {
//            result.add(new ArrayList<>(current));
//            return;
//        }
//
//        for(int i = start; i <= n; i++) {
//            current.add(i);
//            combination(i + 1, n, k, current, result);
//            current.remove(current.size() - 1);
//        }
//    }
//
//    //유일성 검사
//    boolean checkUnique(Set<Integer> cols, String[][] relation){
//
//    }
//
//    //최소성검사
//    boolean checkMin() {
//
//    }
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String[][] relation = {
//                {"100", "ryan", "music", "2"},
//                {"200", "apeach", "math", "2"},
//                {"300", "tube", "computer", "3"},
//                {"400", "con", "computer", "4"},
//                {"500", "muzi", "music", "3"},
//                {"600", "apeach", "music", "2"}
//        };
//        int result = solution.solution(relation);
//        System.out.println(result);
//    }
//}

// 프로젝트하면서 ->