package org.skypro.skyshop;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String searchQuery) {
        super("Не найден подходящий объект для поискового запроса: " + searchQuery);
    }
}
