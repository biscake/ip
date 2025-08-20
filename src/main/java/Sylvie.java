public class Sylvie {
    private static final String BOT_NAME = "Sylvie";

    private static class Textbox {
        private final String message;

        public Textbox(String message) {
            this.message = message;
        }

        /**
         * Prints the message inside a border.
         */
        public void print() {
            String[] lines = message.split("\n");
            int maxWidth = Integer.MIN_VALUE;

            for (String s : lines) {
                maxWidth = Math.max(s.length(), maxWidth);
            }

            printBorder(maxWidth);
            System.out.println(message);
            printBorder(maxWidth);
        }

        /**
         * Helper function to print border for text box.
         * 
         * @param width length of the border to print.
         */
        private void printBorder(int width) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < width; i++) {
                sb.append("_");
            }

            sb.append("\n");

            System.out.println(sb);
        }
    }

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
