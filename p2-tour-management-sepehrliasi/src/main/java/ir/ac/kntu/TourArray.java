package ir.ac.kntu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TourArray {
    private ArrayList<Tour> tours = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    private  static TourArray tourArray = new TourArray();

    private TourArray(){
    }

    public static TourArray getTourArray(){
        return tourArray;
    }

    public void add(Tour tour){
        tours.add(tour);
    }

    public void search1(){
        System.out.println("1. by tour duration");
        System.out.println("2. by place");
        System.out.println("3. by number of participants");
        System.out.println("4. by price");
        System.out.println("5. back to tour menu");
        int in = input.nextInt();
        in = inputValidation(in,1,5);
        switch (in){
            case 1:
                System.out.println("enter a number for duration:");
                int duration = input.nextInt();
                duration = inputValidation(duration,1,14);
                int t = 0;
                line();
                for(Tour tour : tours){
                    if(tour.getDuration() == duration && tour.getType() == Type.TYPE){
                        t++;
                        System.out.println(t + "." + tour);
                    }
                }
                line();
                System.out.println("* " + t + "tours found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                search1();
                break;
            case 2:
                System.out.println("place name:");
                input.nextLine();
                String name = input.nextLine();
                t = 0;
                line();
                for(Tour tour : tours){
                    if(tour.getPlaces().containsValue(name) && tour.getType() == Type.TYPE){
                        t++;
                        System.out.println(t + "." + tour);
                    }
                }
                line();
                System.out.println("* " + t + "tours found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                search1();
                break;
            case 3:
                System.out.println("lower bound:");
                int least = input.nextInt();
                least = inputValidation(least,1,50);
                System.out.println("upper bound:");
                int most = input.nextInt();
                most = inputValidation(most,1,50);
                t = 0;
                line();
                for(Tour tour : tours){
                    if(tour.getLeastParticipants() > least && tour.getMostParticipants() < most){
                        if(tour.getType() == Type.TYPE) {
                            t++;
                            System.out.println(t + "." + tour);
                        }
                    }
                }
                line();
                System.out.println("* " + t + "tours found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                search1();
                break;
            case 4:
                System.out.println("1. special price");
                System.out.println("2. more than ...");
                System.out.println("3. less than ...");
                System.out.println("4. between ... and ...");
                int v = input.nextInt();
                v = inputValidation(v,1,4);
                switch(v){
                    case 1:
                        System.out.println("price to search");
                        in = input.nextInt();
                        t = 0;
                        line();
                        for(Tour tour : tours){
                            if(tour.getPrice() == in && tour.getType() == Type.TYPE){
                                t++;
                                System.out.println(t + "." + tour);
                            }
                        }
                        line();
                        System.out.println("* " + t + " tours found");
                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter a number:");
                        in = input.nextInt();
                        t = 0;
                        line();
                        for(Tour tour : tours){
                            if(tour.getPrice() > in && tour.getType() == Type.TYPE){
                                t++;
                                System.out.println(t + "." + tour);
                            }
                        }
                        line();
                        System.out.println("* " + t + " tours found");
                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();
                        break;
                    case 3:
                        System.out.println("Enter a number");
                        in = input.nextInt();
                        t = 0;
                        line();
                        for(Tour tour : tours){
                            if(tour.getPrice() < in && tour.getType() == Type.TYPE){
                                t++;
                                System.out.println(t + "." + tour);
                            }
                        }
                        line();
                        System.out.println("* " + t + " tours found");
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
                        for(Tour tour : tours){
                            if(tour.getPrice() >= in1 && tour.getPrice() <= in2){
                                if(tour.getType() == Type.TYPE) {
                                    t++;
                                    System.out.println(t + "." + tour);
                                }
                            }
                        }
                        line();
                        System.out.println("* " + t + " tours found");
                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();
                        break;
                }
            case 5:
                break;
        }
    }

    public void search2(){
        System.out.println("1. by tour duration");
        System.out.println("2. by place");
        System.out.println("3. by number of participants");
        System.out.println("4. by price");
        System.out.println("5. by leader name");
        System.out.println("6. back to tour menu");
        int in = input.nextInt();
        in = inputValidation(in,1,6);
        switch (in){
            case 1:
                System.out.println("enter a number for duration:");
                int duration = input.nextInt();
                duration = inputValidation(duration,1,14);
                int t = 0;
                line();
                for(Tour tour : tours){
                    if(tour.getDuration() == duration && tour.getType() == Type.PREPARED){
                        t++;
                        System.out.println(t + "." + tour);
                    }
                }
                line();
                System.out.println("* " + t + "tours found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                search1();
                break;
            case 2:
                System.out.println("place name:");
                input.nextLine();
                String name = input.nextLine();
                t = 0;
                line();
                for(Tour tour : tours){
                    if(tour.getPlaces().containsValue(name) && tour.getType() == Type.PREPARED){
                        t++;
                        System.out.println(t + "." + tour);
                    }
                }
                line();
                System.out.println("* " + t + "tours found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                search1();
                break;
            case 3:
                System.out.println("lower bound:");
                int least = input.nextInt();
                least = inputValidation(least,1,50);
                System.out.println("upper bound:");
                int most = input.nextInt();
                most = inputValidation(most,1,50);
                t = 0;
                line();
                for(Tour tour : tours){
                    if(tour.getLeastParticipants() > least && tour.getMostParticipants() < most){
                        if(tour.getType() == Type.PREPARED) {
                            t++;
                            System.out.println(t + "." + tour);
                        }
                    }
                }
                line();
                System.out.println("* " + t + "tours found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                search1();
                break;
            case 4:
                System.out.println("1. special price");
                System.out.println("2. more than ...");
                System.out.println("3. less than ...");
                System.out.println("4. between ... and ...");
                int v = input.nextInt();
                v = inputValidation(v,1,4);
                switch(v){
                    case 1:
                        System.out.println("price to search");
                        in = input.nextInt();
                        t = 0;
                        line();
                        for(Tour tour : tours){
                            if(tour.getPrice() == in && tour.getType() == Type.PREPARED){
                                t++;
                                System.out.println(t + "." + tour);
                            }
                        }
                        line();
                        System.out.println("* " + t + " tours found");
                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();
                        break;
                    case 2:
                        System.out.println("Enter a number:");
                        in = input.nextInt();
                        t = 0;
                        line();
                        for(Tour tour : tours){
                            if(tour.getPrice() > in && tour.getType() == Type.PREPARED){
                                t++;
                                System.out.println(t + "." + tour);
                            }
                        }
                        line();
                        System.out.println("* " + t + " tours found");
                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();
                        break;
                    case 3:
                        System.out.println("Enter a number");
                        in = input.nextInt();
                        t = 0;
                        line();
                        for(Tour tour : tours){
                            if(tour.getPrice() < in && tour.getType() == Type.PREPARED){
                                t++;
                                System.out.println(t + "." + tour);
                            }
                        }
                        line();
                        System.out.println("* " + t + " tours found");
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
                        for(Tour tour : tours){
                            if(tour.getPrice() >= in1 && tour.getPrice() <= in2){
                                if(tour.getType() == Type.PREPARED) {
                                    t++;
                                    System.out.println(t + "." + tour);
                                }
                            }
                        }
                        line();
                        System.out.println("* " + t + " tours found");
                        System.out.println("Press Enter to continue");
                        input.nextLine();
                        input.nextLine();
                        break;
                }
            case 5:
                System.out.println("first name:");
                input.nextLine();
                String name1 = input.nextLine();
                System.out.println("last name:");
                String name2 = input.nextLine();
                name1 = name1.toUpperCase();
                name2 = name2.toUpperCase();
                line();
                t = 0;
                for(Tour tour : tours){
                    if(tour.getLeader().getLastName().toUpperCase().compareTo(name2) == 0 && tour.getLeader().getFirstName().toUpperCase().compareTo(name1) == 0){
                        if(tour.getType() == Type.PREPARED){
                            t++;
                            System.out.println(t + "." + tour);
                        }
                    }
                }
                line();
                System.out.println("* " + t + " tours found");
                System.out.println("Press Enter to continue");
                input.nextLine();
                input.nextLine();
                search2();
                break;
            case 6:
                break;
        }
    }

    public void showAll1(){
        int t = 1;
        for(Tour tour : tours){
            if(tour.getType() == Type.TYPE){
                System.out.println(t + "." + tour);
                t++;
            }
        }
    }

    public void showAll2(){
        int t = 1;
        for(Tour tour : tours){
            if(tour.getType() == Type.PREPARED){
                System.out.println(t + "." + tour);
                t++;
            }
        }
    }

    public void add1(){
        Places places = Places.getPlaces();
        if(places.getSize() == 0){
            System.out.println("first define a place in place menu");
        }else {
            System.out.println("choose a place as origin:");
            places.showNumber();
            int in = input.nextInt();
            in = inputValidation(in, 1, places.getSize());
            String origin = places.getString(in);
            System.out.println("choose a place as destination:");
            in = input.nextInt();
            in = inputValidation(in, 1, places.getSize());
            String destination = places.getString(in);
            System.out.println("tripway: 1.air 2.earth");
            in = input.nextInt();
            int trip = inputValidation(in,1,2);
            TripWay tripWay;
            if(trip == 1){
                tripWay = TripWay.AIR;
            }else{
                tripWay = TripWay.EARTH;
            }
            System.out.println("how many days does it take?");
            int duration = input.nextInt();
            duration = inputValidation(duration,2,14);
            System.out.println("tour price:");
            int fee = input.nextInt();
            fee = inputValidation(fee,0,100000000);
            System.out.println("least possible participants:");
            int least = input.nextInt();
            least = inputValidation(least,1,50);
            System.out.println("most possible participants:");
            int most = input.nextInt();
            most = inputValidation(most,1,50);
            HashMap<Integer,String> place = new HashMap<>();
            int i = 1;
            while(i < duration){
                place.put(i,origin);
                i++;
            }
            place.put(duration,destination);
            System.out.println(place);
            System.out.println("choose a day in which location of tour changes, else press '0':");
            int d = input.nextInt();
            d = inputValidation(d,0,duration - 1);
            while(d > 0){
                System.out.println("location:");
                input.nextLine();
                String locatioan = input.nextLine();
                String pre = place.get(d);
                while(place.get(d).compareTo(pre) == 0 && d < duration){
                    place.put(d,locatioan);
                    d++;
                }
                System.out.println("choose a day in which location of tour changes, else press '0':");
                d = input.nextInt();
                d = inputValidation(d,0,duration - 1);
            }
            Tour tour = new Tour(duration,place,fee,least,most,origin,destination,tripWay);
            tours.add(tour);
            System.out.println(tour);
            System.out.println("tour '" + tour.getOrigin() + " to " + tour.getDestination() + "' is successfully added to tour list");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void add2(){
        LeaderArray leaderArray = LeaderArray.getLeaderArray();
        if(tours.size() == 0){
            System.out.println("first define a tour type");
        }else {
            System.out.println("choose tour type:");
            showAll1();
            int in = input.nextInt();
            in = inputValidation(in,1,tours.size());
            Tour tour = tours.get(in - 1);
            System.out.println("year of start:");
            int year = input.nextInt();
            System.out.println("month of start:");
            int month = input.nextInt();
            System.out.println("day of start:");
            int day = input.nextInt();
            Date start = new Date(day,month,year);
            if(leaderArray.check(tour.getDestination(),start,tour.getDuration())){
                System.out.println("choose one:");
                int w = input.nextInt();
                w = inputValidation(w,1,leaderArray.check2(tour.getDestination(),start,tour.getDuration()));
                Leader leader = leaderArray.take(tour.getDestination(),start,tour.getDuration(),w);
                System.out.println("choose a name:");
                input.nextLine();
                String name = input.nextLine();
                Tour tour1 = new Tour(start,name,leader,tour);
                tours.add(tour1);
                leader.setTour(tour1);
                System.out.println(tour1);
                System.out.println("successfully added");
            }else{
                System.out.println("no leader available");
            }
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete1(){
        if(typeSize() == 0){
            System.out.println("no tour to remove!");
        }else {
            showAll1();
            System.out.println("choose one to remove:");
            int in = input.nextInt();
            in = inputValidation(in, 1, typeSize());
            tours.remove(getIn1(in));
            System.out.println("Successfully removed");
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void delete2(){
        if(preparedSize() == 0){
            System.out.println("no tour to remove!");
        }else {
            showAll2();
            System.out.println("choose one to remove:");
            int in = input.nextInt();
            in = inputValidation(in, 1, preparedSize());
            tours.remove(getIn2(in));
            System.out.println("Successfully removed");
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Tour getIn1(int w){
        int t = 0;
        for(Tour tour : tours){
            if(tour.getType() == Type.TYPE){
                t++;
            }
            if(t == w){
                return tour;
            }
        }
        return tours.get(0);
    }

    public Tour getIn2(int w){
        int t = 0;
        for(Tour tour : tours){
            if(tour.getType() == Type.PREPARED){
                t++;
            }
            if(t == w){
                return tour;
            }
        }
        return tours.get(0);
    }

    public int typeSize(){
        int t = 0;
        for(Tour tour : tours){
            if(tour.getType() == Type.TYPE){
                t++;
            }
        }
        return t;
    }

    public int preparedSize(){
        int t = 0;
        for(Tour tour : tours){
            if(tour.getType() == Type.PREPARED){
                t++;
            }
        }
        return t;
    }

    public int inputValidation(int in,int first, int last){
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