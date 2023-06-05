package BAITAP_CLASS.BAI_3;

import java.util.Scanner;

import java.util.Scanner;

class Vehicle {
    private double giaTriXe;
    private double dungTichXYLanh;

    public Vehicle(double giaTriXe, double dungTichXYLanh) {
        this.giaTriXe = giaTriXe;
        this.dungTichXYLanh = dungTichXYLanh;
    }

    public double getGiaTriXe() {
        return giaTriXe;
    }

    public void setGiaTriXe(double giaTriXe) {
        this.giaTriXe = giaTriXe;
    }

    public double getDungTichXYLanh() {
        return dungTichXYLanh;
    }

    public void setDungTichXYLanh(double dungTichXYLanh) {
        this.dungTichXYLanh = dungTichXYLanh;
    }

    public double tinhThueTruocBa() {
        if (dungTichXYLanh < 100) {
            return giaTriXe * 0.01;
        } else if (dungTichXYLanh <= 200) {
            return giaTriXe * 0.03;
        } else {
            return giaTriXe * 0.05;
        }
    }
}

public class QuanLyXe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Vehicle xe1 = null, xe2 = null, xe3 = null;
        double giaTriXe, dungTichXYLanh;

        int choice;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Nhập thông tin và tạo các đối tượng xe");
            System.out.println("2. Xuất bảng kê khai tiền thuế trước bạ của các xe");
            System.out.println("3. Thoát");
            System.out.print("Chọn công việc: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Nhập thông tin và tạo các đối tượng xe
                    System.out.println("--- Nhập thông tin xe 1 ---");
                    System.out.print("Nhập giá trị xe: ");
                    giaTriXe = scanner.nextDouble();
                    System.out.print("Nhập dung tích xy lanh: ");
                    dungTichXYLanh = scanner.nextDouble();
                    xe1 = new Vehicle(giaTriXe, dungTichXYLanh);

                    System.out.println("--- Nhập thông tin xe 2 ---");
                    System.out.print("Nhập giá trị xe: ");
                    giaTriXe = scanner.nextDouble();
                    System.out.print("Nhập dung tích xy lanh: ");
                    dungTichXYLanh = scanner.nextDouble();
                    xe2 = new Vehicle(giaTriXe, dungTichXYLanh);

                    System.out.println("--- Nhập thông tin xe 3 ---");
                    System.out.print("Nhập giá trị xe: ");
                    giaTriXe = scanner.nextDouble();
                    System.out.print("Nhập dung tích xy lanh: ");
                    dungTichXYLanh = scanner.nextDouble();
                    xe3 = new Vehicle(giaTriXe, dungTichXYLanh);

                    break;
                case 2:
                    // Xuất bảng kê khai tiền thuế trước bạ của các xe
                    System.out.println("--- Bảng kê khai tiền thuế trước bạ của các xe ---");
                    if (xe1 != null) {
                        System.out.println("Xe 1:");
                        System.out.println("Giá trị xe: " + xe1.getGiaTriXe());
                        System.out.println("Dung tích xy lanh: " + xe1.getDungTichXYLanh());
                        System.out.println("Tiền thuế trước bạ: " + xe1.tinhThueTruocBa());
                    }

                    if (xe2 != null) {
                        System.out.println("Xe 2:");
                        System.out.println("Giá trị xe: " + xe2.getGiaTriXe());
                        System.out.println("Dung tích xy lanh: " + xe2.getDungTichXYLanh());
                        System.out.println("Tiền thuế trước bạ: " + xe2.tinhThueTruocBa());
                    }

                    if (xe3 != null) {
                        System.out.println("Xe 3:");
                        System.out.println("Giá trị xe: " + xe3.getGiaTriXe());
                        System.out.println("Dung tích xy lanh: " + xe3.getDungTichXYLanh());
                        System.out.println("Tiền thuế trước bạ: " + xe3.tinhThueTruocBa());
                    }

                    break;
                case 3:
                    System.out.println("Kết thúc chương trình");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
            }
        } while (choice != 3);

        scanner.close();
    }
}

/*
Sở giao thông cần theo dõi việc đăng ký xe của người dân.
Dựa vào thông tin trị giá xe và dung tích xylanh của xe,
sở giao thông cũng tính mức thuế phải đóng trước khi mua xe như sau :
- Dưới 100cc , 1% trị giá xe
- Từ 100 đến 200cc 3% giá trị xe
- Trên 200cc , 5% giá trị xe
- Hãy thiết kế và cài đặt class Vehicle với các attributes và methods phù hợp .
Class phải có constructor và phải đảm bảo tính encapsulation
Xây dựng class chứa hàm main. Hàm main in ra menu lựa chọn các công việc :
1. Nhập thông tin và tạo các đối tượng xe1, xe2, xe3
2. Xuất bảng kê khai tiền thuế trước bạ của các xe
3. Thoát
 */