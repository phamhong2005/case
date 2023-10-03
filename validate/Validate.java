package validate;

import java.util.Scanner;

public class Validate {

    public static String inputAccount() {
        Scanner scanner = new Scanner(System.in);
        String regex = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}";
        String account;
        do {
            System.out.println("Tên Tài Khoản");
            account = scanner.nextLine();
            if (account.matches(regex)) {
                break;
            }
        } while (true);
        return account;
    }

    public static String inputPassWord() {
        Scanner scanner = new Scanner(System.in);
        String regex = "^[a-zA-Z0-9!@#$%^&*()_+-={}|,.<>/?]{8,}$";
        String password;
        do {
            System.out.println("Nhập Mật Khẩu");
            password = scanner.nextLine();
            if (password.matches(regex)) {
                break;
            }
        } while (true);
        return password;
    }

    public static int choice() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Yêu Cầu Bạn Nhap Đúng");
            }
        } while (true);
        return choice;
    }

    public static String number() {
        Scanner scanner = new Scanner(System.in);
        String regex = "[1,2]";
        String number;
        do {
            try {
                number = scanner.nextLine();
                if (number.matches(regex)) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Yêu Cầu Bạn Nhập Đúng");
            }
        } while (true);
        return number;
    }
}
