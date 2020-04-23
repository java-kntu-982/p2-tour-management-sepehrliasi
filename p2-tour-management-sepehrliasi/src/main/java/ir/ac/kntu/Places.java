package ir.ac.kntu;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

public class Places {
    private ArrayList<String> places = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    private static Places place = new Places();

    private Places(){
    }

    public static Places getPlaces(){
        return place;
    }

    public void add(String string){
        string = string.toUpperCase();
        if(!places.contains(string)) {
            places.add(string);
            System.out.println(string + " is successfully added to places");
        }else{
            System.out.println(string + " was already defined");
        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showAll(){
        System.out.println(places);
        System.out.println("Press Enter to continue");
        input.nextLine();
    }

    public void showNumber(){
        for(int i = 0;i < places.size();i++){
            System.out.println(i+1 + "." + places.get(i));
        }
    }

    public String getString(int i){
        return places.get(i-1);
    }

    public boolean isString(String string){
        return places.contains(string);
    }

    public void edit(String string1, String string2){
        int index = places.indexOf(string1);
        places.set(index, string2);
        System.out.println(string1 + " is successfully changed to " + string2);
    }

    public void remove(String string){
        string = string.toUpperCase();
        if(places.contains(string)){
            places.remove(string);
            System.out.println(string + " is successfully deleted");
        }else{
            System.out.println("Sorry, there is no city called <" + string + ">in System");
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getSize(){
        return places.size();
    }

    public String getArray(int i){
        return places.get(i);
    }
}