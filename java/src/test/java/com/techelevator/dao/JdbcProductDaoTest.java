package com.techelevator.dao;

import com.techelevator.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcProductDaoTest extends BaseDaoTests {
    private JdbcProductDao dao;
    private static final Product PRODUCT_TO_CREATE = new Product() {{
        setName("Scooby Doo (Glitter)");
        setSpecies("Shiny Great Dane");
        setOccupation("Sparkly Mystery Solver");
        setCatchphrase("ScOoBy-DoObY-dOo!");
    }};

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcProductDao(jdbcTemplate);
    }

    @Test
    public void created_product_has_expected_values_when_retrieved() {
        Product dbProduct = dao.createProduct(PRODUCT_TO_CREATE);
        Assert.assertEquals(dbProduct.getProductCode(), 7);
    }

    @Test
    public void readAll_returns_all_products() {
        List<Product> products = dao.getAllProducts();

        Assert.assertNotNull(products);
        Assert.assertEquals(6, products.size());
    }

    @Test
    public void read_returns_the_correct_product() {
        Product dbProduct = dao.getProductById(1);
        Assert.assertTrue(dbProduct.getName().equals("Scooby Doo"));
        Assert.assertTrue(dbProduct.getSpecies().equals("Great Dane"));
        Assert.assertTrue(dbProduct.getOccupation().equals("Mystery Solver"));
        Assert.assertTrue(dbProduct.getCatchphrase().equals("Scooby-Dooby-Doo!"));
    }

    @Test
    public void read_returns_null_when_id_not_found() {
        Product dbProduct = dao.getProductById(7);
        Assert.assertNull(dbProduct);
    }

    @Test
    public void updated_product_has_expected_values_when_retrieved() {
        Product product = dao.getProductById(1);
        product.setName("Scooby Don't");
        product.setSpecies("Dog");
        product.setOccupation("Pet");
        product.setCatchphrase("Woof.");

        Product updatedProduct = dao.updateProduct(product);
        Assert.assertNotNull(updatedProduct);
        Assert.assertEquals(product.getProductCode(), updatedProduct.getProductCode());
        assertProductsMatch(product, updatedProduct);

        Product retrievedProduct = dao.getProductById(1);
        assertProductsMatch(retrievedProduct, updatedProduct);
    }

    private void assertProductsMatch(Product expected, Product actual) {
        Assert.assertEquals(expected.getProductCode(), actual.getProductCode());
        Assert.assertEquals(expected.getName(), actual.getName());
        Assert.assertEquals(expected.getSpecies(), actual.getSpecies());
        Assert.assertEquals(expected.getOccupation(), actual.getOccupation());
        Assert.assertEquals(expected.getCatchphrase(), actual.getCatchphrase());
    }
}
