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

    private static void addTask(Task task) {
        String s = String.format("Got it. I've added this task:\n  %s\nNow you have %d tasks in the list.", task,
                list.size() + 1);
        list.add(task);
        new Textbox(s).print();
    }

    private static void addTask(String description) {
        Task task = new ToDo(description);
        addTask(task);
    }

    private static void addTask(String description, String by) {
        Task task = new Deadline(description, by);
        addTask(task);
    }

    private static void addTask(String description, String from, String to) {
        Task task = new Event(description, from, to);
        addTask(task);
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

                String[] parts = line.split("\\s+", 2);
                String command = parts.length > 1 ? parts[0] : "";
                String rest = parts.length > 1 ? parts[1] : "";

                if ((command.equalsIgnoreCase("mark") || command.equalsIgnoreCase("unmark"))) {
                    try {
                        int index = Integer.parseInt(rest) - 1; // -1 since ArrayList is 0-indexed
                        updateTaskStatus(index, command.equalsIgnoreCase("mark"));
                    } catch (NumberFormatException e) {
                        new Textbox("Please give a valid ID...").print();
                    }

                    continue;
                }

                if (command.equalsIgnoreCase("todo")) {
                    addTask(rest);
                    continue;
                }

                if (command.equalsIgnoreCase("deadline")) {
                    String[] split = rest.split("/by", 2);
                    String description = split.length > 0 ? split[0].trim() : "";
                    System.out.println(split.length);
                    String by = split.length > 1 ? split[1].trim() : "";
                    addTask(description, by);
                    continue;
                }

                if (command.equalsIgnoreCase("event")) {
                    String[] split = rest.split("/from|/to", 3);
                    String description = split.length > 0 ? split[0].trim() : "";
                    String from = split.length > 1 ? split[1].trim() : "";
                    String to = split.length > 2 ? split[2].trim() : "";
                    addTask(description, from, to);
                    continue;
                }
            }
            
            exit();
        }
    }
}
