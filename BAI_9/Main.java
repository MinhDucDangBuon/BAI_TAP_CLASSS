package BAITAP_CLASS.BAI_9;
import java.util.Scanner;

// Lớp cha ChuyenXe
abstract class ChuyenXe {
    protected int maSoChuyen;
    protected String hoTenTaiXe;
    protected String soXe;
    protected double doanhThu;

    public ChuyenXe(int maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu) {
        this.maSoChuyen = maSoChuyen;
        this.hoTenTaiXe = hoTenTaiXe;
        this.soXe = soXe;
        this.doanhThu = doanhThu;
    }

    public abstract String loaiChuyenXe();

    public void xuatThongTin() {
        System.out.println("Loai chuyen xe: " + loaiChuyenXe());
        System.out.println("Ma so chuyen: " + maSoChuyen);
        System.out.println("Ho ten tai xe: " + hoTenTaiXe);
        System.out.println("So xe: " + soXe);
        System.out.println("Doanh thu: " + doanhThu);
    }
}

// Lớp ChuyenXeNoiThanh kế thừa từ ChuyenXe
class ChuyenXeNoiThanh extends ChuyenXe {
    private int soTuyen;
    private int soKmDiDuoc;

    public ChuyenXeNoiThanh(int maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, int soTuyen, int soKmDiDuoc) {
        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
        this.soTuyen = soTuyen;
        this.soKmDiDuoc = soKmDiDuoc;
    }

    public String loaiChuyenXe() {
        return "Chuyen xe noi thanh";
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("So tuyen: " + soTuyen);
        System.out.println("So km di duoc: " + soKmDiDuoc);
    }
}

// Lớp ChuyenXeNgoaiThanh kế thừa từ ChuyenXe
class ChuyenXeNgoaiThanh extends ChuyenXe {
    private String noiDen;
    private int soNgayDiDuoc;

    public ChuyenXeNgoaiThanh(int maSoChuyen, String hoTenTaiXe, String soXe, double doanhThu, String noiDen, int soNgayDiDuoc) {
        super(maSoChuyen, hoTenTaiXe, soXe, doanhThu);
        this.noiDen = noiDen;
        this.soNgayDiDuoc = soNgayDiDuoc;
    }

    public String loaiChuyenXe() {
        return "Chuyen xe ngoai thanh";
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("Noi den: " + noiDen);
        System.out.println("So ngay di duoc: " + soNgayDiDuoc);
    }
}

// Lớp QuanLyChuyenXe để quản lý danh sách các chuyến xe
class QuanLyChuyenXe {
    private ChuyenXe[] danhSachChuyenXe;
    private int soLuongChuyenXe;
    private final int MAX_CHUYEN_XE = 100;

    public QuanLyChuyenXe() {
        danhSachChuyenXe = new ChuyenXe[MAX_CHUYEN_XE];
        soLuongChuyenXe = 0;
    }

    public void themChuyenXe(ChuyenXe chuyenXe) {
        if (soLuongChuyenXe < MAX_CHUYEN_XE) {
            danhSachChuyenXe[soLuongChuyenXe] = chuyenXe;
            soLuongChuyenXe++;
            System.out.println("Da them chuyen xe thanh cong!");
        } else {
            System.out.println("Danh sach chuyen xe da day, khong the them!");
        }
    }

    public int tinhTongDoanhThu() {
        int tongDoanhThu = 0;
        for (int i = 0; i < soLuongChuyenXe; i++) {
            tongDoanhThu += danhSachChuyenXe[i].doanhThu;
        }
        return tongDoanhThu;
    }

