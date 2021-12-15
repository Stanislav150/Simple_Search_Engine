package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    static List<String> userData = new ArrayList<>();
    private static final Map<String, List<Integer>> invertedIndex = new HashMap<>();
    static boolean repeat = true;

    public static void main(String[] args) {
        readData(args[1]);
        while (repeat) menu();

    }

    /**
     * We enter data for further analysis
     * changes for the new commit
     */
    public static void readData(String fileName) {
        String string = "";
        try {
            string = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
        userData = Arrays.asList(string.split("\n"));
        for (int index = 0; index < userData.size(); index++) {
            String line = userData.get(index);
            for (String _key : line.split(" ")) {
                List<Integer> indexes = new ArrayList<>();
                String key = _key.toLowerCase();
                if (invertedIndex.containsKey(key)) invertedIndex.get(key).add(index);
                else {
                    indexes.add(index);
                    invertedIndex.put(key, indexes);
                }
            }
        }
    }
    public static void menu() {
        System.out.printf("=== Menu ===%n1. Find a person%n2. Print all people%n0. Exit%n");
        switch (scanner.nextInt()) {
            case 1:
                findPerson();
                break;
            case 2:
                printAllPeople();
                break;
            case 0:
                exit();
                break;
            default:
                System.out.println("Incorrect option! Try again.");
        }
    }

    public static void findPerson() {
        System.out.println("Enter a name or email to search all suitable people.");
        String request;
        List<Integer> indexes = new ArrayList<>();
        boolean matchWasFound = false;
        while (!matchWasFound) {
            String line = scanner.nextLine();
            if (!line.isEmpty()) {
                request = line.toLowerCase(Locale.ROOT);
                if (invertedIndex.containsKey(request)) {
                    indexes = invertedIndex.get(request);
                    matchWasFound = true;
                }
                if (!matchWasFound) {
                    matchWasFound = true;
                    System.out.println("No matching people found.");
                } else {
                    System.out.printf("%d persons found:%n", indexes.size());
                    for (Integer index : indexes) System.out.println(userData.get(index));
                }
            }
        }
    }

    public static void printAllPeople() {
        System.out.println("=== List of People ===");
        userData.forEach(System.out::println);
    }

    public static void exit() {
        System.out.println("Bye!");
        repeat = false;
    }
}

