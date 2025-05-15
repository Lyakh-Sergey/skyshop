package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap = new HashMap<>();

    public void addProduct(Product product) {
        List<Product> products = productsMap.computeIfAbsent(product.getName(), k -> new ArrayList<>());
        products.add(product);
    }

    public int calculateTotalPriceProductsInBasket() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .mapToInt(Product::getPrice)
                .sum();
    }

    public long getSpecialProducts() {
        return productsMap.values().stream()
                .flatMap(List::stream)
                .filter(Product::isSpecial)
                .count();
    }

    public void printBasket() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        productsMap.values().stream()
                .flatMap(List::stream)
                .forEach(System.out::println);

        System.out.println("Итого: " + calculateTotalPriceProductsInBasket());
        System.out.println("Специальных товаров: " + getSpecialProducts());
    }

    public boolean containsProduct(String name) {
        return productsMap.containsKey(name);
    }

    public void cleaningTheBasket() {
        productsMap.clear();
    }

    public List<Product> removeProductsByName(String name) {
        List<Product> removedProducts = productsMap.remove(name);
        return removedProducts != null ? removedProducts : Collections.emptyList();
    }
}

