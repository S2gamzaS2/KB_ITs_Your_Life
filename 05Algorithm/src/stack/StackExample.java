package stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackExample {
    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();

        //push (추가)
        st.push(1); //st: [1]
        st.push(2); //st: [2, 1]
        st.push(3); //st: [3, 2, 1]

        //peek (top 요소)
        System.out.println(st.peek()); //3

        //pop (추출)
        st.pop(); //st: [2, 1]
        st.pop(); //st: [1]
        st.pop(); //st: []

        st.push(4); //st: [4]
        st.push(5); //st: [5]

        //Empty
        while (!st.isEmpty()) {
            st.pop();
        }

        System.out.println(st); //st: []
    }
}
