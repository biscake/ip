import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sylvie {
    private static List<Task> list = new ArrayList<>();

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
    private static void addTask(String description) {
        Task task = new Task(description);
        StringBuilder sb = new StringBuilder("added: ");
        new Textbox(sb.append(description).toString()).print();
        list.add(task);
    }

    /**
     * Displays all tasks added in list
     */
    private static void displayList() {
        StringBuilder sb = new StringBuilder("Here are the tasks in your list:\n");

        for (int i = 0; i < list.size(); i++) {
            String index = String.format("%d. ", i + 1);
            sb.append(index).append(list.get(i)).append("\n");
        }

        new Textbox(sb.toString()).print();
    }

    /**
     * Update status of task specified by index
     * 
     * @param index index of task stored in list
     * @param done mark task done as true or false
     */
    private static void updateTaskStatus(int index, boolean done) {
        if (index >= list.size() || index < 0) {
            new Textbox("Sorry, I can't find the task with the ID").print();
            return;
        }

        Task task = list.get(index);

        if (done) {
            task.markDone();
            new Textbox(String.format("Nice! I've' marked this task as done:\n%s", task)).print();
        } else {
            task.markNotDone();
            new Textbox(String.format("Okay! I've' marked this task as not done yet:\n%s", task)).print();
        }

    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            greet();
            
            while (true) {
                String line = scanner.nextLine();
                
                if (line.equalsIgnoreCase("bye")) {
                    break;
                }

                if (line.equalsIgnoreCase("list")) {
                    displayList();
                    continue;
                }

                String[] words = line.split("\\s+");
                if ((words[0].equalsIgnoreCase("mark") || words[0].equalsIgnoreCase("unmark")) && words.length == 2) {
                    try {
                        int index = Integer.parseInt(words[1]) - 1; // -1 since ArrayList is 0-indexed
                        if (words[0].equalsIgnoreCase("mark")) {
                            updateTaskStatus(index, true);
                        } else {
                            updateTaskStatus(index, false);
                        }
                    } catch (NumberFormatException e) {
                        new Textbox("Please give a valid ID...").print();
                    }

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
