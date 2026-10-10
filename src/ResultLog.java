// Stores all results for Display All Results
import java.util.ArrayList;
import java.util.List;

/** Stores every result produced during the session for "Display All Results". */
public class ResultLog {
    private static final List<String> ENTRIES = new ArrayList<>();

    public static void add(String entry) {
        ENTRIES.add(entry);
    }

    public static void displayAll() {
        System.out.println("=============================================");
        System.out.println(" ALL RESULTS (this session)");
        System.out.println("=============================================");
        if (ENTRIES.isEmpty()) {
            System.out.println("No results recorded yet.");
        } else {
            for (int i = 0; i < ENTRIES.size(); i++) {
                System.out.println((i + 1) + ". " + ENTRIES.get(i));
            }
        }
    }
}
