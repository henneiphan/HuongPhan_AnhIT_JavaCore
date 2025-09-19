package Buoi5_BTVN;

class HocSinh {
    String ten;
    int tuoi;
    String lop;

    void hocBai() {
        System.out.println(ten + " đang học bài");
    }
}

public class Bai1_ClassCoBan {
    public static void main(String[] args) {
        HocSinh hs1 = new HocSinh();
        hs1.ten = "Hoà";
        hs1.tuoi = 16;
        hs1.lop = "10T1";

        HocSinh hs2 = new HocSinh();
        hs2.ten = "Bình";
        hs2.tuoi = 17;
        hs2.lop = "11T2";

        hs1.hocBai();
        hs2.hocBai();
    }
}
