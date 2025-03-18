package entity;

import java.util.Scanner;

public class CategoryManager {
    Categories[] categories;
    int currentIndex;
    public CategoryManager() {
        categories = new Categories[100];
        currentIndex = 0;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    public void displayCategories() {
        for (int i = 0; i < currentIndex; i++) {
            categories[i].displayData();
        }
    }

    public void addNewCategory(Scanner scanner) {
        categories[currentIndex] = new Categories();
        categories[currentIndex].inputData(scanner);
        currentIndex++;
    }

    public void updateCategory(Scanner scanner) {
        boolean Exit = true;
        System.out.print("Nhập id danh mục cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        int indexUpdate = -1;
        for (int i = 0; i < currentIndex; i++) {
            if (categories[i].getId() == id) {
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
                        categories[indexUpdate].valueCataName(scanner);
                        break;
                    case 2:
                        System.out.print("Nhập mức độ ưu tiên: ");
                        categories[indexUpdate].setPriority(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        categories[indexUpdate].valueCataDes(scanner);
                        break;
                    case 4:
                        System.out.println("Nhập trạng thái danh mục: ");
                        categories[indexUpdate].setStatus(Boolean.parseBoolean(scanner.nextLine()));
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
        for (int i = 0; i < currentIndex; i++) {
            if (categories[i].getId() == id) {
                indexUpdate = i;
            }
        }
        if (indexUpdate != -1) {
            for (int i = indexUpdate; i < currentIndex; i++) {
                categories[i] = categories[i + 1];
            }
        }else {
            System.out.println("Không tìm thấy danh mục");
        }
        currentIndex--;
    }

        public void searchCategory(Scanner scanner) {
        System.out.print("Nhập tên danh mục cần tìm: ");
        String search = scanner.nextLine();
        boolean found = false;
        for (int i = 0; i < currentIndex; i++) {
            if(categories[i].getNameCatalog().equals(search)) {
             found = true;
             categories[i].displayData();
            }
        }
        if(!found) {
            System.out.println("Không tìm thấy danh mục");
        }
    }
}
