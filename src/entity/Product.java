package entity;

import java.util.Scanner;

public class Product implements IApp {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private String title;
    private String description;
    private int quantity;
    private int categoryId;
    private int status;

    public Product() {}
    public Product(String productId, String productName, float importPrice, float exportPrice, String title, String description, int quantity, int categoryId, int status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.description = description;
        this.quantity = quantity;
        this.categoryId = categoryId;
        this.status = status;
    }

    ProductManager productManager = new ProductManager();
    CategoryManager categoryManager = new CategoryManager();
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    public void valueProId(Scanner scanner){
        do {
            System.out.print("Nhập vào mã sản phẩm: ");
            String proId = scanner.nextLine();
            String proIdRegex = "(C|E|T)\\d{4}";
            boolean isFound = false;
            for (int i = 0; i < productManager.productIndex; i++) {
                if(proId.equals(productManager.product[i].getProductId())){
                    isFound = true;
                    System.out.println("ID bị trùng lặp vui lòng nhập lại");
                    break;
                }
            }
            if(proId.matches(proIdRegex) && !isFound){
                setProductId(proId);
                break;
            }else {
                System.out.println("ID không hợp lệ vui lòng nhập lại!");
            }

        }while (true);
    }
    public void valueProName(Scanner scanner){
        do {
            System.out.print("Nhập vào tên sản phẩm: ");
            String proName = scanner.nextLine();
            boolean isFound = false;
            for (int i = 0; i < productManager.productIndex; i++) {
                if(proName.equals(productManager.product[i].getProductName())){
                    isFound = true;
                    System.out.println("Tên bị trùng lặp vui lòng nhập lại");
                    break;
                }
            }
            if(proName.length() >= 10 && proName.length() <= 100 && !isFound){
                setProductName(proName);
                break;
            }else {
                System.out.println("Tên không hợp lệ vui lòng nhập lại!");
            }
        }while (true);
    }
    public void valueProImportPrice(Scanner scanner){
        do {
            System.out.print("Nhập giá nhập sản phẩm: ");
            float importPrice = Float.parseFloat(scanner.nextLine());
            if(importPrice > 0){
                setImportPrice(importPrice);
                break;
            }else {
                System.out.println("Giá nhập không hợp lệ vui lòng nhập lại!");
            }
        }while (true);
    }
    public void valueProExportPrice(Scanner scanner){
        do {
            System.out.print("Nhập giá xuất sản phẩm: ");
            float exportPrice = Float.parseFloat(scanner.nextLine());
            if(exportPrice >= getImportPrice() * INTEREST){
                setExportPrice(exportPrice);
                break;
            }else {
                System.out.println("Giá xuất không hợp lệ vui lòng nhập lại!");
            }
        }while (true);
    }
    public void valueProTitle(Scanner scanner){
        do {
            System.out.print("Nhập tiêu đề sản phẩm: ");
            String proTitle = scanner.nextLine();
            if(proTitle.length() <= 200 ){
                setTitle(proTitle);
                break;
            }else {
                System.out.println("Tiêu đề không hợp lệ vui lòng nhập lại!");
            }
        }while (true);
    }

    public void valueCatalogId(Scanner scanner){
        do{
            System.out.print("Nhập vào mã danh mục: ");
            int catalogId = Integer.parseInt(scanner.nextLine());
            boolean isFound = false;
            for (int i = 0; i < categoryManager.currentIndex; i++) {
                if(catalogId == categoryManager.categories[i].getId()){
                    isFound = true;
                    break;
                }
            }
            if(isFound){
                setCategoryId(catalogId);
                break;
            }else {
                System.out.println("Không có mã danh mục này vui lòng nhập lại!");
            }
        }while (true);
    }
    @Override
    public void inputData(Scanner scanner) {
        valueProId(scanner);
        valueProName(scanner);
        valueProImportPrice(scanner);
        valueProExportPrice(scanner);
        valueProTitle(scanner);
        System.out.print("Nhập mô tả sản phẩm: ");
        setDescription(scanner.nextLine());
        System.out.print("Nhập số lượng sản phẩm: ");
        setQuantity(Integer.parseInt(scanner.nextLine()));
        valueCatalogId(scanner);
        System.out.print("Nhập vào trạng thái sản phẩm (0:Đang hoạt động – 1:hết hàng – 2:không hoạt động): ");
        setStatus(Integer.parseInt(scanner.nextLine()));
    }

    @Override
    public void displayData() {
        System.out.printf("Mã sản phẩm: %s - Tên sản phẩm: %s\n", getProductId(),getProductName());
        System.out.printf("Giá nhập sản phẩm: %.2f - Giá xuất: %.2f\n", getImportPrice(),getExportPrice());
        System.out.println("Tiêu đề sản phẩm: " + getTitle());
        System.out.println("Mô tả sản phẩm: " + getDescription());
        System.out.printf("Số lượng sản phẩm: %d - Mã danh mục: %d\n", getQuantity(),getCategoryId());
        System.out.println("Trạng thái: " + (getStatus()==0?"Đang hết hàng":(getStatus()==1?"Hết hàng":"Không hoạt động")));
        System.out.println("-----------------------------------------------------------------------------");
    }
}
