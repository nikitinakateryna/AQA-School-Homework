package Trello;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TrelloTest {

    @BeforeTest
    public void setUpBrowser() {
        BrowserConfig.setBrowser();
    }

    @Test(priority = 1)
    public static void loginToTrello() {
        LoginPages.openTrello();
        LoginPages.auth("fihito8506@giratex.com", "HWTESTNG123");
        LoginPages.assertHomePageIsDisplayed();

    }

    @Test(priority = 2)
    public static void openBoard() {
        MainPage.openingBoard();
        MainPage.assertBoardIsOpened();
    }


    @Test (priority = 3)
    public static void addCard (){
        CardEditor.cardname = "New Test Card";
        CardEditor.addNewCard();
        CardEditor.assertCartIsAdded();
    }

    @Test (priority = 4, dependsOnMethods = "addCard")
    public static void addDescription (){
        CardEditor.description = "Test";
        CardEditor.addNewDescription();
        CardEditor.assertDescriptionIsAdded();
    }


    @Test (priority = 5, dependsOnMethods = "addCard")
    public static void addComment (){
        CardEditor.comment = "Test comment";
        CardEditor.addNewComment();
        CardEditor.assertCommentIsAdded();

    }

    @Test (priority = 6, dependsOnMethods = "addCard")
    public static void deleteCard (){
        CardEditor.deleteTestCard();
        CardEditor.assertCardIsDeleted();

    }

    @AfterTest
    public void tearDownBrowser() {
        BrowserConfig.closeBrowser();
    }


}
