package view;

import Account.Account;
import Account.AccountManager;
import manager.StaffManager;
import model.Staff;
import validate.Validate;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    int count = 0;
    AccountManager accountManager = new AccountManager();
    Scanner scanner = new Scanner(System.in);
    StaffManager staffManager = new StaffManager();


    public void show() {
        int choice;
        do {
            System.out.println(ANSI_BLUE + "===Menu===\n1.Đăng Kí Tài Khoản\n2.Đăng Nhập\n3.Hiển Thị Tài Khoản ");
            choice = Validate.choice();
            switch (choice) {
                case 1:
                    showRegister();
                    break;
                case 2:
                    loginAccount();
                    break;
                case 3:
                    findAll();
                    break;

            }
        } while (choice != 0);
    }

    public void showRegister() {
        System.out.println(ANSI_PURPLE + "Đăng Kí Tài Khoản");
        String account1 = Validate.inputAccount();
        String pass = Validate.inputPassWord();
        Account account = new Account(account1, pass);
        accountManager.register(account);
        System.out.println(ANSI_CYAN + "Đăng Kí Thành Công");
    }

    public boolean login() {
        String user = Validate.inputAccount();
        String pass = Validate.inputPassWord();
        for (Account account : accountManager.showAll()) {
            if (user.equals(account.getUsername()) && pass.equals(account.getPassword())) {
                return true;
            }
        }
        return false;
    }

    public void loginAccount() {
        boolean login = login();
        int choice;
        if (login == true) {
            System.out.println(ANSI_CYAN + "Đăng Nhập Thành Công");
            do {
                count = 0;
                System.out.println(ANSI_PURPLE + "===Menu===\n1.Thêm Nhân Viên\n2.Tìm Kiếm Thông Tin Nhân Viên\n3.Tìm Kiếm Trạng Thái Nhân Viên\n4.Sửa Sinh Viên\n5.Đổi Trạng thái\n6.Sa Thải Nhân Viên\n7.Tính Lương Nhân Viên\n8.Hiển Thị Tất Cả\n0.Đăng Xuất");
                System.out.println(ANSI_BLUE + "Nhập lựa chọn của bạn");
                choice = Validate.choice();
                switch (choice) {
                    case 1:
                        add();
                        break;
                    case 2:
                        search();
                        break;
                    case 3:
                        searchStatus();
                        break;
                    case 4:
                        update();
                        break;
                    case 5:
                        setStatus();
                        break;
                    case 6:
                        remove();
                        break;
                    case 7:
                        searchSalary();
                        break;
                    case 8:
                        showAllStaff();
                        break;
                }
            } while (choice != 0);

        } else {
            count++;
            System.out.println(ANSI_RED + "Nhập Sai Tài Khoản Hoặc Mật Khẩu");
            changePassword();
        }
    }

    public void findAll() {
        System.out.println(accountManager.showAll());
    }

    public void changePassword() {
        if (count == 3) {
            int choice;
            System.out.println(ANSI_BLUE + "Nhập 1 Để Đổi Mật Khẩu\n Nhập 2 Để Đăng Nhập ");
            choice = Validate.choice();
            switch (choice) {
                case 1:
                    passWord();
                    break;
                case 2:
                    loginAccount();
                    break;
            }

        }
    }

    public boolean status() {
        do {
            try {
                int status = scanner.nextInt();
                if (status == 1) {
                    return true;
                }
                return false;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(ANSI_RED + "Yêu Cầu Bạn Nhập Đúng");
            }
        } while (true);

    }

    public String employeeType() {
        do {
            try {
                int employeeType = scanner.nextInt();
                if (employeeType == 1) {
                    return "FullTime";
                } else if (employeeType == 2) {
                    return "PartTime";
                }
                return "Nhân Viên Thử Việc";
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(ANSI_RED + "Yêu cầu Bạn Nhập Lại");
            }
        } while (true);


    }


    public void passWord() {
        String email = Validate.inputAccount();
        System.out.println(ANSI_PURPLE + "Nhap Mat Khau Ban Muon Thay Doi");
        String passWord = Validate.inputPassWord();
        Account account = new Account(email, passWord);
        accountManager.ChangePassword(email, account);
    }

    public void add() {
        System.out.println(ANSI_BLUE + "Nhập ID Nhân Viên");
        int id = Validate.choice();
        System.out.println(ANSI_PURPLE + "Nhập Tên Nhân Viên");
        String name = scanner.nextLine();
        System.out.println(ANSI_YELLOW + "Nhập Trạng Thái");
        boolean status = status();
        System.out.println(ANSI_RESET + "Nhập Kiểu Nhân Viên");
        String employeeType = employeeType();
        Staff staff = new Staff(id, name, status, employeeType);
        staffManager.add(staff);
        System.out.println(ANSI_CYAN + "Thêm Nhân Viên Thành Công");
    }

    public void search() {
        System.out.println(ANSI_BLUE + "Nhập Tên Mà Bạn Muốn Tìm");
        String name = scanner.nextLine();
        System.out.println(staffManager.searchName(name));
    }

    public void searchStatus() {
//        scanner.nextLine();
        System.out.println(ANSI_BLUE + "Nhập Tên Bạn Muốn Tim");
        String name = scanner.nextLine();
        System.out.println(staffManager.searchStatus(name));
    }

    public void update() {
        System.out.println(ANSI_BLUE + "Nhập ID Bạn Muốn Sửa");
        int idEdit = Validate.number();
        System.out.println(ANSI_PURPLE + "Nhâp Tên Nhân Viên");
        String name = scanner.nextLine();
        System.out.println(ANSI_YELLOW + "Nhập Trạng Thais");
        boolean status = status();
        System.out.println(ANSI_RESET + "Nhập Kiểu Nhân Viên");
        String employeeType = employeeType();
        Staff staff1 = new Staff(idEdit, name, status, employeeType);
        staffManager.update(idEdit, staff1);
    }


    public void remove() {
        System.out.println(ANSI_BLUE + "Nhập ID Bạn Muốn Xóa");
        int id = Validate.number();
        staffManager.delete(id);
    }

    public void searchSalary() {
        do {
            try {
                System.out.println(ANSI_BLUE + "Nhập ID Muốn Tìm");
                int id = Validate.number();
                String salary = staffManager.salary(id);
                if (salary.equals("FullTime")) {
                    System.out.println(ANSI_RED + "Lương Nhân Viên Này Được Bảy Triệu Rưỡi");
                } else {
                    System.out.println(ANSI_BLUE + "Nhập Số Giờ Làm Trong Tháng");
                    int house = scanner.nextInt();
                    System.out.println(ANSI_PURPLE + "Lương Nhân Viên Này Là " + house * 17);
                }
                break;
            } catch (NullPointerException e) {
                System.out.println(ANSI_BLUE + "Nhap lai");
            }
        } while (true);
    }

    public void showAllStaff() {
        System.out.println(staffManager.findAll());
    }


    public void setStatus() {
        System.out.println(ANSI_BLUE + "Nhập id bạn Sửa");
        int idEdit = Validate.number();
        System.out.println(ANSI_CYAN + "Nhập Trạng Thái");
        boolean status = status();
        staffManager.status(idEdit, status);
    }

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
}



