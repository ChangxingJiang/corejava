package priorityQueue;

import java.util.*;
import java.time.*;

/**
 * 这个程序展示了如何使用一个优先队列
 *
 * @author Cay Horstmann
 * @version 1.02 2015-06-20
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        var pq = new PriorityQueue<LocalDate>();
        pq.add(LocalDate.of(1906, 2, 19));  // G. Hopper
        pq.add(LocalDate.of(1815, 12, 10));  // A. Lovelace
        pq.add(LocalDate.of(1903, 12, 3));  // J. von Neumann
        pq.add(LocalDate.of(1910, 6, 22));  // K.Zuse

        System.out.println("Iterating over elements ...");
        for (LocalDate date : pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements ...");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
