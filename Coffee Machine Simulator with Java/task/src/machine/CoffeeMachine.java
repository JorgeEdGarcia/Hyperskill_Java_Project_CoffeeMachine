package machine;
import java.util.Scanner;

public class CoffeeMachine {

    final static int WATER_PER_CUP = 250;
    final static int MILK_PER_CUP = 100;
    final static int COFFEE_PER_CUP = 15;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //{water, milk, coffeBeans, disposableCups, money}
        int [] machineState = {400, 540, 120, 9, 550};

        System.out.println("The coffee machine has:");
        System.out.println(machineState[0] + " ml of water");
        System.out.println(machineState[1] + " ml of milk");
        System.out.println(machineState[2] + " g of coffee beans");
        System.out.println(machineState[3] + " disposable cups");
        System.out.println("$"+machineState[4] + " of money");
        System.out.println();

        System.out.println("Write action (buy, fill, take):");
        String userAction = input.nextLine();

        if (userAction.equals("fill")) {
            fill(machineState);
        } else if (userAction.equals("take")) {
            take(machineState);
        } else if (userAction.equals("buy")) {
            Coffee espresso =
                    new Coffee("Espresso", 250, 0, 16, 4);
            Coffee latte =
                    new Coffee("Latte", 350, 75, 20, 7);
            Coffee cappuccino =
                    new Coffee("Cappuccino", 200, 100, 12, 6);

            System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
            int choice = input.nextInt();

            Coffee selectedCoffee = switch (choice) {
                case 1 -> espresso;
                case 2 -> latte;
                case 3 -> cappuccino;
                default -> null;
            };

            if (selectedCoffee != null) {
                buy(machineState, selectedCoffee);
            }
        }

        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(machineState[0] + " ml of water");
        System.out.println(machineState[1] + " ml of milk");
        System.out.println(machineState[2] + " g of coffee beans");
        System.out.println(machineState[3] + " disposable cups");
        System.out.println("$"+machineState[4] + " of money");

        /*System.out.println("Write how many ml of water the coffee machine has:");
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
            System.out.println("Yes, I can make that amount of coffee (and even "
                                                                        + extraCups + " more than that)");
        }*/
    }

     static class Coffee {
        String name;
        int water;
        int milk;
        int coffeeBeans;
        int price;

        public Coffee(String name, int water, int milk, int coffeeBeans, int price) {
            this.name = name;
            this.water = water;
            this.milk = milk;
            this.coffeeBeans = coffeeBeans;
            this.price = price;
        }
    }



    public static void fill(int [] machineState){
        Scanner input = new Scanner(System.in);
        System.out.println("Write how many ml of water you want to add:");
        int water = input.nextInt();
        System.out.println("Write how many ml of milk you want to add: ");
        int milk = input.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffeeBeans = input.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int disposableCups = input.nextInt();

        machineState[0] += water;
        machineState[1] += milk;
        machineState[2] += coffeeBeans;
        machineState[3] += disposableCups;
    }
    public static void take(int [] machineState){
        System.out.println("I gave you $" +  machineState[4]);
        machineState[4] = 0;
    }

    public static void buy(int[] machineState, Coffee coffee) {
        machineState[0] -= coffee.water;
        machineState[1] -= coffee.milk;
        machineState[2] -= coffee.coffeeBeans;
        machineState[3]--;
        machineState[4] += coffee.price;
    }


    public static int checkIngredients(int availableWater, int availableMilk,
                                       int availableCoffee){
        int cupsWater = availableWater / WATER_PER_CUP;
        int cupsMilk = availableMilk / MILK_PER_CUP;
        int cupsCoffee = availableCoffee / COFFEE_PER_CUP;
        return Math.min(cupsWater, Math.min(cupsMilk, cupsCoffee));
    }
}