package edu.pitt.softwaretesting.deliverable3.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

//As a user
//I want to manage my shopping cart
//So that I can change items I will buy

public class testAmazonShoppingCart {

	static private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.firefox.bin", "D:\\Mozilla Firefox\\firefox.exe");  
		driver = new FirefoxDriver();
		driver.get("http://www.amazon.com/gp/cart/view.html/ref=nav_cart");
	}

	//	Scenario1: add one item into the shopping cart
	//	Given the shopping cart is empty and I am on the site of first result searching "speedo swim cap"
	//	When I choose black color and one quantity 
	//	And add it to the cart
	//	Then the count of shopping cart should be 1 and this item should appear in the shopping cart

	@Test
	public void testAddItem(){
        try {
        	driver.findElement(By.id("sc-list-body"));
        	fail();
        } catch (NoSuchElementException nseex) { }
        

		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("speedo swim cap");
		driver.findElement(By.cssSelector("input.nav-input")).click();
		driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2/strong[2]")).click();
		driver.findElement(By.id("a-autoid-8-announce")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("nav-cart-count")).click();

		String actualCount = driver.findElement(By.id("nav-cart-count")).getText();
		assertEquals("1", actualCount);

	}

	//	Scenario2: delete the item from the shopping cart
	//	Given the item of first result searching "speedo swim cap" is in the shopping cart
	//	When I delete this item from the cart
	//	Then this item should be removed and show a removed message "speedo silicone solid swim cap, black was removed from shopping cart"(这一小块也是不会可以删）, and the count of shopping cart should be 0

	@Test
	public void testDeleteItem(){

	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
