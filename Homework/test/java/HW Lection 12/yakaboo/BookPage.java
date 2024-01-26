package yakaboo;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BookPage {
    private final SelenideElement paperBook = $(".paper");
    private final SelenideElement electronicBook = $(".digital");
    private final SelenideElement selectedBookPrice = $(".ui-price-display.simple.selected .ui-price-display__main span");
    private final SelenideElement otherPrice = $(".ui-price-display.simple .ui-price-display__main span");
    public void paperOrElectronic(){

        var isPaperBookAvailable = paperBook.isDisplayed();

        var isElectronicBookAvailable = electronicBook.isDisplayed();

        var price = selectedBookPrice.getText();

        var otherBookPrice = otherPrice.getText();


        if (isPaperBookAvailable && isElectronicBookAvailable) {
            electronicBook.click();
            System.out.println(STR."Електронна та паперова книги в наявності. Ціна електронної:\{price}. Ціна паперової:\{otherBookPrice}.");

        }

        else if (isElectronicBookAvailable && !isPaperBookAvailable) {
            electronicBook.click();
            System.out.println("В наявності лише електронна книга. Її вартість становить:" + price);

        }

        else if (!isElectronicBookAvailable && isPaperBookAvailable) {
            paperBook.click();
            System.out.println("В наявності лише паперова книга. Її вартість становить:" + price);

        }

        else {
            System.out.println("Жодна з книг не в наявності");
        }
    }
}

