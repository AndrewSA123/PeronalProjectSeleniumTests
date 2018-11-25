package com.qa.PersonalProjectsSeleniumTests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTests {
	
	WebDriver driver;
	String url;
	
	
	@Before
	public void setup() {
		url = "http://35.242.149.138:3000/";
		System.setProperty("webdriver.chrome.driver", "F:\\Useful Stuff\\QAGit\\PeronalProjectSeleniumTests\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test
	public void AddMovieTest() throws InterruptedException {
		driver.manage().window().maximize();
		driver.get(url);
		driver.findElement(By.xpath("//*[@id=\"CreateButton\"]")).click();
		WebElement TitleText = driver.findElement(By.id("titleInput"));
		WebElement SubmitMovie = driver.findElement(By.xpath("//*[@id=\"SubmitButton\"]"));
		TitleText.sendKeys("Avengers Infinity War");
		SubmitMovie.click();
		WebElement success = driver.findElement(By.xpath("//*[@id=\"tables\"]/div/div[1]/div[2]/div[2]/table/tbody/tr[13]/td[3]"));
		assertEquals("Avengers Infinity War", success.getAttribute("innerHTML"));
	}

}
