import java.text.DecimalFormat;
import java.util.*;

public class PriceCalculator extends Calculator {

    protected double rate;

    public double getRate() {
        return this.rate;
    }

    public void setRate(double r) {
        this.rate = r;
    }

    @Override
    public void collectData() {

        Scanner pc = new Scanner(System.in);
        boolean validRate = false;

        System.out.println("Price Calculator");

        super.collectData();

        while(!validRate) {

            try {
                System.out.print("Enter Rate: ");
                setRate(Double.parseDouble(pc.next()));
            }
            catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                continue;
            }
            validRate = true;
        }
    }

    public void calculate() {
        long startTime = System.currentTimeMillis();
        double c = CalcPrice(getCoupon(), getYears(), getFace(), getRate());

        long duration = System.currentTimeMillis() - startTime;

        DecimalFormat df = new DecimalFormat("#0.0000000");
        System.out.println("Current Price : " + df.format(c) + "\nCalculation Time(ms): " + duration);
    }

}
