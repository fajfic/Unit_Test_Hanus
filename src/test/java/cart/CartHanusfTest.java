package cart;

import com.example.eshop.cart.Cart;
import com.example.eshop.cart.CartItem;
import com.example.eshop.product.DigitalProduct;
import com.example.eshop.product.PhysicalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartHanusfTest {
    @Test
    @DisplayName("Add")
    void addCartHanusfTest() {

        Cart cart = new Cart();
        PhysicalProduct jablko = new PhysicalProduct("Jablko","červené", new BigDecimal(20), 20,new BigDecimal(20));
        cart.addItem(jablko, 2);

        assertAll("Verify add product",
                () -> assertEquals(jablko, cart.getItems().get(0).getProduct(), "Item should be same")
        );
    }

    @Test
    @DisplayName("Remove")
    void removeCartHanusfTest() {

        Cart cart = new Cart();
        PhysicalProduct jablko = new PhysicalProduct("Jablko","červené", new BigDecimal(20), 20,new BigDecimal(20));
        cart.addItem(jablko, 2);

        cart.removeItem(jablko);
        assertAll("Verify add product",
                () -> assertEquals(0, cart.getItems().size(), "Item should be null")
        );
    }

    @Test
    @DisplayName("Calculate Total")
    void calculateTotalHanusfTest() {

        Cart cart = new Cart();
        PhysicalProduct jablko = new PhysicalProduct("Jablko","červené", new BigDecimal(20), 20,new BigDecimal(20));
        cart.addItem(jablko, 2);
        DigitalProduct ebook = new DigitalProduct("Ebook", "Desc", new BigDecimal("10.00"), "url");
        cart.addItem(ebook, 1);

        BigDecimal total = cart.calculateTotal();
        assertEquals(new BigDecimal("50.00"), total, "Total should be 50");
    }

    @Test
    @DisplayName("Clear Cart")
    void clearCartHanusfTest() {

        Cart cart = new Cart();
        PhysicalProduct jablko = new PhysicalProduct("Jablko","červené", new BigDecimal(20), 20,new BigDecimal(20));
        cart.addItem(jablko, 2);

        cart.clear();
        assertEquals(0, cart.getItems().size(), "Cart should be empty");
    }

    @ParameterizedTest
    @CsvSource({
        "10.00, 1, 10.00",
        "15.50, 2, 31.00",
        "5.00, 3, 15.00"
    })
    @DisplayName("Calculate Total Parameterized")
    void calculateTotalParameterizedHanusfTest(BigDecimal price, int quantity, BigDecimal expectedTotal) {
        Cart cart = new Cart();
        PhysicalProduct product = new PhysicalProduct("Test", "Desc", price, 1.0, new BigDecimal("0.00"));
        cart.addItem(product, quantity);

        BigDecimal total = cart.calculateTotal();
        assertEquals(expectedTotal, total, "Total should match expected");
    }

    @Test
    @DisplayName("Get Items Unmodifiable")
    void getItemsUnmodifiableHanusfTest() {
        Cart cart = new Cart();
        PhysicalProduct product = new PhysicalProduct("Test", "Desc", new BigDecimal("10.00"), 1.0, new BigDecimal("5.00"));
        cart.addItem(product, 1);

        List<CartItem> items = cart.getItems();
        assertThrows(UnsupportedOperationException.class, () -> items.add(new CartItem(product, 1)), "List should be unmodifiable");
    }
}
