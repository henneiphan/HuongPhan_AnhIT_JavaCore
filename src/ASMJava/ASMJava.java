package ASMJava;

import java.util.*;
import java.io.*;

import static ASMJava.InputHelper.*;

// ================= Vehicle (Parent) =================
abstract class Vehicle {
    private static int idCounter = 1;
    private static int vehicleCount = 0;

    private final int id;
    private String brand;
    private String model;
    private int year;
    private double price;
    private String color;
    private String type;

    // Constructor không tham số
    public Vehicle() {
        this.id = idCounter++;
        vehicleCount++;
    }

    // Constructor đầy đủ tham số (Constructor overloading)
    public Vehicle(String brand, String model, int year, double price, String color, String type) {
        this.id = idCounter++;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.type = type;
        vehicleCount++;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }
    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    // Static biến đếm tổng số xe
    public static int getVehicleCount() { return vehicleCount; }

    // Method applyDiscount() được override trong Car và Truck
    public abstract void applyDiscount();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Brand: " + brand +
                ", Model: " + model +
                ", Year: " + year +
                ", Price: " + String.format("%.2f", price) +
                ", Color: " + color +
                ", Type: " + type;
    }
}

// ================= Car (Subclass) =================
class Car extends Vehicle {
    private int seatCount; // Thêm thuộc tính seatCount

    public Car(String brand, String model, int year, double price, String color, int seatCount) {
        super(brand, model, year, price, color, "Car");
        this.seatCount = seatCount;
    }

    // Getter và Setter cho seatCount
    public int getSeatCount() { return seatCount; }
    public void setSeatCount(int seatCount) { this.seatCount = seatCount; }

    // Override phương thức applyDiscount() → giảm giá 15%
    @Override
    public void applyDiscount() {
        setPrice(getPrice() * 0.85); // giảm 15%
    }

    @Override
    public String toString() {
        return super.toString() + ", SeatCount: " + seatCount;
    }
}

// ================= Truck (Subclass) =================
class Truck extends Vehicle {
    private double loadCapacity; // Thêm thuộc tính loadCapacity

    public Truck(String brand, String model, int year, double price, String color, double loadCapacity) {
        super(brand, model, year, price, color, "Truck");
        this.loadCapacity = loadCapacity;
    }

    // Getter và Setter cho loadCapacity
    public double getLoadCapacity() { return loadCapacity; }
    public void setLoadCapacity(double loadCapacity) { this.loadCapacity = loadCapacity; }

    // Override phương thức applyDiscount() → giảm giá 20%
    @Override
    public void applyDiscount() {
        setPrice(getPrice() * 0.80); // giảm 20%
    }

    @Override
    public String toString() {
        return super.toString() + ", LoadCapacity: " + loadCapacity + " tấn";
    }
}

