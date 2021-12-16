package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class Searcher {
    public List<String> userData = new ArrayList<>();
    public final Map<String, List<Integer>> invertedIndex = new HashMap<>();
    private SearchStrategy strategy;

    public void setMethod(SearchStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * The method performs a search algorithm in accordance with a given strategy
     */
    public void search(List<String> requst) {
        this.strategy.getSearchResult(requst);
    }

    /**
     * Analyzes the data received from the file and indexes them.
     * If indexing is successful, an invertedIndex list is generated,
     * or an error message is displayed
     *
     * @param fileName - file name
     */
    public void readData(String fileName) {
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
                String key = _key.toLowerCase().replaceAll("[^A-Za-z0-9.@]", "");
                if (invertedIndex.containsKey(key)) invertedIndex.get(key).add(index);
                else {
                    indexes.add(index);
                    invertedIndex.put(key, indexes);
                }
            }
        }
    }

    public List<String> formRequest() {
        System.out.println("Query:");
        String request = "";
        boolean matchWasFound = false;
        while (!matchWasFound) {
            String line = Main.scanner.nextLine();
            if (!line.isEmpty()) {
                request = line.toLowerCase(Locale.ROOT);
                matchWasFound = true;
            }
        }
        return Arrays.asList(request.split(" "));
    }
}
