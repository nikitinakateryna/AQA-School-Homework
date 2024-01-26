package yakaboo;

import com.codeborne.selenide.SelenideConfig;

import com.codeborne.selenide.TextCheck;

public class BrowserConfig {
    public static void setBrowser() {
        var selenideConfig = new SelenideConfig();
        selenideConfig.browser("chrome");
        selenideConfig.browserSize("1920x1080");
        selenideConfig.pageLoadStrategy("normal");
        selenideConfig.pageLoadTimeout(15000);
        selenideConfig.timeout(10000);
        selenideConfig.textCheck(TextCheck.FULL_TEXT);


    }

}
