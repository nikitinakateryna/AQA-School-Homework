package ProductTest;

import Pages.*;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class OrderTest {



    @BeforeTest
    public void setupBrowser() {
        BrowserConfig.setBrowser();
    }

    @Test
    public static void mainTest() {
        LoginPage.openPage();
        LoginPage.assertLoginPageIsOpened();
        LoginPage.login("standard_user", "secret_sauce");
        LoginPage.assertLogin();

        ProductsPage.addProductsToCart("$7.99", "$9.99");
        ProductsPage.assertIsAdded();
        ProductsPage.goToCart();
        ProductsPage.assertGoToCart();

        CartPage.assertTrueProductsAdded("$7.99", "$9.99");
        CartPage.assertCheckout();


        UserInfoPage.setValues("TEST", "TEST", "123");
        UserInfoPage.isOpened();

        CheckoutPage.calculateTaxPercent();
        CheckoutPage.goToFinal();

        FinalStepPage.aseertTextIsCorrect();
    }


    @AfterTest
    public void closeBrowser() {
        BrowserConfig.closeBrowser();
    }
}
