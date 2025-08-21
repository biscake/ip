public class Textbox {
    private final String message;

    public Textbox(String message) {
        this.message = message;
    }

    /**
     * Prints the message inside a border.
     */
    public void print() {
        int INDENT_SIZE = 4;
        String[] lines = message.split("\n");
        int maxWidth = Integer.MIN_VALUE;

        for (int i = 0; i < lines.length; i++) {
            String s = lines[i];
            maxWidth = Math.max(s.length(), maxWidth);
            StringBuilder sb = new StringBuilder(s);
            lines[i] = sb.insert(0, indent(INDENT_SIZE)).toString();
        }

        printBorder(maxWidth, INDENT_SIZE);
        System.out.println(String.join("\n", lines));
        printBorder(maxWidth, INDENT_SIZE);
    }

    /**
     * Prints a border of underscores with the specified indentation size.
     * 
     * @param width width of the length of the border to print.
     * @param indentSize the number of spaces to indent before the border.
     */
    private void printBorder(int width, int indentSize) {
        StringBuilder sb = new StringBuilder();

        sb.append(indent(indentSize));
        for (int i = 0; i < width; i++) {
            sb.append("_");
        }

        sb.append("\n");

        System.out.println(sb);
    }

    /**
     * Helper function that returns string of whitespace
     * 
     * @param size Length of the indentation
     * @return String of whitespaces of indentation size
     */
    private String indent(int size) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < size; i++) {
            sb.append(" ");
        }

        return sb.toString();
    }
}