package Trello;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {

    private static final SelenideElement testBoard = $(".board-tile-details-name");

    private static final SelenideElement board = $("#board");



    public static void openingBoard(){
        testBoard.shouldBe(Condition.visible);
        testBoard.click();

    }

    public static void assertBoardIsOpened(){
        board.shouldBe(Condition.visible);
    }
}

