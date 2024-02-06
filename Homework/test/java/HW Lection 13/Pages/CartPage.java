package Pages;

import com.codeborne.selenide.*;
import org.testng.Assert;

import javax.swing.text.html.parser.Element;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartPage {

  public static SelenideElement checkoutButton = $("[data-test=\"checkout\"]");


 public static void assertTrueProductsAdded(String firstPrice, String secondPrice){
   ElementsCollection items = $$(".inventory_item_price");

     for (SelenideElement item : items) {
         String itemPrice = item.getText();
         if (itemPrice.equals(firstPrice)) {
             Assert.assertEquals(itemPrice, firstPrice);
         } else if (itemPrice.equals(secondPrice)) {
             Assert.assertEquals(itemPrice, secondPrice);
         }
     }

 }
 public static void assertCheckout() {
        checkoutButton.shouldBe(visible).click();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-one.html", "Something go wrong");

    }
}
