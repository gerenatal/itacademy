import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Undo undo = Undo.getInstance();
        menu(undo);
    }
    static void menu(Undo undo){
        while (true) {
            String input = input("""
                    Insert a command or
                    1 to erase last
                    2 to list
                    3 to exit:""");
            switch (input.toLowerCase()) {
                case "1":
                    undo.eraseLastCommand();
                    break;
                case "2":
                    undo.listCommands();
                    break;
                case "3":
                    System.out.println("Bye!");
                    System.exit(0);
                    break;
                default:
                    undo.addCommand(input);
            }
        }
    }

    static String input(String message){
        Scanner in = new Scanner(System.in);
        System.out.println(message);
        String input = in.nextLine();
        return input;
    }
}