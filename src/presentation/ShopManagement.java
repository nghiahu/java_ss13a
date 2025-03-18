package presentation;

import entity.Categories;
import entity.CategoryManager;
import entity.Product;
import entity.ProductManager;

import java.util.Scanner;

public class ShopManagement {
    public static Categories[] categories = new Categories[100];
    public static int currentIndex = 0;
    public static Product[] product = new Product[100];
    public static int productIndex = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CategoryManager categoryManager = new CategoryManager();
        ProductManager productManager = new ProductManager();
        do{
            System.out.println("*********************SHOP MENU*********************");
            System.out.println("1. Quản lý danh mục");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3 Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    boolean Exit = true;
                    do{
                        System.out.println("********************CATEGORIE MANAGEMENT*********************");
                        System.out.println("1. Danh sách danh mục");
                        System.out.println("2. Thêm mới danh mục");
                        System.out.println("3. Cập nhật danh mục");
                        System.out.println("4. Xóa danh mục");
                        System.out.println("5. Tìm kiếm danh mục theo tên");
                        System.out.println("6. Thoát");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                categoryManager.displayCategories();
                                break;
                            case 2:
                                categoryManager.addNewCategory(scanner);
                                break;
                            case 3:
                                categoryManager.updateCategory(scanner);
                                break;
                            case 4:
                                categoryManager.deleteCategory(scanner);
                                break;
                            case 5:
                                categoryManager.searchCategory(scanner);
                                break;
                            case 6:
                                Exit = false;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                        }
                    }while (Exit);
                    break;
                case 2:
                    Exit = true;
                    do{
                        System.out.println("************************PRODUCT MANAGEMENT*******************");
                        System.out.println("1. Danh sách sản phẩm");
                        System.out.println("2. Thêm mới sản phẩm");
                        System.out.println("3. Cập nhật sản phẩm");
                        System.out.println("4. Xóa sản phẩm");
                        System.out.println("5. Tìm kiếm sản phẩm theo tên hoặc tiêu đề");
                        System.out.println("6. Tìm kiếm sản phẩm theo khoảng giá bán");
                        System.out.println("7. Sắp xếp sản phẩm theo giá tăng dần");
                        System.out.println("8. Bán sản phẩm");
                        System.out.println("9. Thống kê số lượng sản phẩm theo danh mục");
                        System.out.println("10. Thoát");
                        System.out.print("Nhập lựa chọn của bạn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                productManager.displayProduct();
                                break;
                            case 2:
                                productManager.addNewProduct(scanner);
                                break;
                            case 3:
                                productManager.updateProduct(scanner);
                                break;
                            case 4:
                                productManager.deleteProduct(scanner);
                                break;
                            case 5:
                                productManager.searchProduct(scanner);
                                break;
                            case 6:
                                productManager.searchProductByPrice(scanner);
                                break;
                            case 7:
                                productManager.sortProductByPrice();
                                break;
                            case 8:
                                productManager.sellProduct(scanner);
                                break;
                            case 9:
                                productManager.productStatistics();
                                break;
                            case 10:
                                Exit = false;
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
                        }
                    }while (Exit);
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại!");
            }
        }while (true);
    }
}
