package main.java.com.test.train.MovieTrain;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieService {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Movie> movies = new ArrayList<>();
        int id = 0;
        Movie movieone = new Movie();
        movieone.setId(id);
        movieone.setName("唐人街探案");
        movieone.setActor("张艺谋");
        movieone.setPrice(20);
        movies.add(movieone);
        id+=1;
        Movie movietwo = new Movie();
        movietwo.setId(id);
        movietwo.setName("唐人街探案2");
        movietwo.setActor("张艺谋,刘德华");
        movietwo.setPrice(60);
        id+=1;
        movies.add(movietwo);
        Movie movie3 = new Movie();
        movie3.setId(id);
        movie3.setName("开心麻花");
        movie3.setActor("沈腾,刘桓瑜");
        movie3.setPrice(30);
        movies.add(movie3);
        id+=1;

        String instruct1 = "1";
        String instruct2 = "1";
        while (true){
            Movie movie1 = new Movie();
            if (instruct1.equals("0")){
                System.out.println("=====电影信息录入程序已退出=====");
                break;
            }else {
                System.out.println("======电影信息录入程序启动=======");
                id += 1;
                movie1.setId(id);
                System.out.println("请输入电影名称");
                String name = sc.next();
                movie1.setName(name);
                System.out.println("请输入该电影的主演");
                String actors = sc.next();
                movie1.setName(actors);
                System.out.println("请输入电影票价");
                double price = sc.nextDouble();
                movie1.setPrice(price);
                movies.add(movie1);
            }
            System.out.println("是否继续录入电影信息(输入0停止录入)");
            instruct1 = sc.next();
        }

        while (true){
            if (instruct2.equals("0")){
                System.out.println("=====电影信息查询程序已退出=====");
                break;
            }else{
                System.out.println("======电影信息查询程序启动=======");
                System.out.println("1.根据电影id查询电影信息");
                System.out.println("2.根据电影名称查询电影信息");
                System.out.println("3.根据电影主演查询电影信息");
                System.out.println("4.根据电影票价范围查询电影信息");
                System.out.println("5.列出所有的电影信息");
                System.out.println("请输入进行的查询操作类型(1、2、3、4、5)");
                int type = sc.nextInt();
                switch (type){
                    case 1:
                        System.out.println("请输入要查询的电影id");
                        int selectId = sc.nextInt();
                        selectIdMovie(movies,selectId);
                        break;
                    case 2:
                        System.out.println("请输入要查询的电影名称");
                        String selectMovieName = sc.next();
                        selectMovie(2,movies,selectMovieName);
                        break;
                    case 3:
                        System.out.println("请输入要查询的电影主演");
                        String selectActorName = sc.next();
                        selectMovie(3,movies,selectActorName);
                        break;
                    case 4:
                        System.out.println("请输入最低的电影票价");
                        double minPrice = sc.nextDouble();
                        System.out.println("请输入最高的电影票价");
                        double maxPrice = sc.nextDouble();
                        selectPriceMovie(movies,minPrice,maxPrice);
                        break;
                    case 5:
                        selectMovies(movies);
                        break;
                    default:
                        System.out.println("输入指令错误，请重新输入");
                        break;
                }
            }
            System.out.println("是否继续查询电影信息(输入0停止录入)");
            instruct2 = sc.next();
        }

    }
    public static void selectMovie(int type,ArrayList<Movie> movies, String name){
        int number = 0;
        switch(type){
            case 2:
                for (Movie movie : movies) {
                    if(movie.getName().contains(name)){
                        System.out.println(movie);
                        number+=1;
                    }
                }
                if (number==0){
                    System.out.println("没有该电影名称的任何信息");
                }
            case 3:
                for (Movie movie : movies) {
                    if(movie.getActor().contains(name)){
                        System.out.println(movie);
                    }
                }
                if (number==0){
                    System.out.println("没有该主演的任何点隐蔽");
                }
        }
    }
    public static void selectPriceMovie(ArrayList<Movie> movies, double minPrice, double maxPrice){
        for (Movie movie : movies) {
            if (movie.getPrice()>=minPrice && movie.getPrice()<=maxPrice){
                System.out.println(movie);
            }
        }
    }
    public static void selectIdMovie(ArrayList<Movie> movies, int id){
        for (Movie movie : movies) {
            if (movie.getId()==id){
                System.out.println(movie);
            }
        }
    }
    public static void selectMovies(ArrayList<Movie> movies){
        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }



}
