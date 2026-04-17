class DigitalProductHanusfTest {
    @Test
    @DisplayName("Should create valid product with all atributes")
    void createNewDigitalHanusfProduct() {
        String name = "E-book java 2025";
        String description = "This is the description";
        BigDecimal price = new BigDecimal("49.90");
        String url = "https://seznam.cz";

        DigitalProduct product = new DigitalProduct(name, description, price, url);

        assertAll("Verify product attributes",
                () -> assertEquals(name, product.getName(), "name should match"),
                () -> assertEquals(description, product.getDescription(), "Description should match"),
                () -> assertEquals(price, product.getPrice(), "Price should match"),
                () -> assertEquals(url, product.getDownloadUrl(), "Download url should match"));
    }

    @Test
    @DisplayName("Set Download Url")
    void setDownloadUrlHanusfTest() {
        DigitalProduct product = new DigitalProduct("Name", "Desc", new BigDecimal("10.00"), "oldurl");
        product.setDownloadUrl("newurl");
        assertEquals("newurl", product.getDownloadUrl(), "Download url should be updated");
    }
}
