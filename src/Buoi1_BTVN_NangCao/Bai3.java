package Buoi1_BTVN_NangCao;

class SanPham {
    private String ten;
    private double gia;
    static int count = 0;

    public SanPham(String ten, double gia) {
        this.ten = ten;
        this.gia = gia;
        count++; // tăng khi tạo mới
    }

    public void displayInfo() {
        System.out.println("Tên sản phẩm: " + ten);
        System.out.println("Giá: " + gia);
        System.out.println("-------------------------");
    }

    public static void displayCount() {
        System.out.println("Tổng số sản phẩm đã tạo: " + count);
    }
}

public class Bai3 {
    public static void main(String[] args) {
        SanPham sp1 = new SanPham("Áo thun", 150000);
        SanPham sp2 = new SanPham("Quần jeans", 300000);
        SanPham sp3 = new SanPham("Giày sneaker", 500000);

        sp1.displayInfo();
        sp2.displayInfo();
        sp3.displayInfo();

        SanPham.displayCount();
    }
}
