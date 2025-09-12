package Buoi2_BTVN;

import java.util.Scanner;

public class Bai6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Menu:");
        System.out.println("1. Cà phê");
        System.out.println("2. Trà sữa");
        System.out.println("3. Nước lọc");
        System.out.print("Chọn số: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Cà phê");
                break;
            case 2:
                System.out.println("Trà sữa");
                break;
            case 3:
                System.out.println("Nước lọc");
                break;
            default:
                System.out.println("Không có trong menu");
        }
    }
}
