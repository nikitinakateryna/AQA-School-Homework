package Pages;

import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;

public class FinalStepPage {
    public static SelenideElement comleteText = $(".complete-header");

    public static void aseertTextIsCorrect(){
        String text = comleteText.getText();
        Assert.assertTrue(text.contains("Thank you for your order!"));
    }
}
