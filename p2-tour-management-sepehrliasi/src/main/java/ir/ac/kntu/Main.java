package ir.ac.kntu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import ir.ac.kntu.maputil.MapUtil;
import org.checkerframework.checker.units.qual.A;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Places place = Places.getPlaces();
        System.out.println("please wait to add 12 examples");
        place.add(("shiraz"));
        place.add(("tehran"));
        place.add(("rasht"));
        place.add(("karaj"));
        place.add("TURKEY");
        ArrayList<String> pl = new ArrayList<>();
        pl.add("KARAJ");
        pl.add("SHIRAZ");
        ArrayList<String> pl2 = new ArrayList<>();
        pl2.add("RASHT");
        pl2.add("TURKEY");
        ArrayList<String> pl3 = new ArrayList<>();
        pl3.add("SHIRAZ");
        pl3.add("RASHT");
        ArrayList<String> pl4 = new ArrayList<>();
        pl4.add("KARAJ");
        pl4.add("TEHRAN");
        LeaderArray leaderArray = LeaderArray.getLeaderArray();
        Leader leader1 = new Leader("sepehr","ghaseminejad",110177,new Date(5, 5, 1397), new Date(21, 2, 1380), 2, pl,"1111","1111","sep@gmail.com",11111,User.LEADER);
        leaderArray.add(leader1);
        Leader leader2 = new Leader("Nima","Alizade",338,new Date(21, 1, 1390), new Date(13, 9, 1379), 2, pl2,"2222","2222","nima@gmail.com",22,User.LEADER);
        leaderArray.add(leader2);
        Leader leader3 = new Leader("Ali","Maddahi",1177,new Date(13, 7, 1398), new Date(2, 11, 1365), 1, pl3,"3333","2222","ali@gmail.com",33,User.LEADER);
        leaderArray.add(leader3);
        Leader leader4 = new Leader("Parsa","Shahbazi",177,new Date(19, 11, 1399), new Date(19, 1, 1376), 1, pl4,"4444","2222","parsa@gmail.com",44,User.LEADER);
        leaderArray.add(leader4);
        HashMap<Integer,String> map = new HashMap<>();
        int i = 1;
        int duration = 4;
        String origin = "karaj";
        String destination = "tehran";
        while(i < duration){
            map.put(i,origin);
            i++;
        }
        map.put(duration,destination);
        map.put(3,"nature bridge");
        Tour tour = new Tour(12,map,100000,1,8,"KARAJ","TEHRAN",TripWay.EARTH);
        TourArray tourArray = TourArray.getTourArray();
        tourArray.add(tour);
        HashMap<Integer,String> map1 = new HashMap<>();
        i = 1;
        int duration1 = 7;
        String origin1 = "TEHRAN";
        String destination1 = "TURKEY";
        while(i < duration1){
            map1.put(i,origin1);
            i++;
        }
        map1.put(duration1,destination1);
        map1.put(3,"Istanbul");
        map1.put(4,"Istanbul");
        map1.put(2,"Istanbul");
        map1.put(5,"Ankara");
        map1.put(6,"Ankara");
        Tour tour1 = new Tour(duration1,map1,2000000,10,30,origin1,destination1,TripWay.AIR);
        tourArray.add(tour1);
        UsersArray usersArray = UsersArray.getUsersArray();
        UserNames userNames = UserNames.getUserNames();
        Admin admin = new Admin("admin","admin","sepehr@gmail.com",910680799,User.ADMIN);
        usersArray.add(admin);
        usersArray.add(leader1);
        usersArray.add(leader2);
        usersArray.add(leader3);
        usersArray.add(leader4);
        String userName = signIn();
        Admin myUser = usersArray.getUsers(userName);
        mainMenu(myUser);
    }


    public static String signIn(){
        Scanner input = new Scanner(System.in);
        UserNames userNames = UserNames.getUserNames();
        UsersArray usersArray = UsersArray.getUsersArray();
        System.out.println("username:");
        String user = input.nextLine();
        while(!userNames.getUsers().contains(user)){
            System.out.println("invalid!, try again");
            user = input.nextLine();
        }
        Admin admin = usersArray.getUsers(user);
        System.out.println("password:");
        String password = input.nextLine();
        while(!admin.getPassword().equals(password)){
            System.out.println("wrong password!, try again");
            password = input.nextLine();
        }
        return user;
    }

    public static void leaderMenu(Admin admin){
        Scanner input = new Scanner(System.in);
        clearScreen();
        System.out.println("LEADER MENU");
        line();
        System.out.println("1.show all defined leaders");
        System.out.println("2.define a leader");
        System.out.println("3.delete a leader");
        System.out.println("4.edit a leader");
        System.out.println("5.search a leader");
        System.out.println("6.return to main menu");
        LeaderArray leaderArray = LeaderArray.getLeaderArray();
        int in = input.nextInt();
        in = inputValidation(in,1,6);
        switch (in){
            case 1:
                leaderArray.showAll();
                leaderMenu(admin);
                break;
            case 2:
                if(admin.getUser() != User.ADMIN){
                    System.out.println("you're not allowed to use this part");
                    leaderMenu(admin);
                    break;
                }
                System.out.println("leader's firstname:");
                input.nextLine();
                String firstName = input.nextLine();
                System.out.println("leader's lastname:");
                String lastName = input.nextLine();
                System.out.println("leader's national code:");
                long nationalCode = input.nextLong();
                System.out.println("leader's year of birth:");
                int year = input.nextInt();
                System.out.println("leader's month of birth:");
                int month = input.nextInt();
                System.out.println("leader's day of birth:");
                int day = input.nextInt();
                Date date = new Date(year,month,day);
                System.out.println("leader's year of employment:");
                int year1 = input.nextInt();
                System.out.println("leader's month of employment:");
                int month1 = input.nextInt();
                System.out.println("leader's day of employment:");
                int day1 = input.nextInt();
                Date date1 = new Date(year1,month1,day1);
                System.out.println("Press: 1.married 2.single");
                int marriage = input.nextInt();
                if((marriage != 1) && (marriage != 2)) {
                    while ((marriage != 1) && (marriage != 2)) {
                        System.out.println("invalid input, Press: 1.married 2.single");
                        marriage = input.nextInt();
                    }
                }
                System.out.println("choose your desired place number,else choose 0:");
                Places places = Places.getPlaces();
                ArrayList<String> pl = new ArrayList<>();
                places.showNumber();
                in = input.nextInt();
                in = inputValidation(in,0, places.getSize());
                while(in > 0){
                    pl.add(places.getString(in));
                    System.out.println("choose your desired place number,else choose 0:");
                    in = input.nextInt();
                }
                System.out.println("email:");
                String email = input.nextLine();
                System.out.println("phone number:");
                long phone = input.nextLong();
                UserNames userNames = UserNames.getUserNames();
                System.out.println("username:");
                String user1 = input.nextLine();
                while(userNames.getUsers().contains(user1)){
                    System.out.println("it is taken before, please try again:");
                    user1 = input.nextLine();
                }
                System.out.println("password:");
                String pass1 = input.nextLine();
                Leader leader = new Leader(firstName, lastName, nationalCode, date1, date, marriage, pl,user1,pass1,email,phone,User.LEADER);
                leaderArray.add(leader);
                leaderMenu(admin);
                break;
            case 3:
                if(admin.getUser() != User.ADMIN){
                    System.out.println("you're not allowed to use this part");
                    leaderMenu(admin);
                    break;
                }
                leaderArray.delete();
                leaderMenu(admin);
                break;
            case 4:
                if(admin.getUser() != User.ADMIN){
                    System.out.println("you're not allowed to use this part");
                    leaderMenu(admin);
                    break;
                }
                leaderArray.edit();
                leaderMenu(admin);
                break;
            case 5:
                leaderArray.search();
                leaderMenu(admin);
                break;
            case 6:
                mainMenu(admin);
                break;
        }
    }

    public static void tourMenu(Admin admin){
        Scanner input = new Scanner(System.in);
        clearScreen();
        System.out.println("TOUR MENU");
        line();
        System.out.println("1.show all defined tour types");
        System.out.println("2.show all prepared tours");
        System.out.println("3.define a tour type");
        System.out.println("4.prepare a tour");
        System.out.println("5.delete a tour type");
        System.out.println("6.delete a prepared tour");
        System.out.println("7.search a tour type");
        System.out.println("8.search a prepared tour");
        System.out.println("9.return to main menu");
        TourArray tourArray = TourArray.getTourArray();
        int in = input.nextInt();
        in = inputValidation(in,1,9);
        switch(in){
            case 1:
                tourArray.showAll1();
                System.out.println("Press Enter to continue");
                input.nextLine();
                tourMenu(admin);
                break;
            case 2:
                tourArray.showAll2();
                System.out.println("Press Enter to continue");
                input.nextLine();
                tourMenu(admin);
                break;
            case 3:
                if(admin.getUser() != User.ADMIN){
                    System.out.println("you're not allowed to use this part");
                    tourMenu(admin);
                    break;
                }
                tourArray.add1();
                tourMenu(admin);
                break;
            case 4:
                if(admin.getUser() == User.CUSTOMER || admin.getUser() == User.LEADER){
                    System.out.println("you're not allowed to use this part");
                    tourMenu(admin);
                    break;
                }
                tourArray.add2();
                tourMenu(admin);
                break;
            case 5:
                if(admin.getUser() != User.ADMIN){
                    System.out.println("you're not allowed to use this part");
                    tourMenu(admin);
                    break;
                }
                tourArray.delete1();
                tourMenu(admin);
                break;
            case 6:
                if(admin.getUser() == User.CUSTOMER || admin.getUser() == User.LEADER){
                    System.out.println("you're not allowed to use this part");
                    tourMenu(admin);
                    break;
                }
                tourArray.delete2();
                tourMenu(admin);
                break;
            case 7:
                tourArray.search1();
                tourMenu(admin);
                break;
            case 8:
                tourArray.search2();
                tourMenu(admin);
                break;
            case 9:
                mainMenu(admin);
                break;
        }
    }

    public static void placeMenu(Admin admin){
        Scanner input = new Scanner(System.in);
        clearScreen();
        System.out.println("PLACE MENU");
        line();
        System.out.println("1.show all defined places");
        System.out.println("2.define a place");
        System.out.println("3.edit a place");
        System.out.println("4.delete a place");
        System.out.println("5.return to main menu");
        Places places = Places.getPlaces();
        int in = input.nextInt();
        in = inputValidation(in,1,5);
        switch (in){
            case 1:
                places.showAll();
                placeMenu(admin);
                break;
            case 2:
                if(admin.getUser() != User.ADMIN){
                    System.out.println("you're not allowed to use this part");
                    placeMenu(admin);
                    break;
                }
                System.out.println("place name:");
                input.nextLine();
                String string = input.nextLine();
                places.add(string);
                System.out.println("if you want to add more press 1 else press 2:");
                in = input.nextInt();
                while(in == 1){
                    System.out.println("place name:");
                    input.nextLine();
                    string = input.nextLine();
                    places.add(string);
                    System.out.println("if you want to add more press 1 else press 2:");
                    in = input.nextInt();
                }
                placeMenu(admin);
                break;
            case 3:
                if(admin.getUser() != User.ADMIN){
                    System.out.println("you're not allowed to use this part");
                    placeMenu(admin);
                    break;
                }
                input.nextLine();
                String string1 = input.nextLine();
                string1 = string1.toUpperCase();
                if(places.isString(string1)) {
                    String string2 = input.nextLine();
                    string2 = string2.toUpperCase();
                    if(!places.isString(string2)) {
                        places.edit(string1, string2);
                    }
                }else{
                    System.out.println("Sorry, there is no city called <" + string1 + ">in System");
                }
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                placeMenu(admin);
                break;
            case 4:
                if(admin.getUser() != User.ADMIN){
                    System.out.println("you're not allowed to use this part");
                    placeMenu(admin);
                    break;
                }
                input.nextLine();
                string = input.nextLine();
                places.remove(string);
                placeMenu(admin);
                break;
            case 5:
                mainMenu(admin);
                break;
        }
    }

    public static void map(Admin admin){
        TourArray tourArray = TourArray.getTourArray();
        Scanner input = new Scanner(System.in);
        clearScreen();
        System.out.println("MAP");
        line();
        System.out.println("1. show a tour detail");
        System.out.println("2. show a place");
        System.out.println("3. show two places");
        System.out.println("4. return to main menu");
        int in = input.nextInt();
        in = inputValidation(in,1,4);
        switch (in){
            case 1:
                if(tourArray.preparedSize() == 0){
                    System.out.println("no tours to show!");
                    map(admin);
                }
                System.out.println("choose a tour:");
                tourArray.showAll2();
                int i = input.nextInt();
                i = inputValidation(i,1,tourArray.preparedSize());
                Tour tour = tourArray.getIn2(i);
                System.out.println("1. show origin");
                System.out.println("2. show destination");
                System.out.println("3. show origin and destination");
                System.out.println("4. show tour's places");
                System.out.println("5. show tour at a special place");
                int k = input.nextInt();
                k = inputValidation(k,1,5);
                switch (k){
                    case 1:
                        MapUtil.showMap(tour.getOrigin());
                        break;
                    case 2:
                        MapUtil.showMap(tour.getDestination());
                        break;
                    case 3:
                        MapUtil.showMap(tour.getOrigin(),tour.getDestination());
                        break;
                    case 4:
                        for(int n = 1;n < tour.getDuration();n++) {
                            MapUtil.showMap(tour.getPlaces().get(n));
                            System.out.println(tour.getPlaces().get(n));
                        }
                        break;
                    case 5:
                        System.out.println("year:");
                        int y = input.nextInt();
                        System.out.println("month:");
                        int m = input.nextInt();
                        System.out.println("day:");
                        int d = input.nextInt();
                        Date c = new Date(d,m,y);
                        if(tour.getStart().compare(c) > tour.getDuration()){
                            MapUtil.showMap(tour.getDestination());
                        }else if(tour.getStart().compare(c) < 1){
                            MapUtil.showMap(tour.getOrigin());
                        }else{
                            MapUtil.showMap(tour.getPlaces().get(tour.getStart().compare(c)));
                        }
                        break;
                }
                map(admin);
                break;
            case 2:
                System.out.println("place name:");
                input.nextLine();
                String name = input.nextLine();
                MapUtil.showMap(name);
                map(admin);
                break;
            case 3:
                System.out.println("origin:");
                input.nextLine();
                String name1 = input.nextLine();
                System.out.println("destination:");
                String name2 = input.nextLine();
                MapUtil.showMap(name1,name2);
                map(admin);
                break;
            case 4:
                mainMenu(admin);
                break;
        }
    }

