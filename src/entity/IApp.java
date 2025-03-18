package entity;

import java.util.Scanner;

public interface IApp {
    Scanner scanner = new Scanner(System.in);
    void inputData(Scanner scanner);
    void displayData();
    double INTEREST = 1.1;
}
