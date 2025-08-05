import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class birthday {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter event date and time (yyyy-MM-dd HH:mm): ");
        String input = sc.nextLine();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            LocalDateTime eventTime = LocalDateTime.parse(input, format);
            LocalDateTime now = LocalDateTime.now();

            if (eventTime.isBefore(now)) {
                System.out.println("The event time has already passed.");
                return;
            }

            Duration duration = Duration.between(now, eventTime);

            long totalMinutes = duration.toMinutes();
            long days = totalMinutes / (24 * 60);
            long hours = (totalMinutes % (24 * 60)) / 60;
            long minutes = totalMinutes % 60;

            System.out.println("Time remaining until event:");
            System.out.printf("\t%d days, %d hours, and %d minutes\n", days, hours, minutes);
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter in yyyy-MM-dd HH:mm format.");
        }
    }
}
