package CodingTest.Q1숫자문자열과영단어;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] num = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < num.length; i++) {
            if (s.contains(num[i])) {
                s = s.replace(num[i], String.valueOf(i));
            }
        }

        answer = Integer.parseInt(s);

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "onetwo3four";
        int result = solution.solution(s);
        System.out.println(result);
    }
}
