/*
Name: Madilyn Carpenter
Date: 12/14/2025
Assignment 2
Purpose: Write an array of ints and another array of doubles to f dat file.
*/

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WriteData {

    public static void main(String[] args) {
        String filename = "MadilynCarpenter_datafile.dat";
        Random random = new Random();

        try (FileWriter writer = new FileWriter(filename, true)) {
            // Create random int array
            writer.write("Random Integers: ");
            for (int i = 0; i < 5; i++) {
                int randInt = random.nextInt(100); // 0–99
                writer.write(randInt + " ");
            }
            writer.write("\n");

            // Create random double array
            writer.write("Random Doubles: ");
            for (int i = 0; i < 5; i++) {
                double randDouble = random.nextDouble() * 100;
                writer.write(randDouble + " ");
            }
            writer.write("\n");

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file.");
            e.printStackTrace();
        }
    }
}