package Buoi5_BTVN;

class DongVat {
    public void keu() {
        System.out.println("Động vật đang kêu...");
    }
}

class Cho extends DongVat {
    @Override
    public void keu() {
        System.out.println("Gâu gâu");
    }
}

class Meo extends DongVat {
    @Override
    public void keu() {
        System.out.println("Meo meo");
    }
}

public class Bai4_Polymorphism {
    public static void main(String[] args) {
        DongVat[] dsDongVat = new DongVat[3];
        dsDongVat[0] = new Cho();
        dsDongVat[1] = new Meo();
        dsDongVat[2] = new DongVat();

        for (DongVat dv : dsDongVat) {
            dv.keu();
        }
    }
}
