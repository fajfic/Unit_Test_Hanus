import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CartItemHanusfTest {

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
}
