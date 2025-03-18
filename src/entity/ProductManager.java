package entity;

import presentation.ShopManagement;

import java.util.Scanner;

public class ProductManager {
    Product[] product;
    int productIndex;

    public ProductManager() {
        product = new Product[100];
        productIndex = 0;
    }

    public int getProductIndex() {
        return productIndex;
    }

    public void setProductIndex(int productIndex) {
        this.productIndex = productIndex;
    }

    public void  displayProduct() {
        for (int i = 0; i < productIndex; i++) {
            product[i].displayData();
        }
    }

    public void addNewProduct(Scanner scanner) {
        product[productIndex] = new Product();
        product[productIndex].inputData(scanner);
        productIndex++;
    }

    public void updateProduct(Scanner scanner) {
        boolean Exit = true;
        System.out.print("Nhập id sản phẩm cần sửa: ");
        String id = scanner.nextLine();
        int indexUpdate = -1;
        for (int i = 0; i < productIndex; i++) {
            if (product[i].getProductId().equals(id)) {
                indexUpdate = i;
            }
        }
        if (indexUpdate != -1) {
            do {
                System.out.println("1. Sửa tên sản phẩm");
                System.out.println(("2 .Sửa giá nhập sản phẩm"));
                System.out.println("3. Sửa giá xuất sản phẩm");
                System.out.println("4. Sửa tiêu đề sản phẩm");
                System.out.println("5. Sửa mô tả sản phẩm");
                System.out.println("6. Sửa số lượng sản phẩm");
                System.out.println("7. Sửa mã danh mục");
                System.out.println("8. sửa trạng thái danh mục");
                System.out.println("9. Thoát");
                System.out.print("Nhập lựa chọn cần sửa: ");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        product[indexUpdate].valueProName(scanner);
                        break;
                    case 2:
                        product[indexUpdate].valueProImportPrice(scanner);
                        break;
                    case 3:
                        product[indexUpdate].valueProExportPrice(scanner);
                        break;
                    case 4:
                        product[indexUpdate].valueProTitle(scanner);
                        break;
                    case 5:
                        System.out.print("Nhập mô tả sản phẩm: ");
                        product[indexUpdate].setDescription(scanner.nextLine());
                        break;
                    case 6:
                        System.out.println("Nhập số lượng sản phẩm: ");
                        product[indexUpdate].setQuantity(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 7:
                        product[indexUpdate].valueCatalogId(scanner);
                        break;
                    case 8:
                        System.out.print("Nhập vào trạng thái sản phẩm (0:Đang hoạt động – 1:hết hàng – 2:không hoạt động): ");
                        product[indexUpdate].setStatus(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 9:
                        Exit = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ vui lòng chọn lại");
                }
            }while (Exit);
        }else {
            System.out.println("Không tìm thấy sản phẩm!");
        }
    }
    public void deleteProduct(Scanner scanner) {
        System.out.print("Nhập id sản phẩm cần xóa: ");
        String id = scanner.nextLine();
        int indexDel = -1;
        for (int i = 0; i < productIndex; i++) {
            if (product[i].getProductId().equals(id)) {
                indexDel = i;
                break;
            }
        }
        if (indexDel != -1) {
            for (int i = indexDel; i < productIndex; i++) {
                product[i] = product[i + 1];
            }
        }else {
            System.out.println("Không tìm thấy sản phẩm cần xóa!");
        }
        productIndex--;
    }
    public void searchProduct(Scanner scanner) {
        System.out.println("1. Tìm theo tên sản phẩm");
        System.out.println("2. Tìm theo tiêu đề");
        int choice = Integer.parseInt(scanner.nextLine());
        int indexFound = -1;
        if(choice == 1) {
            String porductNamefind = scanner.nextLine();
            for (int i = 0; i < productIndex; i++) {
                if (product[i].getProductName().equals(porductNamefind)) {
                    indexFound = i;
                    break;
                }
            }
            if (indexFound != -1) {
                product[indexFound].displayData();
            }else {
                System.out.println("Không tìm thấy sản phẩm!");
            }
        }else {
            String porductTitlefind = scanner.nextLine();
            for (int i = 0; i < productIndex; i++) {
                if (product[i].getTitle().equals(porductTitlefind)) {
                    indexFound = i;
                    break;
                }
            }
            if (indexFound != -1) {
                product[indexFound].displayData();
            }else {
                System.out.println("Không tìm thấy sản phẩm!");
            }
        }
    }

    public void searchProductByPrice(Scanner scanner) {
        System.out.println("Giá từ: ");
        float startPrice = Float.parseFloat(scanner.nextLine());
        System.out.println("Đến: ");
        float endPrice = Float.parseFloat(scanner.nextLine());
        int isFound = 0;
        for (int i = 0; i < productIndex; i++) {
            if(product[i].getExportPrice() >= startPrice && product[i].getExportPrice() <= endPrice) {
                isFound++;
            }
        }
        if (isFound > 0) {
            product[isFound].displayData();
        }else {
            System.out.println("Không tìm thấy sản phẩm nào!");
        }
    }

    public void sortProductByPrice() {
        for (int i = 0; i < productIndex; i++) {
            for (int j = i + 1; j < productIndex; j++) {
                if (product[i].getExportPrice() > product[j].getExportPrice()) {
                    Product temp = product[i];
                    product[i] = product[j];
                    product[j] = temp;
                }
            }
        }
    }

    public void sellProduct(Scanner scanner) {
        System.out.print("Nhập id sản phẩm cần bán: ");
        String idSell = scanner.nextLine();
        System.out.print("Nhập số lượng sản phẩm bán: ");
        int quantitySell = Integer.parseInt(scanner.nextLine());
        int indexSell = -1;
        for (int i = 0; i < productIndex; i++) {
            if (product[i].getProductId().equals(idSell)) {
                indexSell = i;
                break;
            }
        }
        if (indexSell != -1) {
            int quantity = product[indexSell].getQuantity() - quantitySell;
            if (quantity > 0) {
               product[indexSell].setQuantity(quantity);
            } else if (quantity == 0) {
                product[indexSell].setQuantity(quantity);
                product[indexSell].setStatus(1);
            }else {
                System.out.println("Số lượng sản phẩm không đủ");
            }
        }else {
            System.out.println("Không tìm thấy sản phẩm muốn bán!");
        }
    }
    CategoryManager categoryManager = new CategoryManager();
    public void productStatistics(){
        int count = 0;
        for (int i = 0; i < ShopManagement.currentIndex; i++) {
            for (int j = 0; j < productIndex; j++) {
                if (ShopManagement.categories[i].getId() == product[j].getCategoryId()) {
                    count++;
                }
            }
            System.out.printf("Danh mục %s có %d sản phẩm\n", ShopManagement.categories[i].getNameCatalog(), count);
            count = 0;
        }
    }
}
