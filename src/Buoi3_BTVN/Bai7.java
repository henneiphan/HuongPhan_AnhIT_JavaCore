package Buoi3_BTVN;

public class Bai7 {
    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 9, 5};

        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Số lớn nhất trong mảng là: " + max);
    }
}

