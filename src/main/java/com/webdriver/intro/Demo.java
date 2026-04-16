package com.webdriver.intro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver();
		wd.get("https://www.google.com");
		String pageTitle = wd.getTitle();
		System.out.println(pageTitle);
		String pageResource = wd.getPageSource();
		System.out.println(pageResource);
		String currentUrl = wd.getCurrentUrl();
		System.out.println(currentUrl);
	}
}
