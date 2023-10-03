package Account;

import java.util.ArrayList;

public interface IAccountManager <E>{
    void register(E e);
    ArrayList<E> showAll();
}
