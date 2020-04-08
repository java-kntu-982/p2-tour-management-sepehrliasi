package ir.ac.kntu;
import java.nio.file.LinkPermission;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import ir.ac.kntu.maputil.MapUtil;
import net.sf.saxon.expr.Component;

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
        ArrayList<String> pl = new ArrayList<>();
        pl.add("KARAJ");
        pl.add("SHIRAZ");
        ArrayList<String> pl2 = new ArrayList<>();
        pl2.add("RASHT");
        pl2.add("TEHRAN");
        ArrayList<String> pl3 = new ArrayList<>();
        pl3.add("SHIRAZ");
        pl3.add("RASHT");
        ArrayList<String> pl4 = new ArrayList<>();
        pl4.add("KARAJ");
        pl4.add("TEHRAN");
        LeaderArray leaderArray = LeaderArray.getLeaderArray();
        Leader leader1 = new Leader("sepehr","ghaseminejad",110177,new Date(5, 5, 1397), new Date(21, 2, 1380), 2, pl);
        leaderArray.add(leader1);
        Leader leader2 = new Leader("Nima","Alizade",338,new Date(21, 1, 1390), new Date(13, 9, 1379), 2, pl2);
        leaderArray.add(leader2);
        Leader leader3 = new Leader("Ali","Maddahi",1177,new Date(13, 7, 1398), new Date(2, 11, 1365), 1, pl3);
        leaderArray.add(leader3);
        Leader leader4 = new Leader("Parsa","Shahbazi",177,new Date(19, 11, 1399), new Date(19, 1, 1376), 1, pl4);
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
        mainMenu();
//        Good for showing one location
//        MapUtil.showMap("Shiraz");
//        MapUtil.showMap("@29.6257966,52.5563165,17z");
//        Good for showing two locations
//        MapUtil.showMap("Tehran","Dubai");
    }

    public static void leaderMenu(){
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
                leaderMenu();
                break;
            case 2:
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
                Leader leader = new Leader(firstName, lastName, nationalCode, date1, date, marriage, pl);
                leaderArray.add(leader);
                leaderMenu();
                break;
            case 3:
                leaderArray.delete();
                leaderMenu();
                break;
            case 4:
                leaderArray.edit();
                leaderMenu();
                break;
            case 5:
                leaderArray.search();
                leaderMenu();
                break;
            case 6:
                mainMenu();
                break;
        }
    }

    public static void tourMenu(){
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
        System.out.println("7.return to main menu");
        TourArray tourArray = TourArray.getTourArray();
        int in = input.nextInt();
        in = inputValidation(in,1,7);
        switch(in){
            case 1:
                tourArray.showAll1();
                System.out.println("Press Enter to continue");
                input.nextLine();
                tourMenu();
                break;
            case 2:
                tourArray.showAll2();
                System.out.println("Press Enter to continue");
                input.nextLine();
                tourMenu();
                break;
            case 3:
                tourArray.add1();
                tourMenu();
                break;
            case 4:
                tourArray.add2();
                tourMenu();
                break;
            case 5:
                tourArray.delete1();
                tourMenu();
                break;
            case 6:
                tourArray.delete2();
                tourMenu();
                break;
            case 7:
                mainMenu();
                break;
        }
    }

    public static void placeMenu(){
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
                placeMenu();
                break;
            case 2:
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
                placeMenu();
                break;
            case 3:
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
                placeMenu();
                break;
            case 4:
                input.nextLine();
                string = input.nextLine();
                places.remove(string);
                placeMenu();
                break;
            case 5:
                mainMenu();
                break;
        }
    }

    public static void map(){
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
                    map();
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
                map();
                break;
            case 2:
                System.out.println("place name:");
                input.nextLine();
                String name = input.nextLine();
                MapUtil.showMap(name);
                map();
                break;
            case 3:
                System.out.println("origin:");
                input.nextLine();
                String name1 = input.nextLine();
                System.out.println("destination:");
                String name2 = input.nextLine();
                MapUtil.showMap(name1,name2);
                map();
                break;
            case 4:
                mainMenu();
                break;
        }
    }

    public static void exit(){
        clearScreen();
        System.out.println("\uD83D\uDC4B");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void mainMenu(){
        System.out.println("MAIN MENU");
        line();
        System.out.println("1. manage leaders");
        System.out.println("2. manage tours");
        System.out.println("3. manage places");
        System.out.println("4. map");
        System.out.println("5. exit");
        Scanner input = new Scanner(System.in);
        int in = input.nextInt();
        switch (in){
            case 1:
                leaderMenu();
                break;
            case 2:
                tourMenu();
                break;
            case 3:
                placeMenu();
                break;
            case 4:
                map();
                break;
            case 5:
                exit();
                break;
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