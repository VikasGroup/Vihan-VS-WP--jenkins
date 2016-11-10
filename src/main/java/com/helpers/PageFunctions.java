package com.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageFunctions {
	
	public static boolean checkPageIsReady(WebDriver driver) {
		boolean  result = false;
		  JavascriptExecutor js = (JavascriptExecutor)driver;
		  
		  //Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete")){ 
		   //logger.info(page+" Is loaded.");
		   result = true;
		   return result ; 
		  } 
		  
		  //This loop will rotate for 25 times to check If page Is ready after every 1 second.
		  //You can replace your value with 25 If you wants to Increase or decrease wait time.
		  for (int i=0; i<25; i++){ 
		   try {
		    Thread.sleep(100);
		    }catch (InterruptedException e) {} 
		   //To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")){ 
			   result = true;
		    break; 
		   }   
		  }
		  return result;
		  
		 }	
}
