package Buoi5_BTVN;

class TaiKhoanNganHang {
    private final String soTaiKhoan;
    private double soDu;

    public TaiKhoanNganHang(String soTaiKhoan, double soDuBanDau) {
        this.soTaiKhoan = soTaiKhoan;
        this.soDu = soDuBanDau;
    }

    public String getSoTaiKhoan() {
        return soTaiKhoan;
    }

    public void napTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Đã nạp " + soTien + " vào tài khoản.");
        } else {
            System.out.println("Số tiền nạp không hợp lệ.");
        }
    }

    public void rutTien(double soTien) {
        if (soTien > 0 && soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Đã rút " + soTien + " khỏi tài khoản.");
        } else {
            System.out.println("Số tiền rút không hợp lệ hoặc vượt quá số dư.");
        }
    }

    public void xemSoDu() {
        System.out.println("Số dư hiện tại: " + soDu);
    }
}

public class Bai2_Encapsulation {
    public static void main(String[] args) {
        TaiKhoanNganHang tk = new TaiKhoanNganHang("123456789", 1000);

        System.out.println("Số tài khoản: " + tk.getSoTaiKhoan());
        tk.xemSoDu();
        tk.napTien(500);
        tk.rutTien(300);
        tk.xemSoDu();
    }
}
