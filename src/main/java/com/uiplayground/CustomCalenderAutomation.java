package com.uiplayground;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomCalenderAutomation {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
		By customcalenderrMenuLocator = By.xpath("//span[text()='Custom Calendar']/..");
		WebElement customCalender = wait.until(ExpectedConditions.elementToBeClickable(customcalenderrMenuLocator));
		customCalender.click();
		By dateInputLoactor = By.id("date-input");
		WebElement dateInput = wait.until(ExpectedConditions.elementToBeClickable(dateInputLoactor));
		dateInput.click();
		By monthLocator = By.className("dp-header-title");
		WebElement month = wait.until(ExpectedConditions.visibilityOfElementLocated(monthLocator));
		System.out.println(month.getText());
		By nextMonthbuttonLocator = By.xpath("//button[@data-testid='btn-next-month']");
		WebElement nextmonthButton = wait.until(ExpectedConditions.elementToBeClickable(nextMonthbuttonLocator));
		nextmonthButton.click();
		By availableDateLocator = By.xpath("//td[contains(@class,'dp-day-available')]");
		List<WebElement> availabledates = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(availableDateLocator));
		System.out.println(availabledates.size());
		availabledates.get(6).click();
		String selectedDate = wait.until(ExpectedConditions.visibilityOfElementLocated(dateInputLoactor))
				.getAttribute("value");
		System.out.println(selectedDate);

		// task 2
		dateInput = wait.until(ExpectedConditions.elementToBeClickable(dateInputLoactor));
		dateInput.click();
		By disabledDateLocator = By.cssSelector("td.dp-day-disabled");
		List<WebElement> disabledDates = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(disabledDateLocator));
		for (WebElement date : disabledDates) {
			System.out.println(date.getText());
		}
		disabledDates.get(0).click();
		selectedDate = wait.until(ExpectedConditions.visibilityOfElementLocated(dateInputLoactor))
				.getAttribute("value");
		System.out.println(selectedDate);
		availabledates = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(availableDateLocator));
		System.out.println(availabledates.size());

		// task 3

		By DateRangeLocator = By.id("btn-range-mode");
		WebElement DateRange = wait.until(ExpectedConditions.elementToBeClickable(DateRangeLocator));
		DateRange.click();
		By startDateLocator = By.id("range-input-start");
		WebElement startDate =wait.until(ExpectedConditions.elementToBeClickable(startDateLocator));
		startDate.click();
		By selectAvailableDatesLocator = By.xpath("//td[contains(@class,'dp-day-available')]");
		List<WebElement> availablesDates =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selectAvailableDatesLocator));
		availablesDates.get(4).click();
		By selectEndDatesLocator = By.xpath("//td[contains(@class,'dp-day-available')]");
		List<WebElement> selectEndDates =wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(selectEndDatesLocator));
		selectEndDates.get(18).click();
		By selectedStartDateLocator = By.xpath("//div[@data-testid='range-start']");
		WebElement selectedDateView =wait.until(ExpectedConditions.visibilityOfElementLocated(selectedStartDateLocator));
		System.out.println(selectedDateView.getText());
		By selectedEndDateLocator = By.xpath("//div[@data-testid='range-end']");
		WebElement selectedEndDate =wait.until(ExpectedConditions.visibilityOfElementLocated(selectedEndDateLocator));
		System.out.println(selectedEndDate.getText());
		
		
		
		
	}

}
