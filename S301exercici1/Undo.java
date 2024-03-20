import java.util.ArrayList;

public class Undo {

    private static Undo instance;
    private ArrayList<String> commands;

    private Undo(){
        commands = new ArrayList<>();
    }

    public static Undo getInstance(){
        return instance == null ? instance = new Undo() : instance;
    }

    public void addCommand(String command){
        commands.add(command);
    }

    public void eraseLastCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.size() - 1);
        }
    }

    public void listCommands(){
        for (String command:commands) {
            System.out.println(command);
        }
    }
}
