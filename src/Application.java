import java.util.*;
public class Application {

    public static void launchApp() {
        Scanner input = new Scanner(System.in);
        short option = 0;
        boolean optionSelected;

        while(true) {

            optionSelected = false;
            while (!optionSelected) {

                System.out.println("Select an Option: ");
                System.out.println("1. Calculate Price");
                System.out.println("2. Calculate Yield");
                System.out.println("3. Quit");

                try {
                    option = Short.parseShort(input.next());
                    if (option > 0 && option < 4) optionSelected = true;
                    else System.out.println("Input is invalid. Try Again.");
                } catch (NumberFormatException nfe) {
                    System.out.println("Input is invalid. Try Again.");
                }
            }

            Calculator c = null;

            if (option == 1) {
                c = new PriceCalculator();
                c.collectData();

            } else if (option == 2) {
                c = new YieldCalculator();
                c.collectData();
            } else {
                System.exit(0);
            }

            c.calculate();
        }
    }

    public static void main(String[] args) {

        launchApp();
    }
}
