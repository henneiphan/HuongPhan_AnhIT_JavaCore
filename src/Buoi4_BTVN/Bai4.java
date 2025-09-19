package Buoi4_BTVN;

public class Bai4 {
    public static void main(String[] args) {
        int[] arr = {2, 5, 7, 8, 10, 13};

        int countEven = 0, countOdd = 0;

        for (int num : arr) {
            if (num % 2 == 0) {
                countEven++;
            } else {
                countOdd++;
            }
        }

        System.out.println("Số chẵn: " + countEven);
        System.out.println("Số lẻ: " + countOdd);
    }
}
