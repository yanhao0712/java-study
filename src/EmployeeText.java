import java.util.Objects;

public class EmployeeText {
    public  static void main(String[] args) {
        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1001,"Tom");
        System.out.println("e1是否等于e2" +
                e1.equals(e2));
    }
}



class Employee {
    int id;
    String name;
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null){
            return   false;
        }
        if(obj instanceof Employee){
            Employee e = (Employee)obj;
            return this.id == e.id && Objects.equals(this.name, e.name);
        }
        return false;
    }
}




