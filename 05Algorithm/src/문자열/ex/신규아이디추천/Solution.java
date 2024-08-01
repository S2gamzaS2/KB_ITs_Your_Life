package 문자열.ex.신규아이디추천;

import java.util.*;

class Solution {
    public String solution(String new_id) {
        // 1) 대문자 -> 소문자
        new_id = new_id.toLowerCase();

        // 2) 소문자, 숫자, -, _, . 제외 다 제거
        new_id = new_id.replaceAll("[^a-z0-9._-]", "");

        // 3) 마침표(.) 2회 이상 -> 1회
        int len = new_id.length();
        for(int i = 0; i < len; i++) {
            new_id = new_id.replace("..", ".");
        }


        // 4) 마침표 처음/끝 제거
        while(new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        }

        while(new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }

        StringBuilder sb = new StringBuilder(new_id);

        // 5) 빈문자열 -> a 대입
        if(sb.length() == 0) {
            sb.append("a");
        }

        // 6) 16자 이상 -> 첫 15자 외 모두 제거 -> 끝에 마침표 -> 제거
        if(sb.length() >= 16) {
            sb.setLength(15);
            if(sb.charAt(14) == '.') {
                sb.setLength(14);
            }
        }

        // 7) 2자 이해 -> 마지막 문자 길이 3 될때까지 반복
        int len3 = sb.length();
        String last = String.valueOf(sb.charAt(len3 - 1));
        if(len3 <= 2) {
            while(sb.length() != 3) {
                sb.append(last);
            }
        }
        return sb.toString();
    }

        public static void main(String[] args) {
        Solution solution = new Solution();
        String new_id = ".ab......cd.";
        String result = solution.solution(new_id);
        System.out.println(result);
    }
}
