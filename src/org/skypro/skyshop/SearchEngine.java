package org.skypro.skyshop;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> searchables = new ArrayList<>();

    public void addSearchable(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>();
        String queryLower = query.toLowerCase();

        for (Searchable item : searchables) {
            if (item.getSearchableName().toLowerCase().contains(queryLower)) {
                results.put(item.getSearchableName(), item);
            }
        }
        return results;
    }

    public void printSearchResults(Map<String, Searchable> results) {
        if (results.isEmpty()) {
            System.out.println("Ничего не найдено");
            return;
        }

        for (Searchable item : results.values()) {
            System.out.println(item.getStringRepresentation());
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxCount = -1;
        String searchLower = search.toLowerCase();

        for (Searchable item : searchables) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm().toLowerCase();
            int count = countSubstringOccurrences(searchTerm, searchLower);

            if (count > maxCount) {
                maxCount = count;
                bestMatch = item;
            }
        }

        if (maxCount == 0) {
            throw new BestResultNotFound(search);
        }

        return bestMatch;
    }

    private int countSubstringOccurrences(String str, String substring) {
        int count = 0;
        int index = 0;
        int substringLength = substring.length();

        if (substringLength == 0) {
            return 0;
        }

        while (true) {
            index = str.indexOf(substring, index);
            if (index == -1) {
                break;
            }
            count++;
            index += substringLength;
        }

        return count;
    }
}
