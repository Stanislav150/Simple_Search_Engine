package search;

import java.util.ArrayList;
import java.util.List;

class allSearchStrategy implements SearchStrategy {

    public Searcher searcher;

    public allSearchStrategy(Searcher searcher) {
        this.searcher = searcher;
    }

    public void getSearchResult(List<String> request) {
        List<Integer> indexes = new ArrayList<>();
        List<Integer> tempIndexes;
        for (String s : request) {
            if (searcher.invertedIndex.containsKey(s)) {
                if (indexes.size() == 0) {
                    indexes = searcher.invertedIndex.get(s);
                } else {
                    tempIndexes = searcher.invertedIndex.get(s);
                    indexes.retainAll(tempIndexes);
                }
            }
        }
        System.out.println("Result:");
        for (int i : indexes) System.out.println(searcher.userData.get(i));
    }
}

