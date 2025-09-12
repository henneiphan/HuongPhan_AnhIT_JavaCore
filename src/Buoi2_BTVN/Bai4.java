package Buoi2_BTVN;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm (0-100): ");
        int score = sc.nextInt();

        if (score >= 85) {
            System.out.println("Giỏi");
        } else if (score >= 65) {
            System.out.println("Khá");
        } else if (score >= 50) {
            System.out.println("Trung bình");
        } else {
            System.out.println("Yếu");
        }
    }
}