    public void xuatDanhSachChuyenXe() {
        if (soLuongChuyenXe == 0) {
            System.out.println("Danh sach chuyen xe rong!");
        } else {
            System.out.println("Danh sach chuyen xe:");
            for (int i = 0; i < soLuongChuyenXe; i++) {
                danhSachChuyenXe[i].xuatThongTin();
                System.out.println("--------------------");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QuanLyChuyenXe quanLyChuyenXe = new QuanLyChuyenXe();

        while (true) {
            System.out.println("1. Them chuyen xe noi thanh");
            System.out.println("2. Them chuyen xe ngoai thanh");
            System.out.println("3. Tinh tong doanh thu");
            System.out.println("4. Xuat danh sach chuyen xe");
            System.out.println("0. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng new line

            switch (choice) {
                case 1:
                    System.out.print("Nhap ma so chuyen: ");
                    int maSoChuyenNoiThanh = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng new line
                    System.out.print("Nhap ho ten tai xe: ");
                    String hoTenTaiXeNoiThanh = scanner.nextLine();
                    System.out.print("Nhap so xe: ");
                    String soXeNoiThanh = scanner.nextLine();
                    System.out.print("Nhap doanh thu: ");
                    double doanhThuNoiThanh = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng new line
                    System.out.print("Nhap so tuyen: ");
                    int soTuyen = scanner.nextInt();
                    System.out.print("Nhap so km di duoc: ");
                    int soKmDiDuoc = scanner.nextInt();
                    ChuyenXeNoiThanh chuyenXeNoiThanh = new ChuyenXeNoiThanh(maSoChuyenNoiThanh, hoTenTaiXeNoiThanh, soXeNoiThanh, doanhThuNoiThanh, soTuyen, soKmDiDuoc);
                    quanLyChuyenXe.themChuyenXe(chuyenXeNoiThanh);
                    break;
                case 2:
                    System.out.print("Nhap ma so chuyen: ");
                    int maSoChuyenNgoaiThanh = scanner.nextInt();
                    scanner.nextLine(); // Đọc bỏ dòng new line
                    System.out.print("Nhap ho ten tai xe: ");
                    String hoTenTaiXeNgoaiThanh = scanner.nextLine();
                    System.out.print("Nhap so xe: ");
                    String soXeNgoaiThanh = scanner.nextLine();
                    System.out.print("Nhap doanh thu: ");
                    double doanhThuNgoaiThanh = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ dòng new line
                    System.out.print("Nhap noi den: ");
                    String noiDen = scanner.nextLine();
                    System.out.print("Nhap so ngay di duoc: ");
                    int soNgayDiDuoc = scanner.nextInt();
                    ChuyenXeNgoaiThanh chuyenXeNgoaiThanh = new ChuyenXeNgoaiThanh(maSoChuyenNgoaiThanh, hoTenTaiXeNgoaiThanh, soXeNgoaiThanh, doanhThuNgoaiThanh, noiDen, soNgayDiDuoc);
                    quanLyChuyenXe.themChuyenXe(chuyenXeNgoaiThanh);
                    break;
                case 3:
                    int tongDoanhThu = quanLyChuyenXe.tinhTongDoanhThu();
                    System.out.println("Tong doanh thu: " + tongDoanhThu);
                    break;
                case 4:
                    quanLyChuyenXe.xuatDanhSachChuyenXe();
                    break;
                case 0:
                    System.out.println("Thoat chuong trinh");
                    return;
                default:
                    System.out.println("Lua chon khong hop le");
            }
        }
    }
}



/*
Công ty du lịch V quản lý thông tin là các chuyến xe. Thông tin của 2 loại chuyến xe :
- Chuyến xe nội thành : Mã số chuyến, họ tên tài xế, số xe, số tuyến, số km đi được, doanh thu
- Chuyến xe ngoại thành : Mã số chuyến, họ tên tài xế, số xe, nơi đến, số ngày đi được, doanh thu. Thực hiện các yêu cầu sau :
- Xây dựng các lớp với chức năng thừa kế
- Viết chương trình quản lý các chuyến xe theo dạng cây thừa kế với các phương thức sau :
- Nhập , xuất danh sách các chuyến xe ( danh sách có thể dùng cấu trúc mảng )
- Tính tổng doanh thu cho từng loại xe
 */