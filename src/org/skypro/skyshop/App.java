package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;


public class App {
    public static void main(String[] args) {
        Product product1 = new Product("Арбуз", 90);
        Product product2 = new Product("Яблоко", 80);
        Product product3 = new Product("Дыня", 100);
        Product product4 = new Product("Ананас", 145);
        Product product5 = new Product("Груша", 110);
        Product product6 = new Product("Помидор", 70);
        Product product7 = new Product("Огурец", 60);
        Product product8 = new Product("Слива", 85);
        Product product9 = new Product("Хлеб", 35);
        ProductBasket basket1 = new ProductBasket();
        ProductBasket basket2 = new ProductBasket();
        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);
        basket1.addProduct(product6);
        basket2.addProduct(product6);
        basket2.addProduct(product7);
        basket2.addProduct(product8);
        basket2.addProduct(product9);
        System.out.println("\nСодержимое корзины 1:");
        basket1.printBasket();
        System.out.println("\nСодержимое корзины 2:");
        basket2.printBasket();
        System.out.println("\nОбщая стоимость корзины 1: " + basket1.calculateTotalPriceProductsInBasket());
        System.out.println("\nОбщая стоимость корзины 2: " + basket2.calculateTotalPriceProductsInBasket());
        System.out.println("\nВ корзине 1 есть Арбуз: " + basket1.containsProduct("Арбуз"));
        System.out.println("\nВ корзине 2 есть Огурец: " + basket2.containsProduct("Огурец"));
        System.out.println("\nВ корзине 1 есть Огурец: " + basket1.containsProduct("Огурец"));
        System.out.println("\nВ корзине 2 есть Арбуз: " + basket2.containsProduct("Арбуз"));
        basket1.cleaningTheBasket();
        basket2.cleaningTheBasket();
        System.out.println("\nСодержимое корзины 1 после очистки:");
        basket1.printBasket();
        System.out.println("\nСодержимое корзины 2 после очистки:");
        basket2.printBasket();
        System.out.println("\nОбщая стоимость корзины 1 после очистки: " + basket1.calculateTotalPriceProductsInBasket());
        System.out.println("\nОбщая стоимость корзины 2 после очистки: " + basket2.calculateTotalPriceProductsInBasket());
        System.out.println("\nВ корзине после очистки 1 есть Арбуз: " + basket1.containsProduct("Арбуз"));
        System.out.println("\nВ корзине после очистки 2 есть Огурец: " + basket2.containsProduct("Огурец"));
    }
}