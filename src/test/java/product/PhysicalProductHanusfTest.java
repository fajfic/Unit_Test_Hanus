package product;

import com.example.eshop.product.PhysicalProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PhysicalProductHanusfTest {
    @Test
    @DisplayName("Should create valid product with all atributes")
    void createNewPhysicalBilekjProduct() {
        String name = "E-book java 2020";
        String description = "This is the description:)";
        BigDecimal price = new BigDecimal("39.90");
        double weight = 100;
        BigDecimal shippingCost = new BigDecimal("100");
        //String url = "https://Google.com";

        PhysicalProduct product = new PhysicalProduct(name, description, price, weight, shippingCost);

        assertAll("Verify product attributes",
                () -> assertEquals(name, product.getName(), "name should match"),
                () -> assertEquals(description, product.getDescription(), "Description should match"),
                () -> assertEquals(price, product.getPrice(), "Price should match"),
                () -> assertEquals(weight, product.getWeight(), "Weight should match"),
                () -> assertEquals(shippingCost, product.getShippingCost(), "Shipping cost should match"));
        //() -> assertEquals(url, product.getDownloadUrl(), "Download url should match"));
    }

    @Test
    @DisplayName("Set Weight")
    void setWeightHanusfTest() {
        PhysicalProduct product = new PhysicalProduct("Name", "Desc", new BigDecimal("10.00"), 1.0, new BigDecimal("5.00"));
        product.setWeight(2.5);
        assertEquals(2.5, product.getWeight(), "Weight should be updated");
    }

    @Test
    @DisplayName("Set Shipping Cost")
    void setShippingCostHanusfTest() {
        PhysicalProduct product = new PhysicalProduct("Name", "Desc", new BigDecimal("10.00"), 1.0, new BigDecimal("5.00"));
        product.setShippingCost(new BigDecimal("10.00"));
        assertEquals(new BigDecimal("10.00"), product.getShippingCost(), "Shipping cost should be updated");
    }

    @Test
    @DisplayName("Set Name")
    void setNameHanusfTest() {
        PhysicalProduct product = new PhysicalProduct("Name", "Desc", new BigDecimal("10.00"), 1.0, new BigDecimal("5.00"));
        product.setName("New Name");
        assertEquals("New Name", product.getName(), "Name should be updated");
    }

    @Test
    @DisplayName("Set Description")
    void setDescriptionHanusfTest() {
        PhysicalProduct product = new PhysicalProduct("Name", "Desc", new BigDecimal("10.00"), 1.0, new BigDecimal("5.00"));
        product.setDescription("New Desc");
        assertEquals("New Desc", product.getDescription(), "Description should be updated");
    }

    @Test
    @DisplayName("Set Price")
    void setPriceHanusfTest() {
        PhysicalProduct product = new PhysicalProduct("Name", "Desc", new BigDecimal("10.00"), 1.0, new BigDecimal("5.00"));
        product.setPrice(new BigDecimal("20.00"));
        assertEquals(new BigDecimal("20.00"), product.getPrice(), "Price should be updated");
    }
}
