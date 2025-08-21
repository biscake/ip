import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sylvie {
    private static List<String> list = new ArrayList<>();

    private static void greet() {
        String text = "Hello! I'm Sylvie\nWhat can I do for you?";
        new Textbox(text).print();
    }

    private static void exit() {
        String text = "Bye bye! Hope to see you again soon!";
        new Textbox(text).print();
    }

    /**
     * Adds task to static variable list
     * 
     * @param task
     */
    private static void addTask(String task) {
        StringBuilder sb = new StringBuilder("added: ");
        new Textbox(sb.append(task).toString()).print();
        list.add(task);
    }

    /**
     * Displays all tasks added in list
     */
    private static void displayList() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            String index = String.format("%d. ", i + 1);
            sb.append(index).append(list.get(i)).append("\n");
        }

        new Textbox(sb.toString()).print();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            greet();
            
            while (true) {
                String line = scanner.nextLine();
                
                if (line.toLowerCase().equals("bye")) {
                    break;
                }

                if (line.toLowerCase().equals("list")) {
                    displayList();
                    continue;
                }

                if (!line.isEmpty()) {
                    addTask(line);
                }
            }
            
            exit();
        }
    }
}
