package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UsersArray {
    private ArrayList<Admin> users = new ArrayList<>();

    private  static UsersArray usersArray = new UsersArray();
    Scanner input = new Scanner(System.in);

    private UsersArray(){
    }

    public static UsersArray getUsersArray(){
        return usersArray;
    }

    public void add(Admin admin){
        users.add(admin);
    }

    public int getUser(User user){
        int t = 0;
        for(int i = 0;i < users.size();i++){
            if(users.get(i).getUser() == user){
                t++;
                System.out.println(t + "." + users.get(i).tString());
            }
        }
        return t;
    }

    public void remove(Admin admin){
        users.remove(admin);
    }

    public Admin getUsers(String userName){
        for (Admin user : users) {
            if (user.getUserName().equals(userName)) {
                return user;
            }
        }
        return users.get(1);
    }
}
