/*
Name: Madilyn Carpenter
Date: 02/15/2026
Assignment 8
Purpose: Use three threads to output three types of characters to a text area for display. 
*/

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MadilynThreeThreads {
    private JTextArea textArea = new JTextArea();
    private Random random = new Random();

    public static void main(String[] args) throws InterruptedException {
        MadilynThreeThreads app = new MadilynThreeThreads();
        app.startThreads();

        Thread.sleep(5000); 

        // Run test
        app.runTests();
    }

    public void startThreads() {
        JFrame frame = new JFrame("Three Threads Output");
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setLineWrap(true);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // Random letters
        Thread lettersThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                char c = (char) ('a' + random.nextInt(26));
                appendText(Character.toString(c));
            }
        });

        // Random digits
        Thread digitsThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                char c = (char) ('0' + random.nextInt(10));
                appendText(Character.toString(c));
            }
        });

        // Random special characters
        char[] specialChars = {'!', '@', '#', '$', '%', '&', '*'};
        Thread specialThread = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                char c = specialChars[random.nextInt(specialChars.length)];
                appendText(Character.toString(c));
            }
        });

        lettersThread.start();
        digitsThread.start();
        specialThread.start();
    }

    private void appendText(String text) {
        SwingUtilities.invokeLater(() -> textArea.append(text));
    }

    // Test Code
    public void runTests() {
        String content = textArea.getText();
        int lettersCount = 0, digitsCount = 0, specialCount = 0;

        for (char c : content.toCharArray()) {
            if (c >= 'a' && c <= 'z') lettersCount++;
            else if (c >= '0' && c <= '9') digitsCount++;
            else if ("!@#$%&*".indexOf(c) >= 0) specialCount++;
        }

        System.out.println("Letters: " + lettersCount);
        System.out.println("Digits: " + digitsCount);
        System.out.println("Special chars: " + specialCount);

        assert lettersCount >= 10000 : "Letter count test failed!";
        assert digitsCount >= 10000 : "Digit count test failed!";
        assert specialCount >= 10000 : "Special character test failed!";
    }
}
