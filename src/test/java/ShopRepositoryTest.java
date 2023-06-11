import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {
    ShopRepository repo = new ShopRepository();
    Product product1 = new Product(01, "Куры", 200);
    Product product2 = new Product(02, "Млеко", 50);
    Product product3 = new Product(03, "Яйки", 100);

    @BeforeEach
    public void allProduct() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
    }

    @Test
    public void TestRemoveValidProduct() {

        repo.remove(03);

        Product[] expected = {product1, product2};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestRemoveNotValidProduct() {

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(05)
        );
    }
}
