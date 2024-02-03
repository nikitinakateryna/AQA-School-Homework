package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class UserInfoPage {

    public static SelenideElement firstName = $("#first-name");
    public static SelenideElement lastName = $("#last-name");
    public static SelenideElement postalCode = $("#postal-code");
    public static SelenideElement continueButton = $("#continue");

  public static void setValues(String name, String secondName, String code){
      firstName.shouldBe(visible).setValue(name);
      lastName.shouldBe(visible).setValue(secondName);
      postalCode.shouldBe(visible).setValue(code);
      continueButton.shouldBe(visible).click();
  }



    public static void isOpened(){
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-step-two.html");
    }
}
