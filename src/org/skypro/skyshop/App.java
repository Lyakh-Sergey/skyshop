package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
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
        System.out.println();
        SearchEngine searchEngine = new SearchEngine(20);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(product7);
        searchEngine.add(product8);
        searchEngine.add(product9);
        searchEngine.add(new Article("Арбузы", "Польза арбузов"));
        searchEngine.add(new Article("Хлеб", "Хлеб всему голова"));
        searchEngine.add(new Article("Полезный сад", "Польза и вред слив"));
        searchEngine.add(new Article("Итальянские деликатесы", "Помидоры и прочее"));
        searchEngine.add(new Article("Яблоки", "Польза яблок"));
        searchEngine.add(new Article("Дыня", "Дыня лучшая"));
        searchEngine.add(new Article("Полезный огород", "Польза и вред огурца"));
        searchEngine.add(new Article("Америка и  деликатесы", "Ананасы наше всё"));
        searchEngine.add(new Article("Пуаре", "Грушевый сидр"));
        searchEngine.add(new Article("Канцелярия", "Польза и вред гелевых ручек"));
        searchEngine.add(new Article("Мексика и деликатесы", "Агава наше всё"));
        searchEngine.add(new Article("Гаджеты и лайки", "Лучшие смартфоны 2025"));
        System.out.println();
        System.out.println("Результаты поиска по 'арбуз':");
        searchEngine.printSearchResults(searchEngine.search("арбуз"));
        System.out.println("\nРезультаты поиска по 'хлеб':");
        searchEngine.printSearchResults(searchEngine.search("хлеб"));
        System.out.println("\nРезультаты поиска по 'слив':");
        searchEngine.printSearchResults(searchEngine.search("слив"));
        System.out.println("\nРезультаты поиска по 'помидор':");
        searchEngine.printSearchResults(searchEngine.search("помидор"));
        System.out.println("\nРезультаты поиска по 'итальянские':");
        searchEngine.printSearchResults(searchEngine.search("итальянские"));
        System.out.println("\nРезультаты поиска по 'наше всё':");
        searchEngine.printSearchResults(searchEngine.search("наше всё"));
        System.out.println("\nРезультаты поиска по 'сидр':");
        searchEngine.printSearchResults(searchEngine.search("сидр"));
        System.out.println("\nРезультаты поиска по 'карандаш':");
        searchEngine.printSearchResults(searchEngine.search("карандаш"));
        System.out.println("\nРезультаты поиска по 'текила':");
        searchEngine.printSearchResults(searchEngine.search("текилв"));
        System.out.println("\nРезультаты поиска по 'смартфоны':");
        searchEngine.printSearchResults(searchEngine.search("смартфоны"));
        System.out.println("\nПроверка при добавлении новых продуктов");
        try {
            Product emptyNameProduct = new SimpleProduct(" ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product nullNameProduct = new SimpleProduct(null, 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product zeroPriceProduct = new SimpleProduct("Телефон", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product zeroPriceDiscountProduct = new DiscountedProduct("Смартфон", 0, 20);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product negativeDiscountProduct = new DiscountedProduct("Ноутбук", 50000, -10);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        }

        try {
            Product invalidDiscountProduct = new DiscountedProduct("Планшет", 30000, 110);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании продукта: " + e.getMessage());
        } finally {
            System.out.println("Проверка завершена");
        }
        System.out.println("\nПроверка при добавлении новых статей");
        try {
            Article emptyTitleArticle = new Article(" ", "Пустое название");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании статьи: " + e.getMessage());
        }

        try {
            Article nullTitleArticle = new Article(null, "Нет названия");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании статьи: " + e.getMessage());
        }

        try {
            Article emptyTextArticle = new Article("Телефон", " ");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании статьи: " + e.getMessage());
        }

        try {
            Article nullTextArticle = new Article("Смартфон", null);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании статьи: " + e.getMessage());
        } finally {
            System.out.println("Проверка завершена");
        }
        System.out.println("\nПоиск самого подходящего элемента:");
        Searchable[] SearchEngine = null;
        try {
            Searchable bestMatch = searchEngine.findBestMatch("яблоки");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

        try {
            Searchable bestMatch = searchEngine.findBestMatch("магнитофон");
            System.out.println("Найден лучший результат: " + bestMatch.getSearchTerm());
        } catch (BestResultNotFound e) {
            System.out.println(e.getMessage());
        }

    }
}
