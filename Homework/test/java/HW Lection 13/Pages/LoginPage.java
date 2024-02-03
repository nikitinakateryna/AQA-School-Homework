package Pages;

import  com.codeborne.selenide.Selenide;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    public  static String pageURL = "https://www.saucedemo.com/";

    public static SelenideElement usernameField = $("[data-test=\"username\"]");
    public static SelenideElement passwordField = $("[data-test=\"password\"]");
    public static SelenideElement loginButton = $("[data-test=\"login-button\"]");
    public static SelenideElement productsList = $(".inventory_list");




    public static void openPage(){
        Selenide.open(pageURL);

    }
    public static void assertLoginPageIsOpened(){
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
    }

    public static void login(String username, String password){
        usernameField.setValue(username);
        passwordField.setValue(password);
        loginButton.shouldBe(visible).click();
    }

    public static void assertLogin(){
        productsList.shouldBe(visible);
    }






}
