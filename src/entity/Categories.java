package entity;

import java.util.Scanner;

public class Categories implements IApp{
    private int id = 0;
    private String nameCatalog;
    private int priority;
    private String description;
    private Boolean status;

    public Categories (){
        this.id = getId();
        autoIncrement();
    }

    public Categories(int id, String nameCatalog, int priority, String description, Boolean status) {
        this.id = id;
        this.nameCatalog = nameCatalog;
        this.priority = priority;
        this.description = description;
        this.status = status;
    }

    CategoryManager categoryManager = new CategoryManager();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameCatalog() {
        return nameCatalog;
    }

    public void setNameCatalog(String nameCatalog) {
        this.nameCatalog = nameCatalog;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void autoIncrement(){
        setId(getId()+1);
    };

    public void valueCataName(Scanner scanner){
        do {
            System.out.print("Nhập tên danh mục: ");
            String nameCatalog = scanner.nextLine();
            boolean isfind = false;
            if(categoryManager.currentIndex != 0){
                for(int i = 0; i < categoryManager.currentIndex; i++){
                    if (nameCatalog.equals(categoryManager.categories[i].getNameCatalog())){
                        System.out.println("Tên bị trùng vui lòng nhập lại");
                        isfind = true;
                        break;
                    }
                }
            }
            if((nameCatalog.length() < 6 || nameCatalog.length() > 50) && !isfind){
                System.out.println("Tên không hợp lệ vui lòng nhập lại");
            }else {
                setNameCatalog(nameCatalog);
                break;
            }
        }while (true);
    }

    public void valueCataDes(Scanner scanner){
        do {
            System.out.print("Nhập mô tả danh mục: ");
            String desCatalog = scanner.nextLine();
            if(desCatalog.length() >= 225){
                System.out.println("Mô tả quá dài vui lòng nhập lại");
            }else {
                setDescription(desCatalog);
                break;
            }
        }while (true);
    }

    @Override
    public void inputData(Scanner scanner) {
        valueCataName(scanner);
        System.out.print("Nhập độ ưu tiên: ");
        setPriority(Integer.parseInt(scanner.nextLine()));
        valueCataDes(scanner);
        System.out.print("Nhập trạng thái danh mục(true – Hoạt động, false – Không hoạt động): ");
        setStatus(Boolean.parseBoolean(scanner.nextLine()));
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %d - Tên danh mục - %s - Độ ưu tiên: %d\n", id, nameCatalog, priority);
        System.out.printf("Mô tả: %s\n", description);
        System.out.println("Trạng thái: " + (status?"Hoạt động":"Không hoạt động"));
        System.out.println("---------------------------------------------------------");
    }
}
