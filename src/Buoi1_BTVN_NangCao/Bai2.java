package Buoi1_BTVN_NangCao;

class HocSinh {
    private String ten;
    private int tuoi;
    private double gpa;
    static String truong = "Đại học ABC";

    public HocSinh(String ten, int tuoi, double gpa) {
        this.ten = ten;
        this.tuoi = tuoi;
        this.gpa = gpa;
    }

    public void displayInfo() {
        String rank; // biến local
        if (gpa >= 8.0) {
            rank = "Giỏi";
        } else if (gpa >= 6.5) {
            rank = "Khá";
        } else {
            rank = "Trung bình";
        }

        System.out.println("Tên: " + ten);
        System.out.println("Tuổi: " + tuoi);
        System.out.println("GPA: " + gpa);
        System.out.println("Xếp loại: " + rank);
        System.out.println("Trường: " + truong);
        System.out.println("-------------------------");
    }
}

public class Bai2 {
    public static void main(String[] args) {
        HocSinh sv1 = new HocSinh("Nguyễn An", 30, 8.5);
        HocSinh sv2 = new HocSinh("Phan Bình", 31, 7.0);

        sv1.displayInfo();
        sv2.displayInfo();
    }
}
