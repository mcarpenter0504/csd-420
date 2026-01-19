/*
Name: Madilyn Carpenter
Date: 01/18/2026
Assignment 4
Purpose: Store 50,000 integers in LinkedList and test the time to traverse the list using an iterator vs. using the get(index) method.
*/

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTraversalTest {

    // Method to measure traversal using an iterator
    public static long traverseWithIterator(LinkedList<Integer> list) {
        long start = System.nanoTime();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
        long end = System.nanoTime();
        return end - start;
    }

    // Method to measure traversal using get(index)
    public static long traverseWithGet(LinkedList<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        long end = System.nanoTime();
        return end - start;
    }

    // Method to fill a LinkedList with n integers
    public static LinkedList<Integer> fillList(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {

        int[] sizes = {50_000, 500_000};

        for (int size : sizes) {
            System.out.println("Testing LinkedList with " + size + " elements:");

            // Fill the list
            LinkedList<Integer> list = fillList(size);

            // Traverse using iterator
            long timeIterator = traverseWithIterator(list);
            System.out.printf("Traversal with iterator: %.3f ms%n", timeIterator / 1_000_000.0);

            // Traverse using get(index)
            long timeGet = traverseWithGet(list);
            System.out.printf("Traversal with get(index): %.3f ms%n", timeGet / 1_000_000.0);

            System.out.println();
        }
    }
}