package yakaboo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestBooks {
    MainPage searchPage = new MainPage();
    BookPage bookPage = new BookPage();

    @BeforeTest
    public void setUpBrowser() {
        BrowserConfig.setBrowser();
    }

    @Test
    public void test(){
        searchPage.open();
        searchPage.mainPageIsOpened();
        searchPage.searchBook("Острів Джа");
        searchPage.goToBookPage();
        bookPage.paperOrElectronic();

    }

    @AfterTest
    public void tearDownBrowser() {
        BrowserConfig.closeBrowser();
    }





}
