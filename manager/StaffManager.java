package manager;

import WriteFile.ReadAndWriteFile;
import model.Staff;

import java.util.ArrayList;

public class StaffManager implements IStaffManager<Staff> {
    ArrayList<Staff> list;
    ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();

    public StaffManager() {
        list = readAndWriteFile.listStaff();
    }

    @Override
    public void add(Staff staff) {
        list.add(staff);
        readAndWriteFile.WriteFileStaff(list);
    }

    @Override
    public void update(int id, Staff staff) {
        int index = findById(id);
        list.set(index,staff);
        readAndWriteFile.WriteFileStaff(list);

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public int findById(int id) {
        for (int i = 0; i < list.size(); i++) {
            if (id==list.get(i).getId()){
                return i;
            }
        }
        return -1;
    }

    @Override
    public ArrayList<Staff> findAll() {
        return list;
    }

    @Override
    public ArrayList<Staff> searchName(String name) {
        ArrayList<Staff> list1 = new ArrayList<>();
        for (Staff staff:list) {
            if (staff.getName().toLowerCase().contains(name.toLowerCase())){
                list1.add(staff);
            }
        }
        return list1;
    }

    @Override
    public boolean searchStatus(String name) {
        for (Staff staff : list){
            if (staff.getName().toLowerCase().contains(name.toLowerCase())){
                return staff.isStatus();
            }
        }
        return false;
    }

}
