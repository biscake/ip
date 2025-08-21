import java.util.Scanner;

public class Sylvie {
    private static final String EXIT_LINE = "bye";

    private static void greet() {
        String text = "Hello! I'm Sylvie\nWhat can I do for you?";
        new Textbox(text).print();
    }

    private static void exit() {
        String text = "Bye bye! Hope to see you again soon!";
        new Textbox(text).print();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            greet();
            
            while (true) {
                String line = scanner.nextLine();
                
                if (line.toLowerCase().equals(EXIT_LINE)) {
                    break;
                }
                
                if (!line.isEmpty()) {
                    new Textbox(line).print();
                }
            }
            
            exit();
        }
    }
}
