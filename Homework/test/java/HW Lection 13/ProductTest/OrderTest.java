package ProductTest;

import Pages.*;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {

    public static String url;


    @BeforeTest
    public void setupBrowser() {
        BrowserConfig.setBrowser();
    }

    @Test (priority = 1)
    public static void login() {
        LoginPage.openPage();
        LoginPage.assertLoginPageIsOpened();
        LoginPage.login("standard_user", "secret_sauce");
        LoginPage.assertLogin();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();

    }
    @Test (priority = 2)
    public static void selectProducts() {
        open(url);
        ProductsPage.addProductsToCart();
        ProductsPage.assertIsAdded();
        ProductsPage.goToCart();
        ProductsPage.assertGoToCart();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();

    }

    @Test (priority = 3)
    public static void checkCart() {
        open(url);
        CartPage.assertTrueProductsAdded();
        CartPage.assertCheckout();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();

    }

    @Test (priority = 4)
    public static void checkoutFirstStep(){
        open(url);
        UserInfoPage.setValues("TEST", "TEST", "123");
        UserInfoPage.isOpened();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();

    }

    @Test (priority = 5)
    public static void checkoutSecondStep(){
        open(url);
        CheckoutPage.calculateTaxPercent();
        CheckoutPage.goToFinal();
        url = WebDriverRunner.getWebDriver().getCurrentUrl();

    }

    @Test (priority = 6)
    public static void completeOrder(){
        open(url);
        FinalStepPage.aseertTextIsCorrect();
    }


    @AfterTest
    public void closeBrowser() {
        BrowserConfig.closeBrowser();
    }
}
