package ir.ac.kntu;

import java.util.Scanner;

public class Date {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        Scanner input = new Scanner(System.in);
        while(!checkDate(day,month,year)) {
            System.out.println("invalid date, please try again:");
            System.out.println("year:");
            year = input.nextInt();
            System.out.println("month:");
            month = input.nextInt();
            System.out.println("day:");
            day = input.nextInt();
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getYear(){
        return year;
    }

    public int getDay(){
        return day;
    }

    public int getMonth(){
        return month;
    }

    public int compare(Date start){
        if(this.year - 1 < start.getYear()){
            return 15;
        }
        if(start.getYear() - 1 > this.year){
            return 15;
        }
        if(start.getYear() > this.year){
            if(start.month > 1){
                return 15;
            }
            if(this.month < 12){
                return 15;
            }
            return (start.getDay() + 30 - this.day);
        }
        if(start.getYear() < this.year){
            if(this.month > 1){
                return 15;
            }
            if(start.getMonth() < 12){
                return 15;
            }
            return (start.getDay() - 30 - this.day);
        }
        if(start.getYear() == this.year){
            if(this.month - start.getMonth() > 1 || start.getMonth() - this.month > 1){
                return 15;
            }
            if(this.month > start.getMonth()){
                return start.getDay() - 30 - this.day;
            }
            if(this.month < start.getMonth()){
                return start.getDay() + 30 - this.day;
            }
            return start.getDay() - this.day;
        }
        return start.getDay() - this.day;
    }

    private boolean checkDate(int day, int month , int year){
        if(day > 31 || month > 12){
            return false;
        }
        if((month > 6) && (day == 31)){
            return false;
        }
        if(month == 12){
            if(year % 4 != 2){
                if(day == 30){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString(){
        return "{" + year + "/" + month + "/" + day + '}';
    }
}