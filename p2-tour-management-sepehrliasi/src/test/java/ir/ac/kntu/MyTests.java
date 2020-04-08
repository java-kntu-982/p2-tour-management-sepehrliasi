package ir.ac.kntu;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class MyTests {
    public static void main(String[] args){
        HashMap<Integer,String> place = new HashMap<>();
        int i = 1;
        int duration = 10;
        String origin = "karaj";
        String destination = "tehran";
        while(i < duration){
            place.put(i,origin);
            i++;
        }
        place.put(duration,destination);
        System.out.println(place);
    }
}