package yakaboo;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    private final SelenideElement searchInput = $("input");
    private final SelenideElement searchButton = $("button.ui-btn-primary");
    private final SelenideElement bookImage = $$(".product-image category-card-mode").first();
    private final SelenideElement bookPage = $(".product__container");



    public void open() {
        String pageUrl = "https://www.yakaboo.ua/";
        Selenide.open(pageUrl);
        disablePopUp();

    }

    public void mainPageIsOpened(){
        searchInput.shouldBe(visible);
    }

    public void disablePopUp(){
        Selenide.localStorage().setItem("f.fv.view","{'f8519v8519':'2024-01-29T17:05:04.365Z'}");
        Selenide.localStorage().setItem("f.fv.close","{'f8519v8519':1}");

    }

    public void searchBook(String bookName) {
        searchInput.val(bookName);
        searchButton.shouldBe(visible).click();
        bookImage.shouldBe(visible).shouldHave(attributeMatching("alt", bookName));

    }

    public void goToBookPage() {
        bookImage.shouldBe(visible).click();
        bookPage.shouldBe(visible);

    }


}


