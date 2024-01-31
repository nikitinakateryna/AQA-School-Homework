package Trello;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CardEditor {
    //add card
    static String cardname;
    static String comment;
    static String description;


    private static final SelenideElement addCardButton = $("[data-testid='list-add-card-button']");
    private static final SelenideElement placeholderForCardName = $("[data-testid='list-card-composer-textarea']");
    private static final SelenideElement submitAddingCardButton = $("[data-testid='list-card-composer-add-card-button']");
    private static final SelenideElement closeIconCard = $("[data-testid='CloseIcon']");

    private static final SelenideElement cardView = $("[data-testid='card-name']");

    private static final SelenideElement  cardEditView = $(".card-detail-window.u-clearfix");



    //add description

    private static final SelenideElement editButton = $("[data-testid='quick-card-editor-button']");
    private static final SelenideElement saveDescription = $(".confirm.js-save-edit.bxgKMAm3lq5BpA.SdamsUKjxSBwGb.SEj5vUdI3VvxDc");
    private static final SelenideElement openCardButton = $("[data-testid='quick-card-editor-open-card']");
    private static final SelenideElement fullDescArea = $("#ak-editor-textarea");
    private static final SelenideElement unclickedDescArea = $(".js-description-fake-text-area.hide-on-edit.js-edit-desc.LDTYZ4htfrP9Xl");
    private static final SelenideElement addedDescription = $(".current.markeddown.hide-on-edit.js-desc.js-show-with-desc");



    //add comment
    private static final SelenideElement commentNonClicked = $("[data-testid='card-back-new-comment-input-skeleton']");
    private static final SelenideElement commentClicked = $$(".ua-chrome.ProseMirror.ProseMirror-focused").last();
    private static final SelenideElement saveComment = $("[data-testid='card-back-comment-save-button']");

    private static final SelenideElement addedComment = $(".current-comment.js-friendly-links.js-open-card");


    //delete card
    private static final SelenideElement archive = $(".button-link.js-archive-card");
    private static final SelenideElement delete = $(".button-link.js-delete-card.negate");
    private static final SelenideElement confirmationDeleting = $(".js-confirm.full.nch-button.nch-button--danger");
    private static final SelenideElement cardsFields = $(".js-list-container");







    public static void addNewCard() {
        addCardButton.shouldBe(visible);
        addCardButton.click();
        placeholderForCardName.shouldBe(visible);
        placeholderForCardName.setValue(cardname);
        submitAddingCardButton.click();
        closeIconCard.click();
    }

    public static void assertCartIsAdded(){
        Assert.assertEquals(cardView.shouldBe(visible).shouldHave().text(), cardname, "New card hasn't been created.");
    }

    public static void addNewDescription() {
        cardView.hover();
        editButton.hover();
        editButton.shouldBe(visible);
        editButton.click();
        openCardButton.shouldBe(visible).click();
        cardEditView.exists();
        unclickedDescArea.shouldBe(visible).click();
        fullDescArea.click();
        fullDescArea.setValue(description);
        saveDescription.click();

    }


    public static void assertDescriptionIsAdded(){
        Assert.assertEquals( addedDescription.shouldBe(visible).shouldHave().text(), description, "Description hasn't been added.");
    }
    public static void addNewComment() {commentNonClicked.shouldBe(visible);
        commentNonClicked.click();
        commentClicked.click();
        commentClicked.setValue(comment);
        saveComment.click();

    }

    public static void assertCommentIsAdded(){
        Assert.assertEquals( addedComment.shouldBe(visible).shouldHave().text(), comment, "Comment hasn't been added.");
    }

    public static void deleteTestCard() {
        archive.click();
        delete.click();
        confirmationDeleting.click();


    }

    public static void assertCardIsDeleted() {
        Assert.assertNotEquals(cardsFields.shouldBe(visible).shouldHave().text(), comment, "Comment hasn't been added.");
    }



}