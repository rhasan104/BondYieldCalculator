import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Calculator {

    protected double coupon;
    protected int years;
    protected double face;

    public double getCoupon() {
        return this.coupon;
    }

    public void setCoupon(double c) {
        this.coupon = c;
    }

    public int getYears() {
        return this.years;
    }

    public void setYears(int y) {
        this.years = y;
    }

    public double getFace() {
        return this.face;
    }

    public void setFace(double f) {
        this.face = f;
    }

    public void collectData() {

        Scanner s = new Scanner(System.in);
        boolean validInfo = false;

        while(!validInfo) {

            try {
                System.out.print("Enter Coupon: ");
                setCoupon(Double.parseDouble(s.next()));
            }
            catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                continue;
            }

            try {
                System.out.print("Enter Years: ");
                setYears(Integer.parseInt(s.next()));
            }
            catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                continue;
            }

            try {
                System.out.print("Enter Face: ");
                setFace(Double.parseDouble(s.next()));
            }
            catch (NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                continue;
            }

            validInfo = true;
        }
    }

    public void calculate() {
        //override
    }

    protected double CalcPrice(double c, int y, double f, double r) {

        double p = 0;
        for (int i = 0; i < y; i++) {
            p += (c * f) / Math.pow(1 + r, i + 1);
        }
        p += (f / Math.pow(1 + r, y));

        return round(p);
    }

    public double round(double d) {
        BigDecimal bd = new BigDecimal(d).setScale(7, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
