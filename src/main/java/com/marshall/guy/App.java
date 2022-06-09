package com.marshall.guy;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of dice to roll: ");
        int numberOfDice = scanner.nextInt();
        System.out.print("Number of sides per die: ");
        int numberOfSides = scanner.nextInt();
        scanner.close();

        ArrayList<Integer> result = rollDice(numberOfDice, numberOfSides);
        System.out.println("Sides rolled:");
        System.out.println(result);

        System.out.println("Saving dice rolls to file");
        String fileName = numberOfDice + " " + numberOfSides + "-sided dice";
        String fileContents = String.valueOf(result);
        saveFile(fileName, fileContents);
    }

    public static ArrayList<Integer> rollDice(int numberOfDice, int numberOfSides) {
        ArrayList<Integer> diceRolls = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfDice; i++) {
            int result = random.nextInt(numberOfSides) + 1;
            diceRolls.add(result);
        }

        return diceRolls;
    }

    public static void saveFile(String fileName, String fileContents) {
        String extension = ".txt";
        try (FileWriter fileWriter = new FileWriter(fileName + extension)) {
            fileWriter.write(fileContents);
            System.out.println("Contents have been saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