// ================= Main Program =================
public class ASMJava {
    private static final Scanner sc = new Scanner(System.in);
    private static final ArrayList<Vehicle> vehicles = new ArrayList<>();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }
            switch (choice) {
                case 1: addVehicle(); break;
                case 2: removeVehicle(); break;
                case 3: displayVehicles(); break;
                case 4: searchByBrand(); break;
                case 5: sortByPriceAsc(); break;
                case 6: sortByYearDesc(); break;
                case 7: advancedFunctionsMenu(); break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    break;
                default: System.out.println("❌ Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);
    }

    private static void showMenu() {
        final String RED = "\u001B[31m";
        final String RESET = "\u001B[0m";

        System.out.println("\n===== QUẢN LÝ GARA XE =====");
        System.out.println("1. Thêm xe mới");
        System.out.println("2. Xóa xe theo ID");
        System.out.println("3. Hiển thị danh sách xe");
        System.out.println("4. Tìm kiếm xe theo hãng");
        System.out.println("5. Sắp xếp xe theo giá tăng dần");
        System.out.println("6. Sắp xếp xe theo năm sản xuất giảm dần");
        System.out.println("7. Chức năng nâng cao");
        System.out.println(RED + "0. Thoát" + RESET);
        System.out.println(RED + "============================" + RESET);
        System.out.print("👉 Nhập lựa chọn: ");
    }

    // ========== Menu chức năng nâng cao ==========
    private static void advancedFunctionsMenu() {
        final String CYAN = "\u001B[36m";
        final String RESET = "\u001B[0m";

        int choice;
        do {
            System.out.println("\n===== MENU CHỨC NĂNG NÂNG CAO =====");
            System.out.println("1. Thống kê xe (theo hãng, loại, năm)");
            System.out.println("2. Cập nhật thông tin xe theo ID");
            System.out.println("3. Xuất danh sách xe ra file");
            System.out.println(CYAN + "0. Quay lại menu chính" + RESET);
            System.out.print("👉 Nhập lựa chọn: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Lựa chọn không hợp lệ! Vui lòng nhập số.");
                choice = -1;
            }

            switch (choice) {
                case 1: showStatistics(); break;
                case 2: updateVehicle(); break;
                case 3: exportToFile(); break;
                case 0: System.out.println("⬅ Quay lại menu chính."); break;
                default: System.out.println("❌ Lựa chọn không hợp lệ.");
            }
        } while (choice != 0);
    }

    // ========== Chức năng cơ bản ==========
    private static void addVehicle() {
        int type;
        do {
            type = inputInt("Chọn loại xe (1: Car, 2: Truck): ");
            if (type != 1 && type != 2) {
                System.out.println("❌ Vui lòng chọn 1 (Car) hoặc 2 (Truck)!");
            }
        } while (type != 1 && type != 2);

        String brand = inputRequired("Nhập hãng xe: ");
        String model = inputRequired("Nhập dòng xe: ");
        int year = inputYear("Nhập năm sản xuất: ");
        double price = inputPositiveDouble("Nhập giá xe: ");
        String color = inputRequired("Nhập màu xe: ");

        if (type == 1) {
            int seatCount = inputPositiveInt("Nhập số ghế: ");
            vehicles.add(new Car(brand, model, year, price, color, seatCount));
        } else if (type == 2) {
            double loadCapacity = inputPositiveDouble("Nhập tải trọng (tấn): ");
            vehicles.add(new Truck(brand, model, year, price, color, loadCapacity));
        }

        // === Thông báo sau khi thêm thành công ===
        System.out.println("✅ Xe đã được thêm!");
        int total = vehicles.size();
        System.out.println("Tổng số xe hiện tại: " + total);
        if (total > 20) {
            System.out.println("Gara lớn");
        } else {
            System.out.println("Gara nhỏ");
        }
    }

    private static void removeVehicle() {
        int id = inputInt("Nhập ID xe cần xóa: ");
        boolean removed = vehicles.removeIf(v -> v.getId() == id);
        if (removed) {
            System.out.println("✅ Đã xóa xe có ID = " + id);
        } else {
            System.out.println("⚠️ Không tìm thấy xe với ID = " + id);
        }

        // === Thông báo tổng số xe sau khi xóa ===
        int total = vehicles.size();
        System.out.println("Tổng số xe hiện tại: " + total);
        if (total > 20) {
            System.out.println("Gara lớn");
        } else {
            System.out.println("Gara nhỏ");
        }
    }

    private static void displayVehicles() {
        if (vehicles.isEmpty()) {
            System.out.println("Danh sách trống!");
            return;
        }

        // Sử dụng for-each để duyệt danh sách
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }

        // Hiển thị tổng số xe hiện tại (dùng static)
        int total = Vehicle.getVehicleCount();
        System.out.println("Tổng số xe hiện tại: " + total);
        if (total > 20) {
            System.out.println("Gara lớn");
        } else {
            System.out.println("Gara nhỏ");
        }
    }

    private static void searchByBrand() {
        String brand = inputRequired("Nhập hãng xe cần tìm: ");

        // Sử dụng for-each để duyệt danh sách
        boolean found = false;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getBrand().equalsIgnoreCase(brand)) {
                System.out.println(vehicle);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy xe nào thuộc hãng " + brand);
        }
    }

    private static void sortByPriceAsc() {
        vehicles.sort(Comparator.comparingDouble(Vehicle::getPrice));
        System.out.println("Đã sắp xếp xe theo giá tăng dần.");
        displayVehicles();
    }

    private static void sortByYearDesc() {
        vehicles.sort((v1, v2) -> Integer.compare(v2.getYear(), v1.getYear()));
        System.out.println("Đã sắp xếp xe theo năm sản xuất giảm dần.");
        displayVehicles();
    }

    // ========== CHỨC NĂNG NÂNG CAO ==========

    // 1. Thống kê xe
    private static void showStatistics() {
        if (vehicles.isEmpty()) {
            System.out.println("📊 Danh sách xe trống!");
            return;
        }

        System.out.println("\n📊 === THỐNG KÊ GARA XE ===");

        // Thống kê theo loại xe
        Map<String, Integer> typeStats = new HashMap<>();
        for (Vehicle v : vehicles) {
            typeStats.put(v.getType(), typeStats.getOrDefault(v.getType(), 0) + 1);
        }
        System.out.println("🚗 Theo loại xe:");
        for (Map.Entry<String, Integer> entry : typeStats.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue() + " xe");
        }

        // Thống kê theo hãng xe
        Map<String, Integer> brandStats = new HashMap<>();
        for (Vehicle v : vehicles) {
            brandStats.put(v.getBrand(), brandStats.getOrDefault(v.getBrand(), 0) + 1);
        }
        System.out.println("\n🏭 Theo hãng xe:");
        for (Map.Entry<String, Integer> entry : brandStats.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue() + " xe");
        }

        // Thống kê theo năm sản xuất (theo thập kỷ)
        Map<String, Integer> decadeStats = new HashMap<>();
        for (Vehicle v : vehicles) {
            String decade = (v.getYear() / 10) * 10 + "s";
            decadeStats.put(decade, decadeStats.getOrDefault(decade, 0) + 1);
        }
        System.out.println("\n📅 Theo thập kỷ sản xuất:");
        for (Map.Entry<String, Integer> entry : decadeStats.entrySet()) {
            System.out.println("   " + entry.getKey() + ": " + entry.getValue() + " xe");
        }

        // Thống kê giá trung bình
        double totalValue = vehicles.stream().mapToDouble(Vehicle::getPrice).sum();
        double avgPrice = totalValue / vehicles.size();
        System.out.println("\n💰 Giá trị trung bình: " + String.format("%.2f", avgPrice) + " VNĐ");
        System.out.println("💰 Tổng giá trị gara: " + String.format("%.2f", totalValue) + " VNĐ");
    }

    // 2. Cập nhật thông tin xe
    private static void updateVehicle() {
        int id = inputInt("Nhập ID xe cần cập nhật: ");

        Vehicle vehicle = null;
        for (Vehicle v : vehicles) {
            if (v.getId() == id) {
                vehicle = v;
                break;
            }
        }

        if (vehicle == null) {
            System.out.println("⚠️ Không tìm thấy xe với ID = " + id);
            return;
        }

        System.out.println("Xe hiện tại: " + vehicle);
        System.out.println("\nNhập thông tin mới (Enter để giữ nguyên):");

        System.out.print("Hãng hãng xe mới (" + vehicle.getBrand() + "): ");
        String newBrand = sc.nextLine().trim();
        if (!newBrand.isEmpty()) vehicle.setBrand(newBrand);

        System.out.print("Dòng dòng xe mới (" + vehicle.getModel() + "): ");
        String newModel = sc.nextLine().trim();
        if (!newModel.isEmpty()) vehicle.setModel(newModel);

        System.out.print("Năm sản xuất mới (" + vehicle.getYear() + "): ");
        String yearStr = sc.nextLine().trim();
        if (!yearStr.isEmpty()) {
            try {
                vehicle.setYear(Integer.parseInt(yearStr));
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Năm không hợp lệ, giữ nguyên năm cũ");
            }
        }

        System.out.print("Giá xe mới (" + String.format("%.2f", vehicle.getPrice()) + "): ");
        String priceStr = sc.nextLine().trim();
        if (!priceStr.isEmpty()) {
            try {
                vehicle.setPrice(Double.parseDouble(priceStr));
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Giá không hợp lệ, giữ nguyên giá cũ");
            }
        }

        System.out.print("Màu xe mới (" + vehicle.getColor() + "): ");
        String newColor = sc.nextLine().trim();
        if (!newColor.isEmpty()) vehicle.setColor(newColor);

        if (vehicle instanceof Car) {
            System.out.print("Số ghế mới (" + ((Car) vehicle).getSeatCount() + "): ");
            String seatStr = sc.nextLine().trim();
            if (!seatStr.isEmpty()) {
                try {
                    ((Car) vehicle).setSeatCount(Integer.parseInt(seatStr));
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Số ghế không hợp lệ, giữ nguyên");
                }
            }
        } else if (vehicle instanceof Truck) {
            System.out.print("Tải trọng mới (tấn) (" + ((Truck) vehicle).getLoadCapacity() + "): ");
            String loadStr = sc.nextLine().trim();
            if (!loadStr.isEmpty()) {
                try {
                    ((Truck) vehicle).setLoadCapacity(Double.parseDouble(loadStr));
                } catch (NumberFormatException e) {
                    System.out.println("⚠️ Tải trọng không hợp lệ, giữ nguyên");
                }
            }
        }

        System.out.println("✅ Cập nhật thành công!");
        System.out.println("Thông tin xe sau khi cập nhật: " + vehicle);
    }

    // 3. Xuất danh sách xe ra file
    private static void exportToFile() {
        if (vehicles.isEmpty()) {
            System.out.println("Danh sách xe trống!");
            return;
        }
        exportToCSV();
    }

    private static void exportToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("vehicles_export.csv"))) {
            writer.println("ID,Brand,Model,Year,Price,Color,Type,ExtraInfo");

            for (Vehicle v : vehicles) {
                String extraInfo = "";
                if (v instanceof Car) {
                    extraInfo = "SeatCount:" + ((Car) v).getSeatCount();
                } else if (v instanceof Truck) {
                    extraInfo = "LoadCapacity:" + ((Truck) v).getLoadCapacity();
                }

                writer.println(v.getId() + "," + v.getBrand() + "," + v.getModel() + "," +
                        v.getYear() + "," + v.getPrice() + "," + v.getColor() + "," +
                        v.getType() + "," + extraInfo);
            }

            System.out.println("✅ Đã xuất " + vehicles.size() + " xe ra file vehicles_export.csv");
        } catch (IOException e) {
            System.out.println("❌ Lỗi khi xuất CSV: " + e.getMessage());
        }
    }
}

