package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CheckoutPage {

    public static SelenideElement finishButton = $("#finish");
    public static SelenideElement tax = $(".summary_tax_label");
    public static SelenideElement total = $(".summary_info_label.summary_total_label");

    public static void calculateTaxPercent(){
        String taxValue = tax.getText();
        String totalValue = total.getText();

        double taxAmount = extractNumericValue(taxValue);
        double totalAmount = extractNumericValue(totalValue);
        double taxPercent = (taxAmount / totalAmount) * 100;
        double roundedTaxPercent = Math.round(taxPercent * 10.0) / 10.0;

        System.out.println("Tax percent is:" + roundedTaxPercent + "%");


    }

    private static double extractNumericValue(String input) {
        return Double.parseDouble(input.replaceAll("[^\\d.]+", ""));
    }

    public static void goToFinal(){
        finishButton.shouldBe(visible).click();
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assert.assertEquals(url, "https://www.saucedemo.com/checkout-complete.html");
    }

}
