package seminars.first.Shop;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> sortProductsByPrice() {
        // Допишите реализацию метода самостоятельно
        return getProducts().stream()
                .sorted(Comparator.comparingInt(Product::getCost))
                .collect(Collectors.toList());
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct() {
        // Допишите реализацию метода самостоятельно
        return getProducts().stream()
                .max(Comparator.comparingInt(Product::getCost)).get();
    }

    @Override
    public String toString() {
        return "Shop{" +
               "products=" + products +
               '}';
    }
}