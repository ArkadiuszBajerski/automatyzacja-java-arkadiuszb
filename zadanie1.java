import java.util.Scanner;

public class zadanie1 {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("If you want to close application, write 'exit' and push 'Enter'");
        Scanner scan = new Scanner(System.in);
        String exitText = null;
        while (!"exit".equals(exitText)) {
            System.out.println("Wrong close code, please try again");
            exitText = scan.nextLine();
        }
        System.out.println("Program closed");
        System.exit(0);
    }
}