package day01.MovieTrain;

public class Movie {
    private int id;
    private String name;
    private String actor;
    private double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "电影编号：" + id +
                ", 电影名称：" + name  +
                ", 电影主演：" + actor +
                ", 电影票价：" + price +
                '.';
    }
}
