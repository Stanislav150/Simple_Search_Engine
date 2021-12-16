package search;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

class noneSearchStrategy implements SearchStrategy {
    public Searcher searcher;

    public noneSearchStrategy(Searcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public void getSearchResult(List<String> request) {
        List<Integer> indexes = new ArrayList<>();
        List<Integer> tempIndexes;
        for (String s : request) {
            if (searcher.invertedIndex.containsKey(s)) {
                indexes.addAll(searcher.invertedIndex.get(s));
            }
        }
        // Get all values from invertedIndex as a list:
        Set<Integer> allIndexes = new LinkedHashSet<>();
        for (List<Integer> listIndexes : searcher.invertedIndex.values())
            allIndexes.addAll(listIndexes);
        // Deleting the indexes of the words contained in the query
        allIndexes.removeAll(indexes);

        System.out.println("Result:");
        // We print all the lines that were not in the request
        for (int i : allIndexes) System.out.println(searcher.userData.get(i));
    }
}