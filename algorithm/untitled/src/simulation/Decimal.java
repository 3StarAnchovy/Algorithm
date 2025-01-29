package simulation;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Decimal {
    public static void main(String[] args) {
        String upmuG;
        String tax_cd = "";
        double prinAmt = 291201053;
        double faceAmt = 291232345.0;
        double dIncRate = 1.0;
        double dResRate = 1.0;
        double intRate = 2.0;
        double aIntAmt = 0;
        double taxInc = 0;
        double taxRes = 0;
        double pIntAmt = 0;
        int days = 2;

        Scanner scanner = new Scanner(System.in);

        upmuG = scanner.next();

        switch (upmuG) {
            case "1":
                prinAmt = faceAmt / (((1 - (dIncRate + dResRate) / 100) * intRate * days / 36500) + 1);
                prinAmt = trunc(prinAmt);
                pIntAmt = trunc(prinAmt * intRate * days / 36500);
                taxInc = trunc(pIntAmt * dIncRate / 100, -1d);
                taxRes = trunc(pIntAmt * dResRate / 100, -1d);

                aIntAmt = trunc(pIntAmt - taxInc - taxRes);
                prinAmt = prinAmt + (faceAmt - (prinAmt + pIntAmt - taxInc - taxRes));
                break;
            case "2":
                pIntAmt = trunc(prinAmt * intRate * days / 36500);
                taxInc = trunc(pIntAmt * dIncRate / 100, -1d);
                taxRes = trunc(pIntAmt * dResRate / 100, -1d);

                aIntAmt = trunc(pIntAmt - taxInc - taxRes);
                faceAmt = trunc(prinAmt + pIntAmt - taxInc - taxRes);
                break;

            case "3":
                days = (int)trunc(
                    (faceAmt - prinAmt) * 365 / (prinAmt * intRate / 100 * (1 - dIncRate / 100 - dResRate / 100)));

            case "4":
                intRate = (faceAmt - prinAmt) * 365 / (prinAmt * days * (1 - dIncRate / 100 - dResRate / 100)) * 100;
                break;
        }

        System.out.println("prinAmt: " + prinAmt);
        System.out.println("pIntAmt: " + pIntAmt);
        System.out.println("taxInc: " + taxInc);
        System.out.println("taxRes: " + taxRes);
        System.out.println("aIntAmt: " + aIntAmt);
        System.out.println("faceAmt: " + faceAmt);

        print(upmuG);
    }

    // trunc 함수 구현 (소수점 이하를 버리는 함수)
    public static double trunc(double value) {
        return (value < 0) ? Math.ceil(value) : Math.floor(value);
    }

    // trunc 함수 오버로드 (특정 자리에서 반올림하거나 버리기)
    // trunc 함수 오버로드 (precision이 음수인 경우도 처리)
    public static double trunc(double value, double precision) {
        if (precision == 0) {
            return trunc(value);
        }

        // precision에 따라 factor 계산 (음수 처리 포함)
        double factor = Math.pow(10, precision);
        if (precision < 0) {
            factor = 1 / Math.pow(10, -precision);
        }

        return trunc(value * factor) / factor;
    }

    public static void print(String upmuG) {
        System.out.println();
        System.out.println("bigdeciaml");
        BigDecimal prinAmt = new BigDecimal("291201053");
        BigDecimal faceAmt = new BigDecimal("291232345");
        BigDecimal dIncRate = new BigDecimal("1");
        BigDecimal dResRate = new BigDecimal("1");
        BigDecimal intRate = new BigDecimal("2");
        BigDecimal aIntAmt = BigDecimal.ZERO;
        BigDecimal taxInc = BigDecimal.ZERO;
        BigDecimal taxRes = BigDecimal.ZERO;
        BigDecimal pIntAmt = BigDecimal.ZERO;
        int days = 2;

        switch (upmuG) {
            case "1":
                BigDecimal denominator = BigDecimal.ONE.subtract(
                        dIncRate.add(dResRate).divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP))
                    .multiply(intRate)
                    .multiply(new BigDecimal(days))
                    .divide(new BigDecimal("36500"), 10, RoundingMode.HALF_UP)
                    .add(BigDecimal.ONE);

                prinAmt = faceAmt.divide(denominator, 10, RoundingMode.HALF_UP);

                prinAmt = trunc(prinAmt, 0);
                pIntAmt = trunc(prinAmt.multiply(intRate)
                    .multiply(new BigDecimal(days))
                    .divide(new BigDecimal("36500"), 10, RoundingMode.HALF_UP), 0);
                taxInc = trunc(pIntAmt.multiply(dIncRate).divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP), -1);
                taxRes = trunc(pIntAmt.multiply(dResRate).divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP), -1);

                aIntAmt = trunc(pIntAmt.subtract(taxInc).subtract(taxRes), 0);
                prinAmt = prinAmt.add(faceAmt.subtract(prinAmt.add(pIntAmt).subtract(taxInc).subtract(taxRes)));

            case "2":
                pIntAmt = trunc(prinAmt.multiply(intRate).multiply(new BigDecimal(days))
                    .divide(new BigDecimal("36500"), 10, RoundingMode.HALF_UP), 0);
                taxInc = trunc(pIntAmt.multiply(dIncRate).divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP), -1);
                taxRes = trunc(pIntAmt.multiply(dResRate).divide(new BigDecimal("100"), 10, RoundingMode.HALF_UP), -1);

                aIntAmt = trunc(pIntAmt.subtract(taxInc).subtract(taxRes), 0);
                faceAmt = trunc(prinAmt.add(pIntAmt).subtract(taxInc).subtract(taxRes), 0);
                break;
        }

        System.out.println("prinAmt: " + prinAmt);
        System.out.println("pIntAmt: " + pIntAmt);
        System.out.println("taxInc: " + taxInc);
        System.out.println("taxRes: " + taxRes);
        System.out.println("aIntAmt: " + aIntAmt);
        System.out.println("faceAmt: " + faceAmt);
    }

    public static BigDecimal trunc(BigDecimal value, int precision) {
        return value.setScale(precision, RoundingMode.DOWN);
    }
}
