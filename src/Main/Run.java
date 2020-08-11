package Main;

import model.ConnectManager;

import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String choose = null;
        boolean exit = false;
        ConnectManager connectManager = new ConnectManager();
        String id;

        showMenu();
        while (true){
            choose = sc.nextLine();
            switch (choose){
                case "1":
                    connectManager.show();
                    break;
                case "2":
                    connectManager.add();
                    break;
                case "3":
                    id = connectManager.inputId();
                    connectManager.edit(id);
                    break;
                case "4":
                    id = connectManager.inputId();
                    connectManager.delete(id);
                    break;
                case "6":
                    connectManager.readFormFile();
                case "7":
                    connectManager.writeInFile();
                case "8":
                    System.out.println("Thoát chương trình!");
                    exit = true;
                    break;
            } if (exit) {
                break;
            }
            showMenu();
        }
    }
    public static void showMenu() {
        System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhập");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. ĐỌc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");

        System.out.println("Chọn chức năng: ");
    }
}
