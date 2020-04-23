package ir.ac.kntu;

public class Employee extends Admin{
    private Date employment;
    private long salary;

    public Employee(String userName, String password, String email, long phoneNumber, Date employment, long salary,User user){
        super(userName, password, email, phoneNumber,user);
        this.employment = employment;
        this.salary = salary;
    }
}
