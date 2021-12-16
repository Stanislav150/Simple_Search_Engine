package search;

import java.util.ArrayList;
import java.util.List;

class anySearchStrategy implements SearchStrategy {
    public Searcher searcher;

    public anySearchStrategy(Searcher searcher){
        this.searcher = searcher;
    }

    @Override
    public void getSearchResult(List<String> request) {
        List<Integer> indexes = new ArrayList<>();
        for (String s : request) {
            if (searcher.invertedIndex.containsKey(s)) {
                indexes.addAll(searcher.invertedIndex.get(s));
            }
        }
        System.out.println("Result:");
        // We print all the lines that match the request.
        for (int i : indexes) System.out.println(searcher.userData.get(i));
   }
}