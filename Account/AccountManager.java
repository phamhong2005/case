package Account;

import WriteFile.ReadAndWriteFile;

import java.awt.*;
import java.util.ArrayList;

public class AccountManager implements IAccountManager<Account> {
    ArrayList<Account> list;
    ReadAndWriteFile readAndWriteFile;


    public AccountManager() {
        readAndWriteFile = new ReadAndWriteFile();
        list = readAndWriteFile.listAccount();
    }

    @Override
    public void register(Account account) {
        list.add(account);
        readAndWriteFile.writeFile(list);
    }

    @Override
    public ArrayList<Account> showAll() {
        return list;
    }

    @Override
    public void ChangePassword(String userName, Account account) {
        int index = findName(userName);
        if (index!=-1){
            list.set(index,account);
            System.out.println("Đổi Thành Công");
        }
        else {
            System.out.println("Không Đúng Email nayf");
        }
        readAndWriteFile.writeFile(list);
    }


    @Override
    public int findName(String name) {
        for (int i = 0; i < list.size(); i++) {
            if (name.equals(list.get(i).getUsername())){
                return i;
            }
        }
        return -1;
    }
}
