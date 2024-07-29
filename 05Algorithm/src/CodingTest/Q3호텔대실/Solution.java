package CodingTest.Q3호텔대실;

import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        ArrayList<int[]> arrlist = new ArrayList<>();

        int answer = 0;
        int[][] new_time = new String[book_time.length][2];

        Arrays.sort(book_time, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return o1[0].compareTo(o2[0]);
            }
        });



        for(int i = 0; i < book_time.length; i++) {
            int start_time = Integer.parseInt(book_time[i][0].replace(":",""));
            int end_time = Integer.parseInt(book_time[i][1].replace(":","")) + 10;
            new_time[i][0] = start_time;
            new_time[i][1] = end_time;
        }

        int min = new_time[0][0];
        int max = new_time[0][1];

        arrlist.add(new int[]{min, max});

        for (int i = 1; i < new_time.length; i++) {
            int st = new_time[i][0];
            int et = new_time[i][1];

            if(st < min && et < min) {

            }
        }




        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        int result = solution.solution(book_time);
        System.out.println(result);
    }
}
