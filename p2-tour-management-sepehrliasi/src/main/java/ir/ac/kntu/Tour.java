package ir.ac.kntu;

import java.util.HashMap;

enum TripWay {
    EARTH , AIR;
}

enum Type {
    TYPE , PREPARED;
}
public class Tour {
    private int duration; //by day
    private HashMap<Integer,String> places;
    private Date start;
    private long price;
    private int leastParticipants;
    private int mostParticipants;
    private String origin;
    private String destination;
    private TripWay tripway;
    private String name;
    private Leader leader;
    private Type type;

    public Tour(int duration, HashMap<Integer, String> places, long price, int leastParticipants, int mostParticipants, String origin, String destination, TripWay tripway){
        this.duration = duration;
        this.places = places;
        this.price = price;
        this.leastParticipants = leastParticipants;
        this.mostParticipants = mostParticipants;
        this.origin = origin;
        this.destination = destination;
        this.tripway = tripway;
        this.type = Type.TYPE;
    }

    public Type getType(){
        return type;
    }

    public String getOrigin(){
        return origin;
    }

    public String getDestination(){
        return destination;
    }

    public Date getStart(){
        return start;
    }

    public int getDuration(){
        return duration;
    }

    public HashMap<Integer, String> getPlaces(){
        return places;
    }

    public Tour(Date start, String name, Leader leader, Tour tour){
        this.duration = tour.duration;
        this.places = tour.places;
        this.price = tour.price;
        this.leastParticipants = tour.leastParticipants;
        this.mostParticipants = tour.mostParticipants;
        this.origin = tour.origin;
        this.destination = tour.destination;
        this.tripway = tour.tripway;
        this.start = start;
        this.name = name;
        this.leader = leader;
        this.type = Type.PREPARED;
    }

    @Override
    public String toString(){
        return "Tour{" +
                "name = '" + name + '\'' +
                ", origin = '" + origin + '\'' +
                ", destination = '" + destination + '\'' +
                ", places = " + places +
                ", duration = " + duration +
                ", price = " + price +
                ", leastParticipants = " + leastParticipants +
                ", mostParticipants = " + mostParticipants +
                ", tripway = " + tripway +
                ", start = " + start +
                '}';
    }
}