package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TalkModulePage extends BasePage {

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

    @FindBy(xpath = "//input[@placeholder='Add participants to the conversation']")
    public WebElement addParticipantInputBox;

    @FindBy(xpath = "//li[contains(@class,'participant-row')]")
    public List<WebElement> participantsListAfterAdded;

    @FindBy(xpath = "//li[@class='app-navigation-hint']")
    public WebElement noSearchResult;

    @FindBy(xpath = "//span[@class='icon icon-start-call']")
    public WebElement callButton;

    @FindBy(xpath = "//span[@class='acli__content__line-two__subtitle'][1]")
    public WebElement youStartedCallMessage;

    @FindBy(xpath = "//button[@class='top-bar__button error top-bar__button']")
    public WebElement leaveCallButton;

    @FindBy(xpath = "//a[@aria-controls='app-navigation-vue']")
    public WebElement threeBars;

    @FindBy(xpath = "//span[@class='acli__content__line-one__title'][1]")
    public WebElement groupName;

    @FindBy(xpath = "//button[@aria-label='Conversation settings']")
    public List<WebElement> threeVerticalDots;

    @FindBy(xpath = "//span[contains(text(),'Delete conversation')]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[contains(text(),'No')]")
    public WebElement declinedButton;

    @FindBy(xpath = "//button[@class='primary']")
    public WebElement confirmDelete;

    @FindBy(xpath = "//input[@placeholder='Search conversations or users']")
    public WebElement searchConversationInputBox;

    @FindBy(xpath = "//li[@class='app-navigation-hint']")
    public WebElement noMatchesMessage;
}
