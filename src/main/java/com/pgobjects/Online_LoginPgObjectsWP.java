package com.pgobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;






public class Online_LoginPgObjectsWP{
	WebDriver driver;
	public Online_LoginPgObjectsWP(WebDriver driver){
		super();
		this.driver = driver;
	}
	
	
	
	
	
	public void clickLogInBtn(){
		WebElement loginbtn=driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin"));
		loginbtn.click();
	}
	public void enterIRID(String value){
		WebElement ir=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTCO"));
		ir.sendKeys(value);
	}
	public void enterPassword(String value){
		WebElement password=driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword"));
		password.sendKeys(value);
	}
}
