package lesson14;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MoneyAndBigDecimal {

    public static void main(String[] args) {
        double priceD = 199.99;
        double vatD = priceD * 0.08;
        double totalD = priceD + vatD;

        System.out.println("Vat double: " + vatD);
        System.out.println("Total double: " + totalD);
        System.out.println("Rounding VAT: " + Math.round(vatD * 100) / 100.0);

        BigDecimal price = new BigDecimal("199.99");
        BigDecimal vat = price.multiply(new BigDecimal("0.08"));
        BigDecimal vatRounded = vat.setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = price.add(vatRounded);

        System.out.println("BigDecimal");
        System.out.println("VAT chưa làm tròn = " + vat);
        System.out.println("VAT (HALF_UP, 2)  = " + vatRounded);
        System.out.println("Tổng              = " + total);

        System.out.println("double VAT == BigDecimal VAT chưa làm tròn ? "
                + (new BigDecimal(vatD).compareTo(vat) == 0));
        System.out.println("real double VAT = " + new BigDecimal(vatD));

        BigDecimal bD1 = new BigDecimal("2.0");
        BigDecimal bD2 = new BigDecimal("2.00");

        System.out.println("bD1 = " + bD1 + " (scale " + bD1.scale() + ")");
        System.out.println("bD2= " + bD2 + " (scale " + bD2.scale() + ")");
        System.out.println("bD1.equals(bD2)    = " + bD1.equals(bD2));
        System.out.println("bD1.compareTo(bD2) = " + bD1.compareTo(bD2));

    }
}
