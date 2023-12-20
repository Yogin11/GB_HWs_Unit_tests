package seminars.first.Shop;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class ShopTest {

    /*
   1. Напишите тесты, чтобы проверить, что магазин хранит верный список продуктов
    (правильное количество продуктов, верное содержимое корзины).
   2. Напишите тесты для проверки корректности работы метода getMostExpensiveProduct.
   3. Напишите тесты для проверки корректности работы метода sortProductsByPrice (проверьте правильность сортировки).
   */
    public static void main(String[] args) {

        String[] names = {"молоко", "варенье", "паштет", "хлеб", "творог", "апельсины", "пельмени", "чай", "имам-баялды"};
        Shop shop = shopCreator(names);
        validateShop(shop, names);
        validateMostExpensiveProductMethod();
        validateProductsSortMethod();

//        shop.getProducts().forEach(System.out::println);
//        System.out.println();
//        shop.sortProductsByPrice().forEach(System.out::println);
//        System.out.println();
//        System.out.println(shop.getMostExpensiveProduct());
    }

    public static void validateShop(Shop shop, String[] names) {
        assertThat(shop.getProducts().stream().map(Product::getTitle))
                .isNotEmpty()
                .hasSize(names.length)
                .containsAll(List.of(names))
                .doesNotHaveDuplicates();
    }

    public static void validateMostExpensiveProductMethod() {
        Shop testShop = new Shop();
        testShop.setProducts(List.of(new Product(),new Product(),new Product(),new Product()));
        testShop.getProducts().get(0).setCost(500);
        testShop.getProducts().get(1).setCost(700);
        testShop.getProducts().get(2).setCost(400);
        testShop.getProducts().get(3).setCost(100);

        assertThat(testShop.getMostExpensiveProduct())
                .isEqualTo(testShop.getProducts().get(1));

    }

    public static void validateProductsSortMethod(){
        Shop testShop = new Shop();
        testShop.setProducts(List.of(new Product(),new Product(),new Product(),new Product()));
        int counter = 0;
        for (Product pr : testShop.getProducts() ) {
            pr.setCost(900 - 100 * counter++);
        }
        assertThat(testShop.sortProductsByPrice())
                .containsExactlyElementsOf(List.of(
                        testShop.getProducts().get(3),
                        testShop.getProducts().get(2),
                        testShop.getProducts().get(1),
                        testShop.getProducts().get(0)));
    }



    public static Shop shopCreator(String[] names) {
        Random random = new Random();
        List<Product> createdList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            Product randomProduct = new Product();
            randomProduct.setTitle(names[i]);
            randomProduct.setCost(random.nextInt(350) + 50);
            createdList.add(randomProduct);
        }
        Shop shop = new Shop();
        shop.setProducts(createdList);
        return shop;
    }
}