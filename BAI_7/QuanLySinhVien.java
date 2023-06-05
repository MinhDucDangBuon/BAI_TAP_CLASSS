package BAITAP_CLASS.BAI_7;

import java.util.*;

class SinhVien implements Comparable<SinhVien> {
    private int maSV;
    private String hoTen;
    private String diaChi;
    private String soDienThoai;

    public SinhVien() {
    }

    public SinhVien(int maSV, String hoTen, String diaChi, String soDienThoai) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
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

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        if (soDienThoai.matches("\\d{7}")) {
            this.soDienThoai = soDienThoai;
        } else {
            this.soDienThoai = "Không xác định";
        }
    }


    @Override
    public String toString() {
        return "Mã sinh viên: " + maSV +
                "\nHọ tên: " + hoTen +
                "\nĐịa chỉ: " + diaChi +
                "\nSố điện thoại: " + soDienThoai + "\n";
    }

    @Override
    public int compareTo(SinhVien sv) {
        return Integer.compare(this.maSV, sv.maSV);
    }
}

public class QuanLySinhVien {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng sinh viên: ");
        int n = scanner.nextInt();

        List<SinhVien> danhSachSinhVien = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sinh viên thứ " + (i + 1) + ":");
            SinhVien sinhVien = new SinhVien();

            System.out.print("Mã sinh viên: ");
            int maSV = scanner.nextInt();
            sinhVien.setMaSV(maSV);

            scanner.nextLine(); // Đọc bỏ dòng new line

            System.out.print("Họ tên: ");
            String hoTen = scanner.nextLine();
            sinhVien.setHoTen(hoTen);

            System.out.print("Địa chỉ: ");
            String diaChi = scanner.nextLine();
            sinhVien.setDiaChi(diaChi);

            System.out.print("Số điện thoại: ");
            String soDienThoai = scanner.nextLine();
            sinhVien.setSoDienThoai(soDienThoai);

            danhSachSinhVien.add(sinhVien);
        }

        Collections.sort(danhSachSinhVien);

        System.out.println("Danh sách sinh viên theo thứ tự tăng dần của mã sinh viên:");
        for (SinhVien sinhVien : danhSachSinhVien) {
            System.out.println(sinhVien.toString());
        }

        scanner.close();
    }
}

/*
Viết chương trình xây dựng đối tượng Sinh viên gồm có các thuộc tính sau :
- Mã sinh viên là số nguyên
- Họ tên : Chuỗi ký tự
- Địa chỉ : Chuỗi ký tự
- Số điện thoại : là số bao gồm 7 chữ số
- Các thuộc tính khai báo private , định nghĩa các phương thức get/set cho từng thuộc tính
-Viết các constructor để khởi tạo đối tượng ( constructor mặc định , constructor có tham số )
- Override phương thức toString của lớp Object
Xây dựng lớp cho phép nhập vào N sinh viên . Xuất danh sách ra màn hình theo thứ tự tăng dần của mã sinh viên
 */