package Buoi5_BTVN;

class Nguoi {
    String ten;
    int tuoi;

    public void gioiThieu() {
        System.out.println("Tôi tên là " + ten + ", năm nay " + tuoi + " tuổi.");
    }
}

class SinhVien extends Nguoi {
    String maSV;

    public void hocTap() {
        System.out.println("Sinh viên " + ten + " đang học tập.");
    }
}

public class Bai3_Inheritance {
    public static void main(String[] args) {
        SinhVien sv = new SinhVien();
        sv.ten = "Anh";
        sv.tuoi = 20;
        sv.maSV = "SV001";

        sv.gioiThieu();
        sv.hocTap();
    }
}
