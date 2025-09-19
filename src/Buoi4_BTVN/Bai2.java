package Buoi4_BTVN;

// Tính tổng mảng
public class Bai2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        System.out.print("Tổng các phần tử trong mảng: " + sum);
    }
}
