package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayDequeExample {
    public static void main(String[] args) {
        Queue<Integer> q = new ArrayDeque<>();

        //enqueue (추가)
        q.add(1); //q: [1]
        q.add(2); //q: [1, 2]
        q.add(3); //q: [1, 2, 3]

        //peek (제일 앞 요소)
        System.out.println(q.peek()); //1

        //dequeue (추출)
        q.remove(); //q: [2, 3]
        q.remove(); //q: [3]
        q.remove(); //q: []

        q.add(5); //q: [5]

        //Empty
        while(!q.isEmpty()) {
            q.remove();
        }

        System.out.println(q); //q: []
    }
}

