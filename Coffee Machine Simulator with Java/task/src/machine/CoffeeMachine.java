package machine;
import java.util.Scanner;

public class CoffeeMachine {
    final static int WATER_PER_CUP = 200;
    final static int MILK_PER_CUP = 50;
    final static int COFFEE_PER_CUP = 15;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        int availableWater = input.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int availableMilk = input.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int availableCoffee = input.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        int requiredCups = input.nextInt();

        int availableCups = checkIngredients(availableWater, availableMilk, availableCoffee);

        int extraCups = availableCups  - requiredCups;

        if  (availableCups == requiredCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (availableCups < requiredCups) {
            System.out.println("No, I can make only " + availableCups + " cup(s) of coffee");
        } else {
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        }
    }

    public static int checkIngredients(int availableWater, int availableMilk, int availableCoffee){
           int cupsWater = availableWater / WATER_PER_CUP;
           int cupsMilk = availableMilk / MILK_PER_CUP;
           int cupsCoffee = availableCoffee / COFFEE_PER_CUP;

           return Math.min(cupsWater, Math.min(cupsMilk, cupsCoffee));
    }
}