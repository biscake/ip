package sylvie.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.Temporal;
import java.util.List;

import sylvie.exception.InvalidArgumentException;

/**
 * Utility class for parsing and formatting dates.
 */
public class Date {
    private static final List<DateTimeFormatter> FORMATTERS = List.of(
        DateTimeFormatter.ISO_LOCAL_DATE,
        DateTimeFormatter.ISO_LOCAL_DATE_TIME,
        DateTimeFormatter.ofPattern("ddMMyy"),
        DateTimeFormatter.ofPattern("ddMMyy HHmm")
    );

    /**
     * Parses a date string into a Temporal object (LocalDate or LocalDateTime).
     * Supports multiple date formats.
     * @param input the date string to parse
     * @return a Temporal object representing the parsed date
     * @throws InvalidArgumentException if the date format is invalid
     */
    public static Temporal parse(String input) throws InvalidArgumentException {
        for (DateTimeFormatter formatter : FORMATTERS) {
            try {
                return LocalDateTime.parse(input, formatter);
            } catch (DateTimeParseException e) {
                try {
                    return LocalDate.parse(input, formatter);
                } catch (DateTimeParseException err) {
                    // try next formatter
                }
            }
        }

        StringBuilder errorMessage = new StringBuilder("Invalid date format\nSupported format:\n");
        for (int i = 0; i < FORMATTERS.size(); i++) {
            errorMessage.append(FORMATTERS.get(i).toString()).append("\n");
        }

        throw new InvalidArgumentException(errorMessage.toString());
    }

    /**
     * Converts a Temporal object (LocalDate or LocalDateTime) to a formatted date string.
     * @param date the Temporal object to format
     * @return a formatted date string
     * @throws InvalidArgumentException if the Temporal type is unsupported
     */
    public static String toDateString(Temporal date) throws InvalidArgumentException {
        if (date instanceof LocalDate localDate) {
            return localDate.format(DateTimeFormatter.ofPattern("d MMM yyyy"));
        }

        if (date instanceof LocalDateTime localDateTime) {
            return localDateTime.format(DateTimeFormatter.ofPattern("d MMM yyyy h:mma"));
        }

        throw new InvalidArgumentException("Unsupported date type");
    }
}
