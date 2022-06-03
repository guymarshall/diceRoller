import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of dice to roll: ");
        int numberOfDice = scanner.nextInt();
        System.out.print("Number of sides per die: ");
        int numberOfSides = scanner.nextInt();

        ArrayList<Integer> result = rollDice(numberOfDice, numberOfSides);
        System.out.println("Sides rolled:");
        System.out.println(result);

        System.out.println("Saving dice rolls to file");
        try {
            FileWriter fileWriter = new FileWriter(numberOfDice + " " + numberOfSides + "-sided dice.txt");
            fileWriter.write(String.valueOf(result));
            fileWriter.close();
            System.out.println("Dice rolls have been saved to file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
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
}