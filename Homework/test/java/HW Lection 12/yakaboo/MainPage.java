package yakaboo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attributeMatching;
import static com.codeborne.selenide.Selenide.$;


public class MainPage {
    private final SelenideElement searchInput = $("input");
    private final SelenideElement searchButton = $("button.ui-btn-primary");
    private final SelenideElement bookImage = $("img.product-image__thumb");
    private final SelenideElement newPopup = $(".cl-widget-f8519v8519");
    private final SelenideElement closePopup = $(".cl-dialog-close-icon");


    public void mainPageIsOpened() {
        String pageUrl = "https://www.yakaboo.ua/";
        Selenide.open(pageUrl);
        searchInput.shouldBe(Condition.visible);
    }

    public void searchBook(String bookName) {
        closePopup();
        searchInput.val(bookName);
        closePopup();
        searchButton.click();
        closePopup();
        bookImage.shouldHave(attributeMatching("alt", bookName));

    }

    public void goToBookPage() {
        closePopup();
        bookImage.click();
        Selenide.refresh();
        closePopup();

    }
    public void closePopup() { // на сайті постійно вилазив поп ап в різних місцях,
        // тому це метод який його закриває, я не знайшла поки іншого способу
        if (newPopup.is(Condition.visible)) {
            closePopup.click();
        }
    }

}


