package WriteFile;

import Account.Account;
import model.Staff;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWriteFile {
    File file = new File("data/Account.csv");
    File file1 = new File("data/Staff.csv");

    public void writeFile(ArrayList<Account> accounts) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Account account : accounts) {
                line += account.getUsername() + "," + account.getPassword() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Account> listAccount() {
        ArrayList<Account> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] str = line.split(",");
                Account account = new Account(str[0], str[1]);
                list.add(account);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }
        return list;
    }

    public void WriteFileStaff(ArrayList<Staff> staff) {
        try {
            FileWriter fileWriter = new FileWriter(file1);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            for (Staff list : staff) {
                line += list.getId() + "," + list.getName() + "," + list.isStatus() + "," + list.getEmployeeType() + "\n";
            }
            bufferedWriter.write(line);
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Staff> listStaff() {
        ArrayList<Staff> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file1);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line=bufferedReader.readLine())!=null){
                String [] data = line.split(",");
                Staff staff = new Staff(Integer.parseInt(data[0]),data[1], Boolean.parseBoolean(data[2]),data[3]);
                list.add(staff);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
}

