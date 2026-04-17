package cart;

import com.example.eshop.cart.CartItem;
import com.example.eshop.product.DigitalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartItemHanusfTest {

    @ParameterizedTest
    @ValueSource(ints = { -1, 0, Integer.MIN_VALUE})
    @DisplayName("CartItem Constructor Invalid Quantity")
    void cartItemConstructorInvalidQuantityHanusfTest(int quantity) {
        DigitalProduct dp = new DigitalProduct("jablko", "", new BigDecimal(2000), "");

        assertThrows(
                IllegalArgumentException.class,
                () -> new CartItem(dp, quantity)
        );
    }

    @ParameterizedTest
    @ValueSource(ints = { -1, 0, Integer.MIN_VALUE})
    @DisplayName("Set Quantity Invalid")
    void setQuantityInvalidHanusfTest(int quantity) {
        DigitalProduct dp = new DigitalProduct("Hruška", "", new BigDecimal(1500), "");

        CartItem ci = new CartItem(dp, 1);
        assertThrows(
                IllegalArgumentException.class,
                () -> ci.setQuantity(quantity)
        );
    }

    @Test
    @DisplayName("Get Total Price")
    void getTotalPriceHanusfTest() {
        DigitalProduct dp = new DigitalProduct("Book", "Desc", new BigDecimal("15.00"), "url");
        CartItem ci = new CartItem(dp, 3);
        assertEquals(new BigDecimal("45.00"), ci.getTotalPrice(), "Total price should be 45");
    }

    @ParameterizedTest
    @CsvSource({
        "10.00, 1, 10.00",
        "15.50, 2, 31.00",
        "5.00, 3, 15.00"
    })
    @DisplayName("Get Total Price Parameterized")
    void getTotalPriceParameterizedHanusfTest(BigDecimal price, int quantity, BigDecimal expectedTotal) {
        DigitalProduct dp = new DigitalProduct("Book", "Desc", price, "url");
        CartItem ci = new CartItem(dp, quantity);
        assertEquals(expectedTotal, ci.getTotalPrice(), "Total price should match");
    }
}
