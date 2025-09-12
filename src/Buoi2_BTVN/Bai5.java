package Buoi2_BTVN;

import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số nguyên: ");
        int n = sc.nextInt();

        if (n > 0) {
            System.out.println("Số dương");
        } else if (n < 0) {
            System.out.println("Số âm");
        } else {
            System.out.println("Bằng 0");
        }
    }
}
