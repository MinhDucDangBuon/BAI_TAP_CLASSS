package BAITAP_CLASS.BAI_5;
import java.util.Scanner;
class Rational {
    private int numerator;   // Tử số
    private int denominator; // Mẫu số

    public Rational(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Mẫu số không thể bằng 0");
        }

        // Đưa phân số về dạng tối giản
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    // Tìm ước chung lớn nhất của hai số
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Phương thức tối giản phân số
    public void reduce() {
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Phương thức nghịch đảo phân số
    public void reciprocal() {
        if (numerator == 0) {
            throw new ArithmeticException("Không thể nghịch đảo phân số có tử số bằng 0");
        }
        int temp = numerator;
        numerator = denominator;
        denominator = temp;
    }

    // Phương thức cộng hai phân số
    public Rational add(Rational other) {
        int newNumerator = numerator * other.denominator + other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Phương thức trừ hai phân số
    public Rational subtract(Rational other) {
        int newNumerator = numerator * other.denominator - other.numerator * denominator;
        int newDenominator = denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Phương thức nhân hai phân số
    public Rational multiply(Rational other) {
        int newNumerator = numerator * other.numerator;
        int newDenominator = denominator * other.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    // Phương thức chia hai phân số
    public Rational divide(Rational other) {
        if (other.numerator == 0) {
            throw new ArithmeticException("Không thể chia cho phân số có tử số bằng 0");
        }
        int newNumerator = numerator * other.denominator;
        int newDenominator = denominator * other.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    // Phương thức so sánh hai phân số
    public boolean equals(Rational other, double tolerance) {
        double fraction1 = (double) numerator / denominator;
        double fraction2 = (double) other.numerator / other.denominator;
        double difference = Math.abs(fraction1 - fraction2);
        return difference <= tolerance;
    }

    // Getter cho tử số
    public int getNumerator() {
        return numerator;
    }

    // Getter cho mẫu số
    public int getDenominator() {
        return denominator;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập phân số thứ nhất
        System.out.print("Nhập tử số phân số thứ nhất: ");
        int numerator1 = scanner.nextInt();
        System.out.print("Nhập mẫu số phân số thứ nhất: ");
        int denominator1 = scanner.nextInt();
        Rational fraction1 = new Rational(numerator1, denominator1);

        // Nhập phân số thứ hai
        System.out.print("Nhập tử số phân số thứ hai: ");
        int numerator2 = scanner.nextInt();
        System.out.print("Nhập mẫu số phân số thứ hai: ");
        int denominator2 = scanner.nextInt();
        Rational fraction2 = new Rational(numerator2, denominator2);

        // Hiển thị phân số sau khi tối giản
        fraction1.reduce();
        fraction2.reduce();
        System.out.println("Phân số sau khi tối giản:");
        System.out.println("Phân số thứ nhất: " + fraction1.getNumerator() + "/" + fraction1.getDenominator());
        System.out.println("Phân số thứ hai: " + fraction2.getNumerator() + "/" + fraction2.getDenominator());

        // Nghịch đảo phân số
        fraction1.reciprocal();
        fraction2.reciprocal();
        System.out.println("Phân số nghịch đảo:");
        System.out.println("Phân số thứ nhất: " + fraction1.getNumerator() + "/" + fraction1.getDenominator());
        System.out.println("Phân số thứ hai: " + fraction2.getNumerator() + "/" + fraction2.getDenominator());

        // Cộng trừ nhân chia hai phân số
        Rational sum = fraction1.add(fraction2);
        Rational difference = fraction1.subtract(fraction2);
        Rational product = fraction1.multiply(fraction2);
        Rational quotient = fraction1.divide(fraction2);

        System.out.println("Tổng hai phân số: " + sum.getNumerator() + "/" + sum.getDenominator());
        System.out.println("Hiệu hai phân số: " + difference.getNumerator() + "/" + difference.getDenominator());
        System.out.println("Tích hai phân số: " + product.getNumerator() + "/" + product.getDenominator());
        System.out.println("Thương hai phân số: " + quotient.getNumerator() + "/" + quotient.getDenominator());

        // So sánh hai phân số
        System.out.print("Nhập sai số cho phép: ");
        double tolerance = scanner.nextDouble();
        boolean isEqual = fraction1.equals(fraction2, tolerance);
        System.out.println("Hai phân số có bằng nhau không? " + isEqual);

        scanner.close();
    }
}

/*
Hãy thiết kế class Phân số ( Rational ) để thực hiện các chức năng sau :
- Tối giản phân số ( reduce )
- Nghịch đảo phân số ( reciprocal )
- Cộng trừ nhân chia 2 phân số
- So sánh 2 phân số, sử dụng sai số 0.0001 ( tolerance ) để so sánh
 */
