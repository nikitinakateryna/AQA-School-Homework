package Pages;

import com.codeborne.selenide.SelenideConfig;

import com.codeborne.selenide.SelenideDriver;
import com.codeborne.selenide.TextCheck;
import com.codeborne.selenide.WebDriverRunner;

public class BrowserConfig {
    public static void setBrowser() {
        var selenideConfig = new SelenideConfig();
        selenideConfig.browser("chrome");
        selenideConfig.browserSize("1920x1080");
        selenideConfig.pageLoadStrategy("normal");
        selenideConfig.pageLoadTimeout(35000);
        selenideConfig.timeout(30000);
        selenideConfig.textCheck(TextCheck.FULL_TEXT);

        SelenideDriver selenideDriver = new SelenideDriver(selenideConfig);
        WebDriverRunner.setWebDriver(selenideDriver.getAndCheckWebDriver());
    }

    public static void closeBrowser() {
        WebDriverRunner.closeWebDriver();
    }

}