package ir.ac.kntu;

import java.util.ArrayList;
import java.util.Calendar;

public class Leader {
    private String firstName;
    private String lastName;
    private int age;
    private long nationalCode;
    private Date employment;
    private Date birthday;
    private boolean marriage;
    private ArrayList<String> places;
    private Tour tour;

    public Leader(String firstName, String lastName, long nationalCode, Date employment, Date birthday, int marriage, ArrayList<String> places){
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalCode = nationalCode;
        this.employment = employment;
        this.birthday = birthday;
        this.marriage = (marriage == 1);
        this.places = places;
        int year = Calendar.getInstance().get(Calendar.YEAR);
        year -= 621;
        this.age = year - getYear();
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public Tour getTour(){
        return tour;
    }

    public ArrayList<String> getPlaces(){
        return places;
    }

    public int getAge(){
        return age;
    }

    public int getYear(){
        return this.birthday.getYear();
    }

    public String getPlace(int i){
        return places.get(i);
    }

    public int getSize(){
        return places.size();
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setNationalCode(long nationalCode){
        this.nationalCode = nationalCode;
    }

    public void setEmployment(Date employment){
        this.employment = employment;
    }

    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }

    public void setMarriage(int marriage){
        this.marriage = (marriage == 1);
    }

    public void setTour(Tour tour){
        this.tour = tour;
    }

    public void addPlace(String place){
        this.places.add(place);
    }

    public void removePlace(String place){
        places.remove(place);
    }

    public void showNumber(){
        for(int i = 0;i < this.places.size();i++){
            System.out.println(i+1 + "." + places.get(i));
        }
    }

    @Override
    public String toString(){
        String m;
        if(marriage){
            m = "married";
        }else{
            m = "single";
        }
        return "Leader{" +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", age = " + age +
                ", nationalCode = " + nationalCode +
                ", employment = " + employment +
                ", birthday = " + birthday +
                ", " + m +
                ", places=" + places +
                '}' + "\n";
    }
}