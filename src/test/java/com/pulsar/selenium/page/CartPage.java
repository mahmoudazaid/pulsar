package com.pulsar.selenium.page;

import com.pulsar.selenium.driver.CustomWebDriver;
import com.pulsar.selenium.page.core.PageObject;
import static com.pulsar.selenium.locator.CartPageLocator.*;
import org.apache.log4j.Logger;

public class CartPage extends PageObject {

    private static final Logger logger = Logger.getLogger(CartPage.class.getName());
    
    public CartPage(CustomWebDriver driver) {
        super(driver, CartPage.class.getName());
    }

    /**
     * Navigate to product catalog
     */
    public void navigateToProductCatalog() {
        driver.waitVisibilityOf(PRODUCT_CATALOG, 30);
        logger.info("Navigated to product catalog");
    }

    /**
     * Check if product catalog is displayed
     */
    public boolean isProductCatalogDisplayed() {
        return driver.isElementVisible(PRODUCT_CATALOG.by());
    }

    /**
     * Select a product by name
     */
    public void selectProduct(String productName) {
        driver.scrollIntoView(ADD_TO_CART_BUTTON.by(productName));
        driver.clickOn(ADD_TO_CART_BUTTON.by(productName));
        logger.info("Selected product: " + productName);
    }

    /**
     * Check if specific item is in cart
     */
    public boolean isItemInCart(String productName) {
        try {
            return driver.isElementVisible(CART_ITEM.by(productName));
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Wait for cart to update
     */
    public void waitForCartUpdate() {
        driver.wait(3);
    }

    public String getCartCount() {
        return driver.getText(CART_COUNT);
    }
}