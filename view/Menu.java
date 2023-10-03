package view;

import Account.Account;
import Account.AccountManager;
import manager.StaffManager;
import model.Staff;
import validate.Validate;

import javax.xml.namespace.QName;
import java.util.Scanner;

public class Menu {
    AccountManager accountManager = new AccountManager();
    Scanner scanner = new Scanner(System.in);
    StaffManager staffManager = new StaffManager();

    public void showRegister() {
        System.out.println("Đăng Kí Tài Khoản");
        String account1 = Validate.inputAccount();
        String pass = Validate.inputPassWord();
        Account account = new Account(account1, pass);
        accountManager.register(account);
        System.out.println("Đăng Kí Thành Công");
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

    public boolean status() {
        int status = scanner.nextInt();
        if (status == 1) {
            return true;
        }
        return false;
    }

    public String employeeType() {
        int employeeType = scanner.nextInt();
        if (employeeType == 1) {
            return "FullTime";
        }
        return "PartTime";
    }


    public void show() {
        int choice;
        do {
            System.out.println("===Menu===\n1.Đăng Kí Tài Khoản\n2.Đăng Nhập\n3.Hiển Thị Tài Khoản");
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

    public void findAll() {
        System.out.println(accountManager.showAll());
    }

    public void loginAccount() {
        boolean login = login();
        int choice;
        if (login == true) {
            do {
                System.out.println("===Menu===\n1.Thêm Nhân Viên\n2.Tìm Kiếm Thông Tin Nhân Viên\n3.Tìm Kiếm Trạng Thái Nhân Viên\n4.Sửa Sinh Viên\n5.Hiển Thị Tất Ca");
                System.out.println("Nhập lựa chọn của bạn");
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
                        showAllStaff();
                        break;
                }
            } while (choice != 0);

        } else {
            System.out.println("Nhập sai Tai Khoan Hoac Mat Khau");
        }
    }

    public void add() {
        System.out.println("Nhập ID Nhân Viên");
        int id = Validate.choice();
        System.out.println("Nhập Tên Nhân Viên");
        String name = scanner.nextLine();
        System.out.println("Nhập Trạng Thái");
        boolean status = status();
        System.out.println("Nhập Kiểu Nhân Viên");
        String employeeType = employeeType();
        Staff staff = new Staff(id, name, status, employeeType);
        staffManager.add(staff);
        System.out.println("Thêm Nhân Viên Thành Công");
    }

    public void search() {
        System.out.println("Nhập Tên Mà Bạn Muốn Tìm");
        String name = scanner.nextLine();
        System.out.println(staffManager.searchName(name));
    }
    public void searchStatus(){
        scanner.nextLine();
        System.out.println("Nhập Tên Bạn Muon Tim");
        String name = scanner.nextLine();
        System.out.println(staffManager.searchStatus(name));
        }
        public void update(){
            System.out.println("Nhập ID Mà Bạn Muốn Sửa");
            int idEdit = Integer.parseInt(Validate.number());
            scanner.nextLine();
            System.out.println("Nhập Tên Nhân Viên Bạn Muốn Thay Đổi");
            String name = scanner.nextLine();
            System.out.println("Nhập Trạng Thái");
            boolean status = status();
            System.out.println("Nhập Kiểu Nhân Viên");
            String employeeType = employeeType();
            Staff staff = new Staff(idEdit, name, status, employeeType);
            staffManager.update(idEdit,staff);
            System.out.println("Sửa Thành Công");
        }
        public void showAllStaff(){
            System.out.println(staffManager.findAll());
        }
    }



