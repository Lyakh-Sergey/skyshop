package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {
        Product product1 = new SimpleProduct("Арбуз", 90);
        Product product2 = new SimpleProduct("Яблоко", 80);
        Product product3 = new DiscountedProduct("Дыня", 100, 10);
        Product product4 = new SimpleProduct("Ананас", 145);
        Product product5 = new FixPriceProduct("Груша");
        Product product6 = new SimpleProduct("Помидор", 70);
        Product product7 = new DiscountedProduct("Огурец", 60, 10);
        Product product8 = new FixPriceProduct("Слива");
        Product product9 = new DiscountedProduct("Хлеб", 35, 20);
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