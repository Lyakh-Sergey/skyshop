package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;

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
        System.out.println("\nСодержимое корзины до удаления:");
        basket1.printBasket();
        System.out.println("\nУдаляем продукт 'Яблоко':");
        List<Product> removedProducts = basket1.removeProductsByName("Яблоко");
        if (!removedProducts.isEmpty()) {
            System.out.println("Удаленные продукты:");
            for (Product product : removedProducts) {
                System.out.println(product);
            }
        }
        System.out.println("\nСодержимое корзины после удаления:");
        basket1.printBasket();
        System.out.println("\nПытаемся удалить продукт 'Манго':");
        removedProducts = basket1.removeProductsByName("Манго");
        if (removedProducts.isEmpty()) {
            System.out.println("Список удаленных продуктов пуст");
        }
        System.out.println("\nСодержимое корзины после попытки удаления:");
        basket1.printBasket();
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
        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addSearchable(product1);
        searchEngine.addSearchable(product2);
        searchEngine.addSearchable(product3);
        searchEngine.addSearchable(product4);
        searchEngine.addSearchable(product5);
        searchEngine.addSearchable(product6);
        searchEngine.addSearchable(product7);
        searchEngine.addSearchable(product8);
        searchEngine.addSearchable(product9);
        searchEngine.addSearchable(new Article("Арбузы", "Польза арбузов"));
        searchEngine.addSearchable(new Article("Хлеб", "Хлеб всему голова"));
        searchEngine.addSearchable(new Article("Полезный сад", "Польза и вред слив"));
        searchEngine.addSearchable(new Article("Итальянские деликатесы", "Помидоры и прочее"));
        searchEngine.addSearchable(new Article("Яблоки", "Польза яблок"));
        searchEngine.addSearchable(new Article("Дыня", "Дыня лучшая"));
        searchEngine.addSearchable(new Article("Полезный огород", "Польза и вред огурца"));
        searchEngine.addSearchable(new Article("Америка и  деликатесы", "Ананасы наше всё"));
        searchEngine.addSearchable(new Article("Пуаре", "Грушевый сидр"));
        searchEngine.addSearchable(new Article("Канцелярия", "Польза и вред гелевых ручек"));
        searchEngine.addSearchable(new Article("Мексика и деликатесы", "Агава наше всё"));
        searchEngine.addSearchable(new Article("Гаджеты и лайки", "Лучшие смартфоны 2025"));
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
        try {
            Searchable bestMatch = searchEngine.findBestMatch("");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка при создании поискового запроса: " + e.getMessage());
        } catch (BestResultNotFound e) {
            throw new RuntimeException(e);
        }
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