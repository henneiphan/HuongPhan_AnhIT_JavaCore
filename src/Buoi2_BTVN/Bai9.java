package Buoi2_BTVN;

import java.util.Scanner;

public class Bai9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        double a = sc.nextDouble();
        System.out.print("Nhập số thứ hai: ");
        double b = sc.nextDouble();
        System.out.print("Nhập toán tử (+, -, *, /): ");
        char op = sc.next().charAt(0);

        switch (op) {
            case '+':
                System.out.println("Kết quả: " + (a + b));
                break;
            case '-':
                System.out.println("Kết quả: " + (a - b));
                break;
            case '*':
                System.out.println("Kết quả: " + (a * b));
                break;
            case '/':
                if (b != 0) {
                    System.out.println("Kết quả: " + (a / b));
                } else {
                    System.out.println("Lỗi: chia cho 0");
                }
                break;
            default:
                System.out.println("Toán tử không hợp lệ");
        }
    }
}

