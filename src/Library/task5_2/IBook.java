package Library.task5_2;

public interface IBook {
    public String getName();

    public void setName(String name);

    public void setAuthor(String author);

    public String getAuthor();

    public int getYear();

    public void setYear(int year);

    public double getPrice();

    public void setPrice(double price);

    public int getMinAge();
    public void setMinAge(int minAge);

    public Object clone();
}
