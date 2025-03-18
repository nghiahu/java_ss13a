package entity;

import presentation.ShopManagement;

import java.util.Scanner;

public class CategoryManager {

    public CategoryManager() {

    }

    public void displayCategories() {
        for (int i = 0; i < ShopManagement.currentIndex; i++) {
            ShopManagement.categories[i].displayData();
        }
    }

    public void addNewCategory(Scanner scanner) {
        ShopManagement.categories[ShopManagement.currentIndex] = new Categories();
        ShopManagement.categories[ShopManagement.currentIndex].inputData(scanner);
        ShopManagement.currentIndex++;
    }

    public void updateCategory(Scanner scanner) {
        boolean Exit = true;
        System.out.print("Nhập id danh mục cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int indexUpdate = -1;
        for (int i = 0; i < ShopManagement.currentIndex; i++) {
            if (ShopManagement.categories[i].getId() == id) {
                indexUpdate = i;
            }
        }
        if (indexUpdate != -1) {
            do {
                System.out.println("1. Cập nhật tên danh mục");
                System.out.println("2. Cập nhật độ ưu tiên");
                System.out.println("3. Cập nhật mô tả danh mục");
                System.out.println("4. Cập nhật trạng thái danh mục");
                System.out.println("5. Thoát");
                System.out.print("Nhập lựa chọn của bạn: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ShopManagement.categories[indexUpdate].valueCataName(scanner);
                        break;
                    case 2:
                        System.out.print("Nhập mức độ ưu tiên: ");
                        ShopManagement.categories[indexUpdate].setPriority(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        ShopManagement.categories[indexUpdate].valueCataDes(scanner);
                        break;
                    case 4:
                        System.out.println("Nhập trạng thái danh mục: ");
                        ShopManagement.categories[indexUpdate].setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 5:
                        Exit = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                }
            } while (Exit);
        }else {
            System.out.println("Không tìm thấy danh mục");
        }
    }

    public void deleteCategory(Scanner scanner) {
        System.out.print("Nhập id danh mục cần xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int indexUpdate = -1;
        for (int i = 0; i < ShopManagement.currentIndex; i++) {
            if (ShopManagement.categories[i].getId() == id) {
                indexUpdate = i;
            }
        }
        if (indexUpdate != -1) {
            for (int i = indexUpdate; i < ShopManagement.currentIndex; i++) {
                ShopManagement.categories[i] = ShopManagement.categories[i + 1];
            }
        }else {
            System.out.println("Không tìm thấy danh mục");
        }
        ShopManagement.currentIndex--;
    }

        public void searchCategory(Scanner scanner) {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String search = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < ShopManagement.currentIndex; i++) {
            if(ShopManagement.categories[i].getNameCatalog().equals(search)) {
             found = true;
             ShopManagement.categories[i].displayData();
            }
        }
        if(!found) {
            System.out.println("Không tìm thấy danh mục");
        }
    }
}
