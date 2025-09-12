package Buoi2_BTVN;

import java.util.Scanner;

public class Bai8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tháng (1-12): ");
        int month = sc.nextInt();

        switch (month) {
            case 3: case 4: case 5:
                System.out.println("Mùa Xuân");
                break;
            case 6: case 7: case 8:
                System.out.println("Mùa Hạ");
                break;
            case 9: case 10: case 11:
                System.out.println("Mùa Thu");
                break;
            case 12: case 1: case 2:
                System.out.println("Mùa Đông");
                break;
            default:
                System.out.println("Tháng không hợp lệ");
        }
    }
}

