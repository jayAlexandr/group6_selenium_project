package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalendarPage {
    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "(//div[@class='trigger']/button[starts-with(@aria-controls, 'menu-')])[1]")
    public WebElement selectionView;
    @FindBy(xpath = "//button[.//span[@class='action-button__text' and text()='Day']]")
    public WebElement daySelection;
    @FindBy(xpath = "//button[.//span[@class='action-button__text' and text()='Week']]")
    public WebElement weekSelection;
    @FindBy(xpath = "//button[.//span[@class='action-button__text' and text()='Month']]")
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
    @FindBy(xpath = "//div[@class='event-popover__buttons']/button[1]")
    public WebElement moreButton;
    @FindBy(xpath = "(//button[@aria-label='Actions'])[6]")
    public WebElement actionsButton;
    @FindBy(xpath = "//span[.='Delete']")
    public WebElement deleteButton;


    public void clickDateCell(String date) {
        String xpath = "//td[@title='" + date + "']";
        WebElement dateCell = Driver.getDriver().findElement(By.xpath(xpath));
        BrowserUtils.waitForClickablility(dateCell, 10);
        dateCell.click();
    }

    public void openViewSelectionMenu() {
        BrowserUtils.waitForClickablility(selectionView, 10);
        selectionView.click();
    }

    public void selectDayView() {
        BrowserUtils.waitForClickablility(daySelection, 10);
        daySelection.click();
    }

    public void selectWeekView() {
        BrowserUtils.waitForClickablility(weekSelection, 10);
        weekSelection.click();
    }

    public void selectMonthView() {
        BrowserUtils.waitForClickablility(monthSelection, 10);
        monthSelection.click();
    }

    public void selectPersonalEventsView() {
        BrowserUtils.waitForClickablility(monthSelection, 10);
        personalEvents.click();
    }


    public boolean isCalendarViewDisplayed(String view) {
        String expectedViewClass = switch (view.toLowerCase()) {
            case "day" -> "fc-timeGridDay-view";
            case "week" -> "fc-timeGridWeek-view";
            case "month" -> "fc-dayGridMonth-view";
            default -> throw new IllegalArgumentException("Invalid view: " + view);
        };

        WebElement container = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div.fc-view")));

        return container.getDomAttribute("class").contains(expectedViewClass);
    }

    public void selectCalendarView(String view) {


        switch (view.toLowerCase()) {
            case "day":
                BrowserUtils.waitForClickablility(daySelection, 10).click();
                break;
            case "week":
                BrowserUtils.waitForClickablility(weekSelection, 10).click();
                break;
            case "month":
                BrowserUtils.waitForClickablility(monthSelection, 10).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid view: " + view);
        }
    }




}







