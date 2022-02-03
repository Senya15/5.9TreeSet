import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static TreeSet<String> emailsList = new TreeSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean cheack = true;
        String foundEmail = "";
        do {
            System.out.println("Введите \"e-mail\": ");
            String intEmail = sc.nextLine().trim();
            Pattern pattern = Pattern.compile("");
            Matcher matcher = pattern.matcher(intEmail);
            while (matcher.find()) {
                foundEmail = intEmail.substring(matcher.start(), matcher.end());
                System.out.println(foundEmail);
            }
            if (foundEmail.length() > 0) {
                emailsList.add(foundEmail);
            } else {
                System.out.println("Введён некроректный \"e-mail\"!");
            }

        } while (cheack);
    }
}
