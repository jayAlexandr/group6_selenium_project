package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CalendarPage {
    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//button[starts-with(@aria-controls, 'menu-')])[1]")
    public WebElement selectionView;
    @FindBy(xpath = "//span[.='Day']")
    public WebElement daySelection;
    @FindBy(xpath = "//span[.='Week']")
    public WebElement weekSelection;
    @FindBy(xpath = "//span[.='Month']")
    public WebElement monthSelection;
    @FindBy(xpath = "//li[contains(@class, 'draggable-calendar-list-item')]")
    public WebElement personalEvents;
    @FindBy(xpath = "//button[@class='button primary new-event']")
    public WebElement newEventButton;
    @FindBy(xpath = "//label[@for='allDay']")
    public WebElement allDayCheckBox;
    @FindBy(xpath = "//input[@placeholder='Event title']")
    public WebElement eventTitle;
    @FindBy(xpath = "//button[@class='primary']")
    public WebElement saveButton;
    @FindBy(xpath = "//div[@class='mx-datepicker'][1]")
    public WebElement selectDate;



}
