package com.uiplayground;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComplexTableAutomation {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("http://uiplayground.techwithjatin.com/");
		wd.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(20));
		By complexTableMenuLocator = By.xpath("//span[text()='Complex Table']/..");
		WebElement complexTableMenu = wait
				.until(ExpectedConditions.visibilityOfElementLocated(complexTableMenuLocator));
		complexTableMenu.click();
		By employeetableLocator = By.xpath("//table[@data-testid='data-table']");
		WebElement employeetable = wait.until(ExpectedConditions.visibilityOfElementLocated(employeetableLocator));
		WebElement tablebody = employeetable.findElement(By.xpath(".//tbody"));
		List<WebElement> tablerowlist = tablebody.findElements(By.xpath(".//tr"));
		System.out.println(tablerowlist.size());
		List<Employee> employeelist = new ArrayList<>();
		for (WebElement tablerow : tablerowlist) {
			List<WebElement> tabledatalist = tablerow.findElements(By.xpath(".//td"));
			Employee employee = new Employee(tabledatalist.get(1).getText(), tabledatalist.get(2).getText(),
					tabledatalist.get(3).getText(), tabledatalist.get(4).getText(), tabledatalist.get(5).getText(),
					tabledatalist.get(6).getText(), tabledatalist.get(7).getText());
			employeelist.add(employee);

		}
		System.out.println(employeelist);
		// task 2
		By filterTextboxLocator = By.xpath("//input[@data-testid='table-filter']");
		WebElement filterTextbox = wait.until(ExpectedConditions.visibilityOfElementLocated(filterTextboxLocator));
		filterTextbox.sendKeys("SDET");
		List<WebElement> newtablerowlist = tablebody.findElements(By.xpath(".//tr"));
		System.out.println(newtablerowlist.size());
		List<Employee> newemployeelist = new ArrayList<>();
		for (WebElement tablerow : newtablerowlist) {
			List<WebElement> tabledatalist = tablerow.findElements(By.xpath(".//td"));
			Employee employee = new Employee(tabledatalist.get(1).getText(), tabledatalist.get(2).getText(),
					tabledatalist.get(3).getText(), tabledatalist.get(4).getText(), tabledatalist.get(5).getText(),
					tabledatalist.get(6).getText(), tabledatalist.get(7).getText());
			newemployeelist.add(employee);

		}
		for (Employee emp : newemployeelist) {
			System.out.println(emp.getName() + "\t" + emp.getCompany());
		}

		// task 3
		filterTextbox.click();
		filterTextbox.sendKeys(Keys.CONTROL,"a");
		filterTextbox.sendKeys(Keys.BACK_SPACE);
		By sortSalaraylocator = By.xpath("//th[@data-testid='th-salary']");
		WebElement sortSalary = wait.until(ExpectedConditions.visibilityOfElementLocated(sortSalaraylocator));
		sortSalary.click();
		sortSalary.click();
		newtablerowlist = tablebody.findElements(By.xpath(".//tr"));
		System.out.println(newtablerowlist.size());
		List<Employee> newsortedemployeelist = new ArrayList<>();
		for (WebElement tablerow : newtablerowlist) {
			List<WebElement> tabledatalist = tablerow.findElements(By.xpath(".//td"));
			Employee employee = new Employee(tabledatalist.get(1).getText(), tabledatalist.get(2).getText(),
					tabledatalist.get(3).getText(), tabledatalist.get(4).getText(), tabledatalist.get(5).getText(),
					tabledatalist.get(6).getText(), tabledatalist.get(7).getText());
			newsortedemployeelist.add(employee);

		}
		for(int i=0;i<3;i++) {
			System.out.println(newsortedemployeelist.get(i).getName() + "\t" + newsortedemployeelist.get(i).getSalary());
		}
		
		By nextbuttonlocator = By.xpath("//button[@data-testid='btn-next']");
		wait.until(ExpectedConditions.elementToBeClickable(nextbuttonlocator)).click();
		List<WebElement> nexttablerowlist = tablebody.findElements(By.xpath(".//tr"));
		System.out.println(nexttablerowlist.size());
		List<Employee> nextemployeelist = new ArrayList<>();
		for (WebElement tablerow : nexttablerowlist) {
			List<WebElement> tabledatalist = tablerow.findElements(By.xpath(".//td"));
			Employee employee = new Employee(tabledatalist.get(1).getText(), tabledatalist.get(2).getText(),
					tabledatalist.get(3).getText(), tabledatalist.get(4).getText(), tabledatalist.get(5).getText(),
					tabledatalist.get(6).getText(), tabledatalist.get(7).getText());
			nextemployeelist.add(employee);

		}
		for(Employee emp:nextemployeelist) {
			System.out.println(emp);
		}
	}

}
