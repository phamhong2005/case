package Account;

import WriteFile.ReadAndWriteFile;

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





}
