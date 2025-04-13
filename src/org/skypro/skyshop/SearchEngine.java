package org.skypro.skyshop;

public class SearchEngine {
    private final Searchable[] searchables;
    private int currentIndex = 0;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
    }

    public void add(Searchable searchable) {
        if (currentIndex < searchables.length) {
            searchables[currentIndex++] = searchable;
        } else {
            System.out.println("Поисковая система переполнена, не удается добавить больше элементов");
        }
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (Searchable item : searchables) {
            if (item != null && item.getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[foundCount++] = item;
                if (foundCount == 5) {
                    break;
                }
            }
        }
        return results;
    }

    public void printSearchResults(Searchable[] results) {
        for (Searchable item : results) {
            if (item != null) {
                System.out.println(item.getStringRepresentation());
            } else {
                System.out.println("Ничего не найдено");
            }
        }
    }

    public Searchable findBestMatch(String search) throws BestResultNotFound {
        if (search == null || search.trim().isEmpty()) {
            throw new IllegalArgumentException("Поисковый запрос не может быть пустым");
        }

        Searchable bestMatch = null;
        int maxCount = -1;

        for (Searchable item : searchables) {
            if (item == null) continue;

            String searchTerm = item.getSearchTerm();
            int count = countSubstringOccurrences(searchTerm.toLowerCase(), search.toLowerCase());

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
