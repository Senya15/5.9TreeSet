import lombok.Getter;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
public class Main {
    static Command command;
    static String foundCommand = "";
    static String intEmail;
    static TreeSet<String> emailsList = new TreeSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean cheack = true;
        do {
            System.out.println("Введите КОМАНДУ: ");
            intEmail = sc.nextLine().trim();
            Pattern pattern = Pattern.compile("^(ADD\\s)?(LIST)?(EXIT)?");
            Matcher matcher = pattern.matcher(intEmail);
            while (matcher.find()) {
                foundCommand = intEmail.substring(matcher.start(), matcher.end()).trim();
            }
            setCommand();
            switch (getCommand()) {
                case LIST:
                    if (!emailsList.isEmpty()) {
                        for (String s :
                                emailsList) {
                            System.out.println(s);
                        }
                    } else System.out.println("Список пуст!");
                    break;
                case ADD:
                    String[] strADD = intEmail.split("\\s", 2);
                    if (strADD.length == 2 &&
                            strADD[1].matches("^[_A-Za-z0-9-+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+" +
                                    "(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")) {
                        emailsList.add(strADD[1]);
                    } else {
                        System.out.println("Введён некроректный \"e-mail\"!");
                    }
                    break;
                case EXIT:
                    System.out.println("\tПрограма завершена...");
                    cheack = false;
                    break;
                default:
                    System.out.println("\tКоманда не распознана!");
                    break;
            }
        } while (cheack);
    }

    static void setCommand() {
        if (intEmail.matches("^LIST")) {
            command = Command.LIST;
        } else if (foundCommand.matches("^ADD")) {
            command = Command.ADD;
        } else if (intEmail.matches("^EXIT")) {
            command = Command.EXIT;
        } else command = Command.NOT_RECOGNIZED;
    }

    static Command getCommand() {
        return command;
    }
}

