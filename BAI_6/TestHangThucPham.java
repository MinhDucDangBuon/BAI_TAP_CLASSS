package BAITAP_CLASS.BAI_6;

import java.util.Scanner;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

class HangThucPham {
    private final String maHang;
    private String tenHang;
    private double donGia;
    private Date ngaySanXuat;
    private Date ngayHetHan;

    // Constructor với đầy đủ tham số
    public HangThucPham(String maHang, String tenHang, double donGia, String ngaySanXuat, String ngayHetHan) {
        this.maHang = validateMaHang(maHang);
        this.tenHang = validateTenHang(tenHang);
        this.donGia = validateDonGia(donGia);
        this.ngaySanXuat = validateNgaySanXuat(ngaySanXuat);
        this.ngayHetHan = validateNgayHetHan(ngayHetHan, this.ngaySanXuat);
    }

    // Constructor với tham số là mã hàng
    public HangThucPham(String maHang) {
        this.maHang = validateMaHang(maHang);
    }

    public String getMaHang() {
        return maHang;
    }

    public String getTenHang() {
        return tenHang;
    }

    public void setTenHang(String tenHang) {
        this.tenHang = validateTenHang(tenHang);
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = validateDonGia(donGia);
    }

    public String getNgaySanXuat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(ngaySanXuat);
    }

    public void setNgaySanXuat(String ngaySanXuat) {
        this.ngaySanXuat = validateNgaySanXuat(ngaySanXuat);
        if (this.ngayHetHan != null && this.ngaySanXuat != null) {
            this.ngayHetHan = validateNgayHetHan(getNgayHetHan(), this.ngaySanXuat);
        }
    }

    public String getNgayHetHan() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(ngayHetHan);
    }

    public void setNgayHetHan(String ngayHetHan) {
        this.ngayHetHan = validateNgayHetHan(ngayHetHan, this.ngaySanXuat);
    }

    public boolean daHetHan() {
        Date currentDate = new Date();
        return ngayHetHan.before(currentDate);
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return "Mã hàng: " + maHang +
                "\nTên hàng: " + tenHang +
                "\nĐơn giá: " + decimalFormat.format(donGia) +
                "\nNgày sản xuất: " + dateFormat.format(ngaySanXuat) +
                "\nNgày hết hạn: " + dateFormat.format(ngayHetHan);
    }

    private String validateMaHang(String maHang) {
        if (maHang != null && !maHang.isEmpty()) {
            return maHang;
        } else {
            return "Mã hàng không xác định";
        }
    }

    private String validateTenHang(String tenHang) {
        if (tenHang != null && !tenHang.isEmpty()) {
            return tenHang;
        } else {
            return "Tên hàng không xác định";
        }
    }

    private double validateDonGia(double donGia) {
        if (donGia > 0) {
            return donGia;
        } else {
            return 0;
        }
    }

    private Date validateNgaySanXuat(String ngaySanXuat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return dateFormat.parse(ngaySanXuat);
        } catch (ParseException e) {
            return null;
        }
    }

    private Date validateNgayHetHan(String ngayHetHan, Date ngaySanXuat) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date ngayHetHanDate = dateFormat.parse(ngayHetHan);
            if (ngaySanXuat != null && ngayHetHanDate.after(ngaySanXuat)) {
                return ngayHetHanDate;
            }
        } catch (ParseException e) {
            return null;
        }
        return null;
    }
}

public class TestHangThucPham {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập mã hàng: ");
        String maHang = scanner.nextLine();

        System.out.print("Nhập tên hàng: ");
        String tenHang = scanner.nextLine();

        System.out.print("Nhập đơn giá: ");
        double donGia = scanner.nextDouble();

        System.out.print("Nhập ngày sản xuất (dd/MM/yyyy): ");
        String ngaySanXuat = scanner.next();

        System.out.print("Nhập ngày hết hạn (dd/MM/yyyy): ");
        String ngayHetHan = scanner.next();

        HangThucPham hangThucPham = new HangThucPham(maHang, tenHang, donGia, ngaySanXuat, ngayHetHan);
        System.out.println(hangThucPham.toString());
        System.out.println("Hàng đã hết hạn: " + (hangThucPham.daHetHan() ? "Có" : "Không"));

        scanner.close();
    }
}
/*
Viết lớp HangThucPham mô tả một hàng hoá là hàng thực phẩm trong kho của một siêu thị , có các thuộc tính : mã hàng ( không cho phép sửa, không được để rỗng ), tên hàng ( không được để rỗng ), đơn giá ( >0 ) , ngày sản xuất và ngày hết hạn ( ngày không được để rỗng, ngày hết hạn phải sau ngày sản xuất ). Ràng buộc chặt chẽ các ràng buộc trên các trường dữ liệu. Nếu dữ liệu không hợp lệ thì gán giá trị mặc định cho phép tương ứng của trường đó.
- Tạo 1 constructor có đầy đủ tham số , 1 constructor có tham số là mã hàng
- Setter và getter
- Viết phương thức kiểm tra một hàng thực phẩm đã hết hạn chưa ?
- Phương thức toString , trả về chuỗi chữa thông tin của hàng thực phẩm.
Trong đó : Định dạng đơn giá có phân cách hàng nghìn. Định dạng kiểu ngày là dd/MM/yyyy .
- Viết lớp cho phần kiểm nghiệm
 */