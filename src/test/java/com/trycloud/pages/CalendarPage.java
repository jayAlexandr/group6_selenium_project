package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class CalendarPage {
    public CalendarPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //Elements of the page
    @FindBy(xpath = "//button[contains(@class, 'action-item__menutoggle') and contains(@class, 'icon-view-module')]")
    public WebElement selectionView;

    @FindBy(xpath = "//button[.//span[@class='action-button__text' and text()='Day']]")
    public WebElement daySelection;

    @FindBy(xpath = "//button[.//span[@class='action-button__text' and text()='Week']]")
    public WebElement weekSelection;

    @FindBy(xpath = "//button[.//span[@class='action-button__text' and text()='Month']]")
    public WebElement monthSelection;

    @FindBy(xpath = "//li[contains(@class, 'draggable-calendar-list-item')]")
    public WebElement personalEvents;

    @FindBy(xpath = "//button[contains(text(), 'New event') or @aria-label='New event']")
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

    //Methods

    /** Clicks the "New event" button */
    public void clickNewEventButton() {
        BrowserUtils.waitForClickablility(newEventButton, 10).click();
    }

    /** Clicks a date cell based on its title (in this case dates from the feature file) */
    public void clickDateCell(String date) {
        WebElement dateCell = Driver.getDriver().findElement(By.xpath("//td[@title='" + date + "']"));
        BrowserUtils.waitForClickablility(dateCell, 10).click();
    }

    /** Selects the All Day checkbox in the event form */
    public void selectAllDayCheckbox() {
        BrowserUtils.waitForClickablility(allDayCheckBox, 10).click();
    }

    /** Opens the calendar view selection dropdown */
    public void openViewSelectionMenu() {
        BrowserUtils.waitForClickablility(selectionView, 10).click();
    }

    /** Selects the Month view */
    public void selectMonthView() {
        BrowserUtils.waitForClickablility(monthSelection, 10).click();
    }

    /** Selects the Personal events filter if not already active */
    public void selectPersonalEventsView() {
        BrowserUtils.waitForVisibility(personalEvents, 10);
        if (personalEvents.getDomAttribute("class").contains("disabled")) {
            personalEvents.click();
        }
    }

    /**
     * Verifies if the calendar is currently in the given view mode.
     * @param view "day", "week", or "month"
     */
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

    /**
     * Dynamically selects a calendar view
     * @param view "day", "week", or "month"
     */
    public void selectCalendarView(String view) {
        switch (view.toLowerCase()) {
            case "day" -> BrowserUtils.waitForClickablility(daySelection, 10).click();
            case "week" -> BrowserUtils.waitForClickablility(weekSelection, 10).click();
            case "month" -> BrowserUtils.waitForClickablility(monthSelection, 10).click();
            default -> throw new IllegalArgumentException("Invalid view: " + view);
        }
    }

    /**
     * Checks if a calendar event with a specific title is visible
     * @param eventTitle the title to search
     * @return true if found, false otherwise
     */
    public boolean isEventVisible(String eventTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        try {
            WebElement event = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//*[contains(@class,'fc-event-title')][normalize-space(.)='" + eventTitle + "']")
            ));
            return event.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    /**
     * Deletes an event from the calendar by its title using the More > Actions > Delete flow
     * @param eventTitle the title of the event to delete
     */
    public void deleteEventByTitle(String eventTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

        WebElement event = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[contains(@class,'fc-event-title')][normalize-space(.)='" + eventTitle + "']")
        ));
        event.click();

        wait.until(ExpectedConditions.elementToBeClickable(moreButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(actionsButton)).click();
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();

        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Driver.getDriver().switchTo().alert().accept();
        } catch (TimeoutException ignored) {
            // Alert not present, continue
        }
    }
    /**
     * Verifies that an event with the given title is not visible.
     * Fails immediately if the event is still found.
     */
    public void verifyEventIsNotVisible(String eventTitle) {
        By eventLocator = By.xpath("//*[contains(@class,'fc-event-title')][normalize-space(.)='" + eventTitle + "']");

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        boolean disappeared = wait.until(ExpectedConditions.invisibilityOfElementLocated(eventLocator));

        Assert.assertTrue("Event '" + eventTitle + "' is still visible.", disappeared);
    }



}
