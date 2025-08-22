import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sylvie {
    private static final List<Task> taskList = new ArrayList<>();

    private static void greet() {
        String text = "Hello! I'm Sylvie\nWhat can I do for you?";
        new Textbox(text).print();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            greet();
            
            while (true) {
                try {
                    String line = scanner.nextLine();
                    
                    Command command = CommandParser.parse(line);
                    command.execute(taskList);

                    if (command.isExit()) {
                        break;
                    }
                } catch (SylvieException e) {
                    new Textbox(e.getMessage()).print();
                }
            }
        }
    }
}