//    public static void exit(){
//        clearScreen();
//        System.out.println("\uD83D\uDC4B");
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    public static void mainMenu(Admin admin){
        UsersArray usersArray = UsersArray.getUsersArray();
        UserNames userNames = UserNames.getUserNames();
        System.out.println("MAIN MENU");
        line();
        System.out.println("1. manage leaders");
        System.out.println("2. manage tours");
        System.out.println("3. manage places");
        System.out.println("4. map");
        System.out.println("5. manage users");
        System.out.println("6. profiles");
        System.out.println("7. add users");
        System.out.println("8. remove users");
        System.out.println("9. sign out");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        in = inputValidation(in,1,7);
        switch (in){
            case 1:
                leaderMenu(admin);
                break;
            case 2:
                tourMenu(admin);
                break;
            case 3:
                placeMenu(admin);
                break;
            case 4:
                map(admin);
                break;
            case 6:
                System.out.println("profiles");
                line();
                System.out.println(admin.tString());
                System.out.println("1. edit my profile");
                System.out.println("2. edit leaders");
                System.out.println("3. edit customers");
                System.out.println("4. edit employees");
                int p = input.nextInt();
                p = inputValidation(p,1,4);
                switch (p){
                    case 1:
                        editProfile(admin);
                        mainMenu(admin);
                        break;
                    case 2:
                        if(admin.getUser() != User.ADMIN){
                            System.out.println("you're not allowed to use this part");
                            mainMenu(admin);
                            break;
                        }
                        if(usersArray.getUser(User.LEADER) > 0){
                            System.out.println("username:");
                            String user = input.nextLine();
                            user = admin.checkUserName(user);
                            while(usersArray.getUsers(user).getUser() != User.LEADER){
                                System.out.println("please choose a leader:");
                                user = input.nextLine();
                                user = admin.checkUserName(user);
                            }
                            Leader leader = (Leader) usersArray.getUsers(user);
                            editProfile(leader);
                        }else{
                            System.out.println("no leaders found");
                            mainMenu(admin);
                        }
                        break;
                    case 3:
                        if(admin.getUser() == User.CUSTOMER || admin.getUser() == User.LEADER){
                            System.out.println("you're not allowed to use this part");
                            mainMenu(admin);
                            break;
                        }
                        if(usersArray.getUser(User.CUSTOMER) > 0){
                            System.out.println("username:");
                            String user = input.nextLine();
                            user = admin.checkUserName(user);
                            while(usersArray.getUsers(user).getUser() != User.CUSTOMER){
                                System.out.println("please choose a customer:");
                                user = input.nextLine();
                                user = admin.checkUserName(user);
                            }
                            Customer customer = (Customer) usersArray.getUsers(user);
                            editProfile(customer);
                        }else{
                            System.out.println("no customers found");
                            mainMenu(admin);
                        }
                        break;
                    case 4:
                        if(admin.getUser() != User.ADMIN){
                            System.out.println("you're not allowed to use this part");
                            mainMenu(admin);
                            break;
                        }
                        if(usersArray.getUser(User.EMPLOYEE) > 0){
                            System.out.println("username:");
                            String user = input.nextLine();
                            user = admin.checkUserName(user);
                            while(usersArray.getUsers(user).getUser() != User.EMPLOYEE){
                                System.out.println("please choose a employee:");
                                user = input.nextLine();
                                user = admin.checkUserName(user);
                            }
                            Employee employee = (Employee) usersArray.getUsers(user);
                            editProfile(employee);
                        }else{
                            System.out.println("no employee found");
                            mainMenu(admin);
                        }
                        break;
                }
                mainMenu(admin);
                break;
            case 7:
                if(admin.getUser() == User.CUSTOMER){
                    System.out.println("you're not allowed to use this part");
                    mainMenu(admin);
                    break;
                }
                System.out.println("1. add employee");
                System.out.println("2. add customer");
                int i = input.nextInt();
                i = inputValidation(i,1,2);
                switch (i){
                    case 1:
                        if(admin.getUser() != User.ADMIN){
                            System.out.println("you're not allowed to use this part");
                            mainMenu(admin);
                            break;
                        }
                        System.out.println("email:");
                        String email = input.nextLine();
                        System.out.println("phone number:");
                        long phone = input.nextLong();
                        System.out.println("username:");
                        String user1 = input.nextLine();
                        while(userNames.getUsers().contains(user1)){
                            System.out.println("it is taken before, please try again:");
                            user1 = input.nextLine();
                        }
                        System.out.println("password:");
                        String pass1 = input.nextLine();
                        Employee employee = new Employee(user1,pass1,email,phone,new Date(4,2,1399),300000,User.EMPLOYEE);
                        userNames.addUserName(user1);
                        usersArray.add(employee);
                        mainMenu(admin);
                        break;
                    case 2:
                        System.out.println("email:");
                        email = input.nextLine();
                        System.out.println("phone number:");
                        phone = input.nextLong();
                        System.out.println("username:");
                        user1 = input.nextLine();
                        while(userNames.getUsers().contains(user1)){
                            System.out.println("it is taken before, please try again:");
                            user1 = input.nextLine();
                        }
                        System.out.println("password:");
                        pass1 = input.nextLine();
                        Customer customer = new Customer(user1,pass1,email,phone,User.CUSTOMER);
                        usersArray.add(customer);
                        userNames.addUserName(user1);
                        mainMenu(admin);
                        break;
                }
            case 8:
                if(admin.getUser() == User.CUSTOMER || admin.getUser() == User.LEADER){
                    System.out.println("you're not allowed to use this part");
                    mainMenu(admin);
                    break;
                }
            case 9:
                String user = signIn();
                Admin myUser = usersArray.getUsers(user);
                mainMenu(myUser);
                break;
        }
    }

    public static void editProfile(Admin admin){
        Scanner input = new Scanner(System.in);
        UserNames userNames = UserNames.getUserNames();
        System.out.println(admin.tString());
        System.out.println("1. edit username");
        System.out.println("2. edit password");
        System.out.println("3. edit email");
        System.out.println("4. edit phone");
        int p = input.nextInt();
        p = inputValidation(p, 1, 4);
        switch (p) {
            case 1:
                userNames.removeUserName(admin.getUserName());
                System.out.println("new username:");
                input.nextLine();
                String userName = input.nextLine();
                admin.setUserName(userName);
                userNames.addUserName(admin.getUserName());
                break;
            case 2:
                System.out.println("new password:");
                String password = input.nextLine();
                admin.setPassword(password);
                break;
            case 3:
                System.out.println("new email:");
                String email = input.nextLine();
                admin.setEmail(email);
                break;
            case 4:
                System.out.println("new phone:");
                long phone = input.nextLong();
                admin.setPhoneNumber(phone);
                break;
        }
        System.out.println("successfully edited");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static int inputValidation(int in,int first, int last){
        Scanner input = new Scanner(System.in);
        while((in > last) || (in < first)){
            System.out.println("invalid input, let's try again " + first + " <= x <= " + last);
            in = input.nextInt();
        }
        return in;
    }

    public static void line(){
        System.out.print("--------------------\n");
    }
}