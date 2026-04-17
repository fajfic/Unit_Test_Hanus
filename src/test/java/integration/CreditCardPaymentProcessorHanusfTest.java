package integration;

import com.example.eshop.payment.CreditCardPaymentProcessor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertTrue;

class CreditCardPaymentProcessorHanusfTest {

    @Test
    @DisplayName("Process Payment")
    void processPaymentHanusfTest() {
        CreditCardPaymentProcessor processor = new CreditCardPaymentProcessor();
        boolean result = processor.processPayment(new BigDecimal("100.00"));
        assertTrue(result, "Payment should succeed");
    }
}
