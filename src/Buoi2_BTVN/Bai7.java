package Buoi2_BTVN;

import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tuổi: ");
        int age = sc.nextInt();

        if (age < 12) {
            System.out.println("Giá vé: 20.000đ");
        } else if (age <= 17) {
            System.out.println("Giá vé: 40.000đ");
        } else {
            System.out.println("Giá vé: 60.000đ");
        }
    }
}
