import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(01, "Куры", 200);
    Product product2 = new Product(02, "Млеко", 50);
    Product product3 = new Product(03, "Яйки", 100);
    @Test
    public void TestRemoveValidProduct() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(03);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestRemoveNotValidProduct() {

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.removeById(05)
        );
    }
}
