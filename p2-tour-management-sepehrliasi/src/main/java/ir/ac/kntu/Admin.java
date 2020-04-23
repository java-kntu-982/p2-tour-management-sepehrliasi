package ir.ac.kntu;
import java.util.Scanner;

enum User{
    ADMIN,CUSTOMER,EMPLOYEE,LEADER;
}
public class Admin {
    private String userName;
    private String password;
    private String email;
    private long phoneNumber;
    private User user;

    UserNames userNames = UserNames.getUserNames();

    public Admin(String userName, String password, String email, long phoneNumber,User user){
        userName = checkUserName(userName);
        this.userName = userName;
        userNames.addUserName(userName);
        password = checkPassword(password);
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.user = user;
    }

    Scanner input = new Scanner(System.in);

    public String checkUserName(String userName){
        String user = userName;
        while(user.length() < 4 || userNames.getUsers().contains(user)){
            if(user.length() < 4) {
                System.out.println("user name should be at least 4 characters, try again");
                user = input.nextLine();
            }else if(userNames.getUsers().contains(user)){
                System.out.println("this user name has been taken before, try again");
                user = input.nextLine();
            }
        }
        return user;
    }

    public String checkPassword(String password){
        String pass = password;
        while(pass.length() < 4){
            System.out.println("password should be at least 4 characters, try again");
            pass = input.nextLine();
        }
        return pass;
    }

    public User getUser(){
        return user;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public void setUserName(String userName){
        this.userName = checkUserName(userName);
    }

    public void setPassword(String password){
        this.password = checkPassword(password);
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String tString(){
        return "Admin{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", user=" + user +
                '}';
    }
}
