package com.pgobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePgObjectIN{
	WebDriver driver;
	public HomePgObjectIN(WebDriver driver){
		super();
		this.driver = driver;
	}

public void clickIrLogIn(){
	WebElement irlogin=driver.findElement(By.id("ctl00_ctl11_hlLogin"));
	irlogin.click();
}
}
