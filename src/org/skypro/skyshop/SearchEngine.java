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
}
