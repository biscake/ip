public class Sylvie {
    private static final String BOT_NAME = "Sylvie";

    private static void greet() {
        String text = "Hello! I'm Sylvie\nWhat can I do for you?";
        new Textbox(text).print();
    }

    private static void exit() {
        String text = "Bye bye! Hope to see you again soon!";
        new Textbox(text).print();
    }
    public static void main(String[] args) {
        greet();
        exit();
    }
}
