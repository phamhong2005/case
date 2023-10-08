package manager;

import model.Staff;

import java.util.ArrayList;

public interface IStaffManager<E> {
    void add(E e);

    void update(int id, E e);

    void delete(int id);

    int findById(int id);

    ArrayList<Staff> findAll();

    ArrayList<Staff> searchName(String name);

    boolean searchStatus(String name);
    String salary(int id);
    void status(int id,boolean status);
}
