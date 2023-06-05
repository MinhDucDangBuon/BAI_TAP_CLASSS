package BAITAP_CLASS.BAI_1;

import java.util.Scanner;


class HinhChuNhat {
    private double chieuDai;
    private double chieuRong;

    public HinhChuNhat(double chieuDai, double chieuRong) {
        if (chieuDai > 0 && chieuRong > 0) {
            this.chieuDai = chieuDai;
            this.chieuRong = chieuRong;
        } else {
            System.out.println("Chiều dài và chiều rộng phải lớn hơn 0");
        }
    }

    public double getChieuDai() {
        return chieuDai;
    }

    public void setChieuDai(double chieuDai) {
        if (chieuDai > 0) {
            this.chieuDai = chieuDai;
        } else {
            System.out.println("Chiều dài phải lớn hơn 0");
        }
    }

    public double getChieuRong() {
        return chieuRong;
    }

    public void setChieuRong(double chieuRong) {
        if (chieuRong > 0) {
            this.chieuRong = chieuRong;
        } else {
            System.out.println("Chiều rộng phải lớn hơn 0");
        }
    }

    public double tinhDienTich() {
        return chieuDai * chieuRong;
    }

    public double tinhChuVi() {
        return 2 * (chieuDai + chieuRong);
    }

    public String toString() {
        return "Chiều dài: " + chieuDai +
                ", Chiều rộng: " + chieuRong +
                ", Diện tích: " + tinhDienTich() +
                ", Chu vi: " + tinhChuVi();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chiều dài: ");
        double chieuDai = scanner.nextDouble();

        System.out.print("Nhập chiều rộng: ");
        double chieuRong = scanner.nextDouble();

        HinhChuNhat hinhChuNhat = new HinhChuNhat(chieuDai, chieuRong);
        System.out.println(hinhChuNhat.toString());

        scanner.close();
    }
}

/*
 Viết chương trình tính diện tích , chu vi hình chữ nhật - Hãy viết lớp HinhChuNhat gồm có :
+ Attributes : chiều dài, chiều rộng
+ Phương thức getters và setter thông tin chiều dài, chiều rộng
+ Phương thức tính diện tích , chu vi
+ Phương thức toString gồm các thông tin dài, rộng , diện tích, chu vi
- Xây dựng lớp chứa hàm main cho phần kiểm nghiệm. Dài rộng có thể nhập từ bàn phím
 */