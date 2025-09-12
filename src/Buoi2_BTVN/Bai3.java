package Buoi2_BTVN;

import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm (0-100): ");
        int score = sc.nextInt();

        if (score >= 50) {
            System.out.println("Qua môn");
        } else {
            System.out.println("Trượt");
        }
    }
}
