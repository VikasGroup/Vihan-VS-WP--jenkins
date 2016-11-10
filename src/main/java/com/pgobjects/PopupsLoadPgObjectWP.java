package com.pgobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PopupsLoadPgObjectWP{
	WebDriver driver;

	public PopupsLoadPgObjectWP(WebDriver driver){
		super();
		this.driver = driver;
	}
	public void closePop(){
		WebElement closetab=driver.findElement(By.xpath(".//*[@id='ctl00_objHTML']/body/div[3]/div/div/a"));
		closetab.click();
	}
public void clickShoNow(){
	WebElement shopnowbtn=driver.findElement(By.id("ctl00_TabMenu1_lbnShopNow"));
	shopnowbtn.click();
}

}
