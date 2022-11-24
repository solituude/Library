package Library.task3_1;

import Library.task5_2.IBook;

public class Book implements IBook {
    private String author;
    private String name;
    private double price;
    private int year, minAge;

    public Book(){
        author = "Not defined";
        name = "Not defined";
        price = 0;
        year = 0;
    }

    public Book(String author, String name, double price, int year){
        this.author = author;
        this.name = name;
        this.price = price;
        this.year = year;
    }

    public Book(String author, int year){
        this();
        this.author = author;
        this.year = year;
    }

    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String getAuthor(){
        return this.author;
    }

    public int getYear(){
        return this.year;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setYear(int year){
        this.year = year;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }
}



