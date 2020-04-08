package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class LeaderArray {
    private ArrayList<Leader> leaders = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    private  static LeaderArray leaderArray = new LeaderArray();

    private LeaderArray(){
    }

    public static LeaderArray getLeaderArray(){
        return leaderArray;
    }

    public void showAll(){
        System.out.println(leaders);
        System.out.println("Press Enter to continue");
        input.nextLine();
    }

    public void showNumber(){
        for(int i = 0;i < leaders.size();i++){
            System.out.println(i+1 + "." + leaders.get(i));
        }
    }

    public boolean check(String place, Date start,int duration){
        int t = 0;
        for(Leader leader : leaders){
            if(leader.getPlaces().contains(place)) {
                if (leader.getTour() == null) {
                    t++;
                    System.out.println(t + "." + leader);
                } else {
                    if (leader.getTour().getStart().compare(start) > leader.getTour().getDuration() || (-(leader.getTour().getStart().compare(start))) > duration) {
                        t++;
                        System.out.println(t + "." + leader);
                    }
                }
            }
        }
        return t > 0;
    }

    public int check2(String place, Date start,int duration){
        int t = 0;
        for(Leader leader : leaders){
            if(leader.getPlaces().contains(place)){
                if(leader.getTour() == null){
                    t++;
                }else{
                    if(leader.getTour().getStart().compare(start) > leader.getTour().getDuration() || (-(leader.getTour().getStart().compare(start))) > duration){
                        t++;
                    }
                }
            }
        }
        return t;
    }

    public Leader take(String place, Date start,int duration, int w){
        int t = 0;
        for(Leader leader : leaders){
            if(leader.getPlaces().contains(place)){
                if(leader.getTour() == null){
                    t++;
                }else{
                    if(leader.getTour().getStart().compare(start) > leader.getTour().getDuration() || (-(leader.getTour().getStart().compare(start))) > duration){
                        t++;
                    }
                }
            }
            if(t == w){
                return leader;
            }
        }
        return leaders.get(0);
    }

    public void delete(){
        System.out.println("choose one to delete, else enter '0':");
        showNumber();
        int in = input.nextInt();
        in = inputValidation(in,0,leaders.size());
        if(in > 0){
            System.out.println("'" + leaders.get(in - 1).getFirstName() + " " + leaders.get(in - 1).getLastName() + "'" + " Successfully removed from leader list");
            leaders.remove(in - 1);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void add(Leader leader){
        leaders.add(leader);
        System.out.println("leader '" + leader.getFirstName() + " " + leader.getLastName() + "' is successfully added to leader list");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void edit(){
        System.out.println("choose leader to edit, else enter '0':");
        showNumber();
        int in = input.nextInt();
        in = inputValidation(in,0,leaders.size());
        Leader leader = leaders.get(in - 1);
        System.out.println(leader);
        System.out.println("press 1 to edit first name, else press 2");
        in = input.nextInt();
        in = inputValidation(in,1,2);
        if(in == 1){
            System.out.println("write a new first name:");
            input.nextLine();
            String string = input.nextLine();
            leader.setFirstName(string);
        }
        System.out.println("press 1 to edit last name, else press 2");
        in = input.nextInt();
        in = inputValidation(in,1,2);
        if(in == 1){
            System.out.println("write a new last name:");
            input.nextLine();
            String string = input.nextLine();
            leader.setLastName(string);
        }
        System.out.println("press 1 to edit national code, else press 2");
        in = input.nextInt();
        in = inputValidation(in,1,2);
        if(in == 1){
            System.out.println("write a new national code:");
            long num = input.nextLong();
            leader.setNationalCode(num);
        }
        System.out.println("press 1 to edit employment date, else press 2");
        in = input.nextInt();
        in = inputValidation(in,1,2);
        if(in == 1){
            System.out.println("leader's year of employment:");
            int year = input.nextInt();
            System.out.println("leader's month of employment:");
            int month = input.nextInt();
            System.out.println("leader's day of employment:");
            int day = input.nextInt();
            leader.setEmployment(new Date(day,month,year));
        }
        System.out.println("press 1 to edit birth date, else press 2");
        in = input.nextInt();
        in = inputValidation(in,1,2);
        if(in == 1){
            System.out.println("leader's year of birth:");
            int year = input.nextInt();
            System.out.println("leader's month of birth:");
            int month = input.nextInt();
            System.out.println("leader's day of birth:");
            int day = input.nextInt();
            leader.setBirthday(new Date(day,month,year));
        }
        System.out.println("press 1 to edit marriage, else press 2");
        in = input.nextInt();
        in = inputValidation(in,1,2);
        if(in == 1){
            System.out.println("Press: 1.married 2.single");
            int marriage = input.nextInt();
            if((marriage != 1) && (marriage != 2)) {
                while ((marriage != 1) && (marriage != 2)) {
                    System.out.println("invalid input, Press: 1.married 2.single");
                    marriage = input.nextInt();
                }
            }
            leader.setMarriage(marriage);
        }
        System.out.println("press 1 to edit places, else press 2");
        in = input.nextInt();
        in = inputValidation(in,1,2);
        if(in == 1){
            System.out.println("press 1 to add or 2 to remove a place:");
            int place = input.nextInt();
            place = inputValidation(place,1,2);
            if(place == 1){
                addPlace(leader);
            }else{
                if(leader.getSize() > 0) {
                    removePlace(leader);
                }else{
                    System.out.println("no place exists");
                }
            }
            System.out.println("successfully edited");
            System.out.println("press 1 to edit places, else press 2");
            in = input.nextInt();
            in = inputValidation(in,1,2);
            while(in == 1){
                System.out.println("press 1 to add or 2 to remove a place:");
                place = input.nextInt();
                place = inputValidation(place,1,2);
                if(place == 1){
                    addPlace(leader);
                }else{
                    if(leader.getSize() > 0) {
                        removePlace(leader);
                    }else{
                        System.out.println("no place exists");
                    }
                }
                System.out.println("successfully edited");
                System.out.println("press 1 to edit places, else press 2");
                in = input.nextInt();
                in = inputValidation(in,1,2);
            }
        }
        System.out.println("leader edited successfully");
        System.out.println(leader.toString());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void search(){
        System.out.println("choose search method:");
        System.out.println("1. search by first name");
        System.out.println("2. search by last name");
        System.out.println("3. search by places");
        System.out.println("4. search by age");
        System.out.println("5. back to leader menu");
        int in = input.nextInt();
        in = inputValidation(in,1,5);
        switch (in){
            case 1:
                searchFirstName();
                search();
                break;
            case 2:
                searchLastName();
                search();
                break;
            case 3:
                searchPlace();
                search();
                break;
            case 4:
                searchAge();
                search();
                break;
            case 5:
                break;
        }
    }

    public void searchFirstName(){
        System.out.println("type a name to search:");
        input.nextLine();
        String name = input.nextLine();
        name = name.toUpperCase();
        int t = 0;
        line();
        for (Leader leader : leaders) {
            if (leader.getFirstName().toUpperCase().compareTo(name) == 0) {
                t++;
                System.out.println(t + "." + leader);
            }
        }
        line();
        System.out.println("* " + t + " leaders found");
        System.out.println("Press enter to continue");
        input.nextLine();
    }

    public void searchLastName(){
        System.out.println("type a name to search:");
        input.nextLine();
        String name = input.nextLine();
        name = name.toUpperCase();
        int t = 0;
        line();
        for (Leader leader : leaders) {
            if (leader.getLastName().toUpperCase().compareTo(name) == 0) {
                t++;
                System.out.println(t + "." + leader);
            }
        }
        line();
        System.out.println("* " + t + " leaders found");
        System.out.println("Press enter to continue");
        input.nextLine();
    }

    public void searchPlace(){
        System.out.println("choose a place to search:");
        Places places = Places.getPlaces();
        if(places.getSize() == 0){
            System.out.println("there is no place to search");
        }else {
            places.showNumber();
            int in = input.nextInt();
            in = inputValidation(in, 1, places.getSize());
            String place = places.getString(in);
            int t = 0;
            line();
            for(Leader leader : leaders){
                if(leader.getPlaces().contains(place)){
                    t++;
                    System.out.println(t + "." + leader);
                }
            }
            line();
            System.out.println("* " + t + " leaders found");
            System.out.println("Press enter to continue");
            input.nextLine();
            input.nextLine();
        }
    }

    public void searchAge(){
        System.out.println("1. special age");
        System.out.println("2. more than ...");
        System.out.println("3. less than ...");
        System.out.println("4. between ... and ...");
        int in = input.nextInt();
        in = inputValidation(in,1,4);
        switch(in){
            case 1:
                System.out.println("age to search");
                in = input.nextInt();
                int t = 0;
                line();
                for(Leader leader : leaders){
                    if(leader.getAge() == in){
                        t++;
                        System.out.println(t + "." + leader);
                    }
                }
                line();
                System.out.println("* " + t + " leaders found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                input.nextLine();
                break;
            case 2:
                System.out.println("Enter a number");
                in = input.nextInt();
                t = 0;
                line();
                for(Leader leader : leaders){
                    if(leader.getAge() > in){
                        t++;
                        System.out.println(t + "." + leader);
                    }
                }
                line();
                System.out.println("* " + t + " leaders found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                input.nextLine();
                break;
            case 3:
                System.out.println("Enter a number");
                in = input.nextInt();
                t = 0;
                line();
                for(Leader leader : leaders){
                    if(leader.getAge() < in){
                        t++;
                        System.out.println(t + "." + leader);
                    }
                }
                line();
                System.out.println("* " + t + " leaders found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                input.nextLine();
                break;
            case 4:
                System.out.println("lower bound:");
                int in1 = input.nextInt();
                System.out.println("upper bound:");
                int in2 = input.nextInt();
                t = 0;
                line();
                for(Leader leader : leaders){
                    if(leader.getAge() >= in1 && leader.getAge() <= in2){
                        t++;
                        System.out.println(t + "." + leader);
                    }
                }
                line();
                System.out.println("* " + t + " leaders found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                input.nextLine();
                break;
        }
    }

    public int inputValidation(int in,int first, int last){
        while((in > last) || (in < first)){
            System.out.println("invalid input, let's try again " + first + " <= x <= " + last);
            in = input.nextInt();
        }
        return in;
    }

    public void addPlace(Leader leader){
        Places places = Places.getPlaces();
        System.out.println("choose one to add:");
        places.showNumber();
        int in = input.nextInt();
        in = inputValidation(in,1,places.getSize());
        if(!leader.getPlaces().contains(places.getArray(in - 1))) {
            leader.addPlace(places.getArray(in - 1));
        }
    }

    public void removePlace(Leader leader){
        System.out.println("choose one to remove:");
        leader.showNumber();
        int in = input.nextInt();
        in = inputValidation(in,1,leader.getSize());
        leader.removePlace(leader.getPlace(in - 1));
    }

    public static void line(){
        System.out.print("--------------------\n");
    }
}