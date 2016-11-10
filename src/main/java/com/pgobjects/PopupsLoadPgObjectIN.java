package com.pgobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupsLoadPgObjectIN{
	WebDriver driver;

	public PopupsLoadPgObjectIN(WebDriver driver){
		super();
		this.driver = driver;
	}
	
public void clickShoNow(){
	WebElement shopnowbtn=driver.findElement(By.id("ctl00_TabMenu1_lbnShopNow"));
	shopnowbtn.click();
}

}
