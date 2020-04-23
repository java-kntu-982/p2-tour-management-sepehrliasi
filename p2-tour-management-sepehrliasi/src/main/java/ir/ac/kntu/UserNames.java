package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;

public class UserNames {
    private ArrayList<String> users = new ArrayList<>();

    private  static UserNames userNames = new UserNames();
    Scanner input = new Scanner(System.in);

    private UserNames(){
    }

    public static UserNames getUserNames(){
        return userNames;
    }

    void addUserName(String user){
        users.add(user);
    }

    void removeUserName(String user){
        users.remove(user);
    }

    public ArrayList<String> getUsers(){
        return users;
    }


}
