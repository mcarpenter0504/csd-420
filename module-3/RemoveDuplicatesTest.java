/*
Name: Madilyn Carpenter
Date: 12/21/2025
Assignment 3
Purpose: Create an array with random numbers and run through a function that removes duplicate numbers.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicatesTest {

    public static void main(String[] args) {
        // Create and fill an ArrayList with random numbers
        ArrayList<Integer> randomList = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            randomList.add(rand.nextInt(20) + 1);
        }

        System.out.println("Generated List: " + randomList);
        // Call removeDuplicates function
        ArrayList<Integer> listWithoutDups = removeDuplicates(randomList);

        System.out.println("List without duplicates: " + listWithoutDups);
    }

    // Method to remove duplicates in an array
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        HashSet<E> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
}
