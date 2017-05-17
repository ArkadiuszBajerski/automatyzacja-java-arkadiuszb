import java.util.Scanner;

public class zadanie1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("Press any key to exit");
        Scanner scan = new Scanner(System.in);
        if(!scan.next().isEmpty()) {
            System.exit(0);
        }
    }
}