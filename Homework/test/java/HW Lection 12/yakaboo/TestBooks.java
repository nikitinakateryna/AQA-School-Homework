package yakaboo;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestBooks {
    @BeforeTest
    public void setUpBrowser() {
        BrowserConfig.setBrowser();
    }

    static MainPage searchPage = new MainPage();
    static BookPage bookPage = new BookPage();

    @Test
    public static void test(){
        searchPage.mainPageIsOpened();
        searchPage.searchBook("Острів Сильвестра");
        searchPage.goToBookPage();
        bookPage.paperOrElectronic();

    }





}
