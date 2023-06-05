package BAITAP_CLASS.BAI_8;

class CD {
    private int maCD;
    private String tuaCD;
    private String caSy;
    private int soBaiHat;
    private double giaThanh;

    public CD(int maCD, String tuaCD, String caSy, int soBaiHat, double giaThanh) {
        this.maCD = maCD;
        this.tuaCD = tuaCD;
        this.caSy = caSy;
        this.soBaiHat = soBaiHat;
        this.giaThanh = giaThanh;
    }

    public int getMaCD() {
        return maCD;
    }

    public void setMaCD(int maCD) {
        this.maCD = maCD;
    }

    public String getTuaCD() {
        return tuaCD;
    }

    public void setTuaCD(String tuaCD) {
        this.tuaCD = tuaCD;
    }

    public String getCaSy() {
        return caSy;
    }

    public void setCaSy(String caSy) {
        this.caSy = caSy;
    }

    public int getSoBaiHat() {
        return soBaiHat;
    }

    public void setSoBaiHat(int soBaiHat) {
        this.soBaiHat = soBaiHat;
    }

    public double getGiaThanh() {
        return giaThanh;
    }

    public void setGiaThanh(double giaThanh) {
        this.giaThanh = giaThanh;
    }

    @Override
    public String toString() {
        return "CD{" +
                "maCD=" + maCD +
                ", tuaCD='" + tuaCD + '\'' +
                ", caSy='" + caSy + '\'' +
                ", soBaiHat=" + soBaiHat +
                ", giaThanh=" + giaThanh +
                '}';
    }
}

class CDList {
    private CD[] cds;
    private int size;
    private int capacity;

    public CDList(int capacity) {
        this.cds = new CD[capacity];
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean addCD(CD cd) {
        if (size == capacity) {
            return false; // Không thể thêm CD nữa vì danh sách đã đầy
        }

        for (int i = 0; i < size; i++) {
            if (cds[i].getMaCD() == cd.getMaCD()) {
                return false; // Không thể thêm CD vì trùng mã CD
            }
        }

        cds[size++] = cd;
        return true; // Thêm CD thành công
    }

    public int countCDs() {
        return size;
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (int i = 0; i < size; i++) {
            totalCost += cds[i].getGiaThanh();
        }
        return totalCost;
    }

    public void sortByCostDescending() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (cds[i].getGiaThanh() < cds[j].getGiaThanh()) {
                    CD temp = cds[i];
                    cds[i] = cds[j];
                    cds[j] = temp;
                }
            }
        }
    }

    public void sortByTitleAscending() {
        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {
                if (cds[i].getTuaCD().compareTo(cds[j].getTuaCD()) > 0) {
                    CD temp = cds[i];
                    cds[i] = cds[j];
                    cds[j] = temp;
                }
            }
        }
    }

    public void displayCDs() {
        for (int i = 0; i < size; i++) {
            System.out.println(cds[i]);
        }
    }
}

class Main {
    public static void main(String[] args) {
        CDList cdList = new CDList(10);

        // Thêm các CD vào danh sách
        cdList.addCD(new CD(1, "Tua CD 1", "Ca Sy 1", 10, 20.0));
        cdList.addCD(new CD(2, "Tua CD 2", "Ca Sy 2", 12, 18.5));
        cdList.addCD(new CD(3, "Tua CD 3", "Ca Sy 3", 8, 15.0));

        // Số lượng CD và tổng giá thành
        System.out.println("Số lượng CD trong danh sách: " + cdList.countCDs());
        System.out.println("Tổng giá thành của các CD: " + cdList.calculateTotalCost());

        // Sắp xếp danh sách giảm dần theo giá thành và xuất danh sách
        cdList.sortByCostDescending();
        System.out.println("Danh sách CD sắp xếp giảm dần theo giá thành:");
        cdList.displayCDs();

        // Sắp xếp danh sách tăng dần theo tựa CD và xuất danh sách
        cdList.sortByTitleAscending();
        System.out.println("Danh sách CD sắp xếp tăng dần theo tựa CD:");
        cdList.displayCDs();
    }
}

/*
a.Viết chương trình xây dựng đối tượng CD gồm có các thuộc tính sau :
- Mã CD là số nguyên
- Tựa CD : chuỗi ký tự
- Ca sỹ : chuỗi ký tự
- Số bài hát : số nguyên ( > 0 )
- Giá thành : số thực ( > 0 )
- Các thuộc tính khai báo private , định nghĩa các phương thức get/set cho từng thuộc tính
- Viết các constructor để khởi tạo đối tượng CD
- Override phương thức toString của lớp Object
b. Xây dựng lớp lưu danh sách các CD
- Phương thức thêm 1 CD vào danh sách, thêm thành công nếu trùng mã CD và kích thước mảng còn cho phép
- Tính số lượng CD có trong danh sách
- Tính tổng giá thành của các CD
- Phương thức sắp xếp danh sách giảm dần theo giá thành
- Phương thức sắp xếp tăng dần theo tựa CD
- Phương thức xuất toàn bộ danh sách
c. Viết lớp cho phần kiểm nghiệm
- Dùng menu case thực hiện các chức năng theo yêu cầu
 */