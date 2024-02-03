package Pages;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class ProductsPage {


    public static SelenideElement cartIcon = $(".shopping_cart_container");

    public static void addProductsToCart() {

        ElementsCollection products = $$(".inventory_item");

        for (SelenideElement product : products) {
            String productPrice = product.$(".inventory_item_price").getText();

                if ("$7.99".equals(productPrice) || "$9.99".equals(productPrice)) {
                    String id = product.find(".btn.btn_primary.btn_small.btn_inventory").getAttribute("id");
                    $(By.id(id)).click();
            }
        }
    }

    public static void assertIsAdded() {
        cartIcon.shouldBe(visible).shouldHave(Condition.text("2"));
    }


    public static void goToCart(){
        cartIcon.shouldBe(visible).click();
    }

    public static void assertGoToCart(){
            String url = WebDriverRunner.getWebDriver().getCurrentUrl();
            Assert.assertEquals(url, "https://www.saucedemo.com/cart.html", "Cart is not opened.");

        }
    }


