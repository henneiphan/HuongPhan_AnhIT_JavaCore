package Buoi2_BTVN;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();

        if (age >= 18) {
            System.out.println("Đủ điều kiện lái xe");
        } else {
            System.out.println("Chưa đủ điều kiện");
        }
    }
}
