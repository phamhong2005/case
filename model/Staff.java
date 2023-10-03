package model;

public class Staff {
    private int id;
    private String name;
    private boolean status;
    private String employeeType;

    public Staff(int id, String name, boolean status, String employeeType) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.employeeType = employeeType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus(){
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", employeeType='" + employeeType + '\'' +
                '}';
    }
}
