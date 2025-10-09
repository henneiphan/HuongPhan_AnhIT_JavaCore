package ASMJava;

import java.util.Scanner;

public class InputHelper {
    private static final Scanner sc = new Scanner(System.in);

    public static String inputRequired(String message) {
        String input;
        while (true) {
            System.out.print(message);
            input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("⚠️ Vui lòng nhập giá trị!");
        }
    }

    public static int inputInt(String message) {
        while (true) {
            try {
                String input = inputRequired(message);
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Vui lòng nhập số nguyên hợp lệ!");
            }
        }
    }

    public static double inputDouble(String message) {
        while (true) {
            try {
                String input = inputRequired(message);
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Vui lòng nhập số hợp lệ!");
            }
        }
    }

    public static int inputYear(String message) {
        while (true) {
            int year = inputInt(message);
            int currentYear = java.time.Year.now().getValue();
            if (year >= 1900 && year <= currentYear) {
                return year;
            }
            System.out.println("⚠️ Năm sản xuất phải từ 1900 đến " + currentYear);
        }
    }

    public static double inputPositiveDouble(String message) {
        while (true) {
            double value = inputDouble(message);
            if (value > 0) {
                return value;
            }
            System.out.println("⚠️ Giá trị phải lớn hơn 0!");
        }
    }

    public static int inputPositiveInt(String message) {
        while (true) {
            int value = inputInt(message);
            if (value > 0) {
                return value;
            }
            System.out.println("⚠️ Giá trị phải lớn hơn 0!");
        }
    }
}


