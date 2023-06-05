package BAITAP_CLASS.BAI_2;

import java.util.Scanner;

import java.util.Scanner;

class SinhVien {
    private int maSV;
    private String hoTen;
    private float diemLT;
    private float diemTH;

    public SinhVien() {
        this.maSV = 0;
        this.hoTen = "";
        this.diemLT = 0.0f;
        this.diemTH = 0.0f;
    }

    public SinhVien(int maSV, String hoTen, float diemLT, float diemTH) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diemLT = diemLT;
        this.diemTH = diemTH;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getDiemLT() {
        return diemLT;
    }

    public void setDiemLT(float diemLT) {
        if (diemLT >= 0) {
            this.diemLT = diemLT;
        } else {
            System.out.println("Điểm LT không hợp lệ!");
        }
    }

    public float getDiemTH() {
        return diemTH;
    }

    public void setDiemTH(float diemTH) {
        if (diemTH >= 0) {
            this.diemTH = diemTH;
        } else {
            System.out.println("Điểm TH không hợp lệ!");
        }
    }

    public float tinhDiemTrungBinh() {
        return (diemLT + diemTH) / 2;
    }

    public String toString() {
        return "MSSV: " + maSV +
                ", Họ tên: " + hoTen +
                ", Điểm LT: " + diemLT +
                ", Điểm TH: " + diemTH +
                ", Điểm TB: " + tinhDiemTrungBinh();
    }
}

public class QuanLySinhVien {
    public static void main(String[] args) {
        SinhVien sv1 = new SinhVien(123, "Nguyen Van A", 8.5f, 7.5f);
        SinhVien sv2 = new SinhVien(456, "Tran Thi B", 9.0f, 8.0f);
        SinhVien sv3 = new SinhVien();

        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập MSSV của sv3: ");
        int maSV = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ ký tự new line sau khi đọc số nguyên

        System.out.print("Nhập họ tên của sv3: ");
        String hoTen = scanner.nextLine();

        System.out.print("Nhập điểm LT của sv3: ");
        float diemLT = scanner.nextFloat();
        sv3.setDiemLT(diemLT);

        System.out.print("Nhập điểm TH của sv3: ");
        float diemTH = scanner.nextFloat();
        sv3.setDiemTH(diemTH);

        sv3.setMaSV(maSV);
        sv3.setHoTen(hoTen);

        System.out.println("Danh sách sinh viên:");
        System.out.println(sv1.toString());
        System.out.println(sv2.toString());
        System.out.println(sv3.toString());

        scanner.close();
    }
}
/*
Viết chương trình OOP quản lý sinh viên đơn giản  : Nhập , xuất thông tin , tính điểm trung bình :
 - Viết lớp Sinh Viên như sau : Attributes ( private ):
- Mã sinh viên là số nguyên.
- Họ tên : chuỗi ký tự
- Điểm LT , điểm TH : float
Constructor : Constructor mặc định( để khởi tạo đối tượng với các thông tin kiểu số lầ 0, kiểu chuỗi là rỗng )
Constructor thứ hai nhận đầy đủ thông tin để khởi tạo giá trị cho tất cả các biến instance.
Methods :
Getters và setters
- Tính điểm trung bình
- Phương thức toString để diễn tả đối tượng ở dạng chuỗi
- Xây dựng class chứa hàm main : tạo 3 đối tượng sinh viên, sv1, sv2, sv3, trong đó :
sv1 chứa thông tin của chính mình ( tạo bằng constructor đủ thông số, thông tin biết rồi thì khỏi nhập từ bàn phím)
sv2 là thông tin người bạn thân nhất của em ( tạo bằng constructor đủ thông số, thông tin biết rồi khỏi nhậpb từ bàn phím )
sv3 tạo bằng constructor mặc định. Nhập thông tin cho sv3 từ bàn phím rồi sau đó dùng các setter để gán vào cho
 các thuộc tính tương ứng.
-  In bảng danh sách sinh viên gồm 4 cột là MSSV , họ tên, điểm LT, điểm TH, điểm TB ( bảng có 3 dòng cho 3 sinh viên )
 */