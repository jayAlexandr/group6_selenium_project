package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TalkModulePage extends BasePage{


    @FindBy(xpath = "//button[@aria-label='Create a new group conversation']")
    public WebElement newConversationButton;

    @FindBy(xpath = "//input[@placeholder='Conversation name']")
    public WebElement newConversationInputBox;

    @FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement addParticipantsButton;

    @FindBy(xpath = "//li[@class='participant-row isSearched']")
    public List<WebElement> participantsList;

    @FindBy(xpath = "//button[@class='navigation__button navigation__button-right primary']")
    public WebElement createConversationButton;

    @FindBy(xpath = "//span[@class='acli__content__line-one__title']")
    public List<WebElement> conversationList;

    @FindBy(xpath = "//button[@rel='noreferrer noopener']")
    public WebElement addParticipantsToGroupButton;

    @FindBy(xpath = "//input[@placeholder='Add participants to the conversation']")
    public WebElement addParticipantInputBox;

    @FindBy(xpath = "//li[contains(@class,'participant-row')]")
    public List<WebElement> participantsListAfterAdded;
}
