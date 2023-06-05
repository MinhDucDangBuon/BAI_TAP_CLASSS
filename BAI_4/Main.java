package BAITAP_CLASS.BAI_4;
import java.util.Scanner;
class Account {
    private static final double INTEREST_RATE = 0.035;

    private long accountNumber;
    private String accountName;
    private double balance;

    public Account() {
        // Constructor mặc định
    }

    public Account(long accountNumber, String accountName) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = 50;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {    //Phương thức nạp tiền
        if (amount > 0) {
            balance += amount;
        }
    }

    public void withdraw(double amount, double withdrawalFee) {     //Phương thức rút tiền
        if (amount > 0 && amount + withdrawalFee <= balance) {
            balance -= (amount + withdrawalFee);
        }
    }

    public void mature() {  //Phương thức đáo hạn
        balance += balance * INTEREST_RATE;
    }

    public void transfer(Account destinationAccount, double amount) { //Phương thức chuyển khoản
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            destinationAccount.deposit(amount);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số tài khoản và tên tài khoản
        System.out.print("Nhập số tài khoản: ");
        long accountNumber = scanner.nextLong();
        scanner.nextLine(); // Đọc dòng mới sau khi đọc số tài khoản
        System.out.print("Nhập tên tài khoản: ");
        String accountName = scanner.nextLine();

        // Tạo một tài khoản mới
        Account account = new Account(accountNumber, accountName);

        // Hiển thị thông tin tài khoản ban đầu
        System.out.println("Thông tin tài khoản:");
        System.out.println("Số tài khoản: " + account.getAccountNumber());
        System.out.println("Tên tài khoản: " + account.getAccountName());
        System.out.println("Số tiền trong tài khoản: " + account.getBalance());

        // Nhập số tiền nạp vào tài khoản
        System.out.print("Nhập số tiền muốn nạp: ");
        double depositAmount = scanner.nextDouble();
        account.deposit(depositAmount);
        System.out.println("Số tiền sau khi nạp: " + account.getBalance());

        // Nhập số tiền muốn rút và phí rút
        System.out.print("Nhập số tiền muốn rút: ");
        double withdrawAmount = scanner.nextDouble();
        System.out.print("Nhập phí rút tiền: ");
        double withdrawalFee = scanner.nextDouble();
        account.withdraw(withdrawAmount, withdrawalFee);
        System.out.println("Số tiền sau khi rút: " + account.getBalance());

        // Đáo hạn tài khoản
        account.mature();
        System.out.println("Số tiền sau khi đáo hạn: " + account.getBalance());

        // Tạo một tài khoản khác
        System.out.print("Nhập số tài khoản của tài khoản đích: ");
        long destinationAccountNumber = scanner.nextLong();
        scanner.nextLine(); // Đọc dòng mới sau khi đọc số tài khoản đích
        System.out.print("Nhập tên tài khoản của tài khoản đích: ");
        String destinationAccountName = scanner.nextLine();
        Account anotherAccount = new Account(destinationAccountNumber, destinationAccountName);

        // Chuyển khoản từ tài khoản này sang tài khoản khác
        System.out.print("Nhập số tiền muốn chuyển: ");
        double transferAmount = scanner.nextDouble();
        account.transfer(anotherAccount, transferAmount);
        System.out.println("Số tiền trong tài khoản sau khi chuyển khoản:");
        System.out.println("Tài khoản " + account.getAccountNumber() + ": " + account.getBalance());
        System.out.println("Tài khoản " + anotherAccount.getAccountNumber() + ": " + anotherAccount.getBalance());

        scanner.close();
    }
}

/*
Ngân hàng ABC muốn lưu trữ thông tin của mỗi tài khoản như sau :
Mỗi tài khoản chứa các thông tin :
+ Số tài khoản ( Kiểu long )
+ Tên tài khoản ( kiểu chuỗi )
+ Số tiền trong tài khoản ( kiểu double )
a) Thiết kế lớp Accout để lưu trữ các thông tin, lớp bao gồm các phương thức sau :
- Constructor : Có 2 constructor ( mặc định và đầy đủ tham số )
- Các phương thức getters và setters
b) Thêm các thông tin sau vào lớp Accout
- Hàng số lãi suất có giá trị khởi tạo 0,035
- Constructor có 2 đối số : số tài khoản, tên tài khoản . Constructor này sẽ khởi tạo số tiền mặc định là 50
- Phương thức nạp tiền vào tài khoảnn  : Lấy số tiền hiện tại trong tài khoản + số tiền nạp vào
- Phương thức rút tiền : Lấy số tiền hiện tại trong tài khoản - ( số tiền muốn rút + phí rút tiền )
- Phương thức đáo hạn : Mỗi lần đến kỳ đáo hạn thì số tiền trong tài khoản = số tiền trong tài khoản
+ số tiền trong tài khoản * LAISUAT
- Phương thức chuyển khoản từ tài khoản này sang tài khoản khác
- Chú ý : Mỗi thao tác này phải kiểm tra số tiền nạp, rút , chuyển có hợp lệ hay không ?
 */
