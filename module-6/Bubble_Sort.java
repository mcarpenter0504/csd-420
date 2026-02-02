/*
Name: Madilyn Carpenter
Date: 02/01/2026
Assignment 6
Purpose: Create bubble sort using comparable and comparator methods with asociating tests. 
*/

import java.util.Comparator;
import java.util.Arrays;

public class Bubble_Sort {

    // Bubble Sort using Comparable
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        // Outer loop for passes
        for (int i = 0; i < list.length - 1; i++) {

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < list.length - 1; j++) {

                // Compare and swap if needed
                if (list[j].compareTo(list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    // Bubble Sort using Comparator
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {

        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - 1; j++) {

                // Use comparator to compare elements
                if (comparator.compare(list[j], list[j + 1]) > 0) {
                    E temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        // Test Comparable version with Integers
        Integer[] numbers = {5, 3, 4, 9, 0, 1, 2, 7, 6, 8};
        System.out.println("Before Comparable sort: " + Arrays.toString(numbers));
        bubbleSort(numbers);
        System.out.println("After Comparable sort:  " + Arrays.toString(numbers));

        // Test Comparator version with Strings
        String[] names = {"Bob", "Alice", "David", "Carol"};
        System.out.println("\nBefore Comparator sort: " + Arrays.toString(names));

        // Sort alphabetically using Comparator
        bubbleSort(names, (a, b) -> a.compareTo(b));

        System.out.println("After Comparator sort:  " + Arrays.toString(names));
    }
}
