package Buoi1_BTVN_NangCao;

class BankAccount {
    private String soTaiKhoan;
    private double soDu;
    static double laiSuat = 0.05; // 5% mặc định

    public BankAccount(String soTaiKhoan, double soDu) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDu;
    }

    public double tinhTienLai() {
        double tienLai = soDu * laiSuat; // biến local
        return tienLai;
    }

    public void displayInfo() {
        System.out.println("Số tài khoản: " + soTaiKhoan);
        System.out.println("Số dư: " + soDu);
        System.out.println("Tiền lãi: " + tinhTienLai());
        System.out.println("-------------------------");
    }
}

public class Bai1 {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("111111", 1000000);
        BankAccount acc2 = new BankAccount("222222", 2000000);

        acc1.displayInfo();
        acc2.displayInfo();
    }
}

