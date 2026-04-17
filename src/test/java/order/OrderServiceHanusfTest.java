package order;

import com.example.eshop.cart.Cart;
import com.example.eshop.order.Order;
import com.example.eshop.order.OrderService;
import com.example.eshop.order.OrderStatus;
import com.example.eshop.payment.PaymentProcessor;
import com.example.eshop.product.PhysicalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceHanusfTest {

    // Simple test implementation of PaymentProcessor
    static class TestPaymentProcessor implements PaymentProcessor {
        private boolean shouldSucceed;

        TestPaymentProcessor(boolean shouldSucceed) {
            this.shouldSucceed = shouldSucceed;
        }

        @Override
        public boolean processPayment(BigDecimal amount) {
            return shouldSucceed;
        }
    }

    @Test
    @DisplayName("Place Order Successfully")
    void placeOrderSuccessHanusfTest() {
        PaymentProcessor processor = new TestPaymentProcessor(true);
        OrderService orderService = new OrderService(processor);

        Cart cart = new Cart();
        PhysicalProduct product = new PhysicalProduct("Test", "Desc", new BigDecimal("50.00"), 1.0, new BigDecimal("10.00"));
        cart.addItem(product, 1);

        Order order = orderService.placeOrder(cart);

        assertEquals(OrderStatus.PAID, order.getStatus(), "Order should be PAID");
        assertTrue(cart.getItems().isEmpty(), "Cart should be cleared");
    }

    @Test
    @DisplayName("Place Order Payment Failed")
    void placeOrderPaymentFailedHanusfTest() {
        PaymentProcessor processor = new TestPaymentProcessor(false);
        OrderService orderService = new OrderService(processor);

        Cart cart = new Cart();
        PhysicalProduct product = new PhysicalProduct("Test", "Desc", new BigDecimal("50.00"), 1.0, new BigDecimal("10.00"));
        cart.addItem(product, 1);

        Order order = orderService.placeOrder(cart);

        assertEquals(OrderStatus.CANCELLED, order.getStatus(), "Order should be CANCELLED");
        assertTrue(cart.getItems().isEmpty(), "Cart should be cleared");
    }

    @Test
    @DisplayName("Place Order Empty Cart")
    void placeOrderEmptyCartHanusfTest() {
        PaymentProcessor processor = new TestPaymentProcessor(true);
        OrderService orderService = new OrderService(processor);

        Cart cart = new Cart();

        assertThrows(IllegalStateException.class, () -> orderService.placeOrder(cart), "Should throw for empty cart");
    }
}
