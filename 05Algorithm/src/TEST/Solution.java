import java.util.*;

class Solution{
    public int solution(String numbers) {

    }

    public void permutation(String numbers, int cur, boolean[] visited, int digit) {
        int Len = numbers.length();
        if(digit == Len) return;

        if(int i = 0; i < Len; i++) {
            if(visited[i]) continue;
        }

    }

    public boolean isPrime(int n) {
        if(n < 2) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}