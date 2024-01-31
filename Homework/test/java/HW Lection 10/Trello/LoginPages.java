package Trello;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.files.DownloadActions.click;

public class LoginPages {
    private static final String loginUrl = "https://trello.com/en/login";
    private static final SelenideElement trelloLogo = $(".trello-main-logo");
    private static final SelenideElement inputEmail = $(" #user");

    private static final SelenideElement inputPassword = $(" #password ");

    private static final SelenideElement loginButton = $("#login-submit");

    private static final SelenideElement mainPage = $(".home-container");


    public static void openTrello() {
        Selenide.open(loginUrl);
        trelloLogo.shouldBe(visible);

    }
    public static void auth(String email, String pass) {
        inputEmail.shouldBe(visible);
        inputEmail.setValue(email).pressEnter();
        inputPassword.setValue(pass).pressEnter();
        loginButton.shouldBe(visible);
        loginButton.click();

    }

    public static void assertHomePageIsDisplayed(){
        mainPage.isDisplayed();
    }


}