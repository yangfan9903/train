import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MovieService {
    private static ArrayList<Movie> movies = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);



    public void start() {
        while (true) {
            System.out.println("===电影信息操作系统===");
            System.out.println("1.添加电影信息");
            System.out.println("2.下架电影信息");
            System.out.println("3.查询某个电影信息");
            System.out.println("4.封杀电影明星");
            System.out.println("5.退出系统");
            System.out.println("请输入操作的命令:");
            String cmd = sc.next();
            switch (cmd) {
                case "1":
                    Movie moviemessage = new Movie();
                    System.out.println("请输入电影名称:");
                    moviemessage.setName(sc.next());
                    System.out.println("请输入电影的主演");
                    moviemessage.setActor(sc.next());
                    System.out.println("请输入电影评分");
                    moviemessage.setSocre(sc.nextDouble());
                    System.out.println("请输入电影价格");
                    moviemessage.setPrice(sc.nextDouble());
                    movies.add(moviemessage);
                    break;
                case "2":
                    System.out.println("请输入下架的电影名称:");
                    String name = sc.next();

                    break;
                case "3":
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("已退出系统");
                    return;
                default:
                    System.out.println("输入命令有误,请重新输入");
            }

        }
    }
}
