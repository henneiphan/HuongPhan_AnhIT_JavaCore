package Buoi3_BTVN;

public class Bai8 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};

        int sumEven = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                sumEven += num;
            }
        }

        System.out.println("Tổng các số chẵn trong mảng là: " + sumEven);
    }
}

