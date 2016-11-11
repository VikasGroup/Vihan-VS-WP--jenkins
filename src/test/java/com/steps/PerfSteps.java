package com.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.helpers.DB;
import com.helpers.ExcelHelper;
import com.helpers.PageFunctions;
import com.pgobjects.HomePgObjectIN;
import com.pgobjects.HomePgObjectWP;
import com.pgobjects.Online_LoginPgObjectsIN;
import com.pgobjects.Online_LoginPgObjectsWP;
import com.pgobjects.PopupsLoadPgObjectIN;
import com.pgobjects.PopupsLoadPgObjectWP;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.write.WritableWorkbook;

public class PerfSteps {
	public static WebDriver driver;
	public double startTime;
	public double endTime,totalTime;
	public static ExcelHelper excelHelper;
	public static String path = "./src/test/resources/reports/";
	public static String reportName = "Vihan vs World Plan Peformance Test";
	public static String sheetName = "Page one";
	public static String table = "time";
	public static int  possition = 0;
	public Map data = new HashMap<String, String>();
	public static DB db;
	public static String RECORD_ID_KEY = "RecordId";
	public static String PUBLIC_SITE_KEY = "publicSite";
	public static String PTOL_KEY = "ptol";
	public static String LTOD_KEY = "ltod";
	public static String VTOP_KEY = "vtop";
	public static String PLAN_KEY = "plan";
	public static String ROUND_KEY = "round";
	public static String WORLD_PLAN = "World Plan";
	public static String VIHAN_PLAN = "Vihan";
	public static String currentTime ;
	public static DateFormat dateFormat;
	public static Date date;
	public PageFunctions pageFunctions;
	public HomePgObjectIN homePgObjectIN;
	public Online_LoginPgObjectsIN online_LoginPgObjectsIN;
	public PopupsLoadPgObjectIN popupsLoadPgObjectIN;
	public HomePgObjectWP homePgObjectWP;
	public Online_LoginPgObjectsWP online_LoginPgObjectsWP;
	public PopupsLoadPgObjectWP popupsLoadPgObjectWP;
	@Before
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		excelHelper = new ExcelHelper(path,reportName,sheetName,possition);
		db = new DB();
		dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		date = new Date();
		currentTime = dateFormat.format(date);
		driver = new ChromeDriver();
	   
	}
	@After
	public void tearDown(){
		driver.close();
	}
	/*-----------------------------------CLEAR DATABASE----------------------------------------------*/

	@Given("^User Clear Database$")
	public  void User_Clear_Database() throws Throwable {
	DB.update("delete from time");
	}
	
	/*-----------------------------------VIHAN TEST----------------------------------------------*/

	@Given("^User opens home page$")
	public void User_opens_home_page() throws Throwable {
		startTime = System.currentTimeMillis();
		driver.get("http://www.qnetindia.in/");
	    endTime = System.currentTimeMillis();
	  
	}

	@Given("^User calculate loard time for vihan Public site \"([^\"]*)\"$")
	public void User_calculate_loard_time_for_vihan_Public_site(String round) throws Throwable {
		 // Express the Regexp above with the code you wish you had
		totalTime=(endTime-startTime)/1000;
		data.put(RECORD_ID_KEY, currentTime);
		data.put(ROUND_KEY, round);
		data.put(PLAN_KEY,VIHAN_PLAN);
		data.put(PUBLIC_SITE_KEY, Double.toString(totalTime));
		db.insert(table, data);
	}
	
	@Given("^User click on login button$")
	public void User_click_on_login_button() throws Throwable {
		homePgObjectIN=new HomePgObjectIN(driver);
		pageFunctions=new PageFunctions();
		homePgObjectIN.clickIrLogIn();
	    startTime = System.currentTimeMillis();
	    if(pageFunctions.checkPageIsReady(driver)){
	    	 endTime = System.currentTimeMillis();
	    } 
	    
	}

	@Given("^User calculate loard time for vihan Public site to Login page$")
	public void User_calculate_loard_time_for_vihan_Public_site_to_Login_page() throws Throwable {
		totalTime=(endTime-startTime)/1000;
		data.put(PTOL_KEY, Double.toString(totalTime));
		db.update(table, data,RECORD_ID_KEY,currentTime);
	    
	}

	@Given("^User enter \"([^\"]*)\" and \"([^\"]*)\" and click on login$")
	public void User_enter_and_and_click_on_login(String user, String pass) throws Throwable {
		online_LoginPgObjectsIN=new Online_LoginPgObjectsIN(driver);
		online_LoginPgObjectsIN.enterIRID(user);
		online_LoginPgObjectsIN.enterPassword(pass);
		online_LoginPgObjectsIN.clickLogInBtn();
		Thread.sleep(10000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs2.get(1)).close();
		//System.out.println("1"+driver.getCurrentUrl());
		driver.switchTo().window(tabs2.get(2)).close();
		//System.out.println("2"+driver.getCurrentUrl());
		driver.switchTo().window(tabs2.get(0));
		System.out.println("0"+driver.getCurrentUrl());
		startTime = System.currentTimeMillis();
		if(pageFunctions.checkPageIsReady(driver)){
	    	 endTime = System.currentTimeMillis();
	    }
	}

	@Given("^User calcuate loard time for vihan Login page to VO Dashboard$")
	public void User_calcuate_loard_time_for_vihan_Login_page_to_VO_Dashboard() throws Throwable {
		totalTime=(endTime-startTime)/1000;
		 data.put(LTOD_KEY, Double.toString(totalTime));
			db.update(table, data,RECORD_ID_KEY,currentTime);
	}

	@When("^User click on shop button$")
	public void User_click_on_shop_button() throws Throwable {
		popupsLoadPgObjectIN= new PopupsLoadPgObjectIN(driver);
		popupsLoadPgObjectIN.clickShoNow();
		startTime = System.currentTimeMillis();
		Set<String> set = driver.getWindowHandles();
		System.out.println("b"+driver.getCurrentUrl());
		driver.switchTo().window((String) set.toArray()[0]);
		
		
		if(pageFunctions.checkPageIsReady(driver)){
	    	 endTime = System.currentTimeMillis();
		}
	}

	@Then("^User calculate loard time for VO Dashboard to products Page$")
	public void User_calculate_loard_time_for_VO_Dashboard_to_products_Page() throws Throwable {
		totalTime=(endTime-startTime)/1000;
		data.put(VTOP_KEY, Double.toString(totalTime));
		db.update(table, data,RECORD_ID_KEY,currentTime);
	}
/*-----------------------------------WORLD PALN----------------------------------------------*/
	@Given("^User opens home page WorldPlan$")
	public void User_opens_home_page_WorldPlan() throws Throwable {
		startTime = System.currentTimeMillis();
		driver.get("http://www.qnet.net/");
	    endTime = System.currentTimeMillis();
	}

	@Given("^User calculate loard time for WorldPlan Public site \"([^\"]*)\"$")
	public void User_calculate_loard_time_for_WorldPlan_Public_site(String round) throws Throwable {
		totalTime=(endTime-startTime)/1000;
		data.put(RECORD_ID_KEY, currentTime);
		data.put(PLAN_KEY,WORLD_PLAN);
		data.put(ROUND_KEY, round);
		data.put(PUBLIC_SITE_KEY, Double.toString(totalTime));
		db.insert(table, data);
	}

	@Given("^User click on login button WorldPlan$")
	public void User_click_on_login_button_WorldPlan() throws Throwable {
		homePgObjectWP=new HomePgObjectWP(driver);
		pageFunctions=new PageFunctions();
		homePgObjectWP.clickIrLogIn();
	    startTime = System.currentTimeMillis();
	    if(pageFunctions.checkPageIsReady(driver)){
	    	 endTime = System.currentTimeMillis();
	    }
	}

	@Given("^User calculate loard time for WorldPlan Public site to Login page$")
	public void User_calculate_loard_time_for_WorldPlan_Public_site_to_Login_page() throws Throwable {
		totalTime=(endTime-startTime)/1000;
		data.put(PTOL_KEY, Double.toString(totalTime));
		db.update(table, data,RECORD_ID_KEY,currentTime);
	}

	@Given("^User enter \"([^\"]*)\" and \"([^\"]*)\" and click on login WorldPlan$")
	public void User_enter_and_and_click_on_login_WorldPlan(String user, String pass) throws Throwable {
		online_LoginPgObjectsWP=new Online_LoginPgObjectsWP(driver);
		online_LoginPgObjectsWP.enterIRID(user);
		online_LoginPgObjectsWP.enterPassword(pass);
		online_LoginPgObjectsWP.clickLogInBtn();
		Thread.sleep(10000);
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		
		/*driver.switchTo().window(tabs2.get(1)).close();
		//System.out.println("1"+driver.getCurrentUrl());
		driver.switchTo().window(tabs2.get(2)).close();
		//System.out.println("2"+driver.getCurrentUrl());
*/		driver.switchTo().window(tabs2.get(0));
		System.out.println("0"+driver.getCurrentUrl());
		startTime = System.currentTimeMillis();
		if(pageFunctions.checkPageIsReady(driver)){
	    	 endTime = System.currentTimeMillis();
	    }
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
	}

	@Given("^User calcuate loard time for WorldPlan Login page to VO Dashboard$")
	public void User_calcuate_loard_time_for_WorldPlan_Login_page_to_VO_Dashboard() throws Throwable {
		totalTime=(endTime-startTime)/1000;
		 data.put(LTOD_KEY, Double.toString(totalTime));
			db.update(table, data,RECORD_ID_KEY,currentTime);
	}

	@When("^User click on shop button WorldPlan$")
	public void User_click_on_shop_button_WorldPlan() throws Throwable {
		popupsLoadPgObjectWP= new PopupsLoadPgObjectWP(driver);
		popupsLoadPgObjectWP.closePop();
		Thread.sleep(3000);
		popupsLoadPgObjectWP.clickShoNow();
		startTime = System.currentTimeMillis();
		Set<String> set = driver.getWindowHandles();
		System.out.println("b"+driver.getCurrentUrl());
		driver.switchTo().window((String) set.toArray()[0]);
		
		
		if(pageFunctions.checkPageIsReady(driver)){
	    	 endTime = System.currentTimeMillis();
		}
	}

	@Then("^User calculate loard time for VO Dashboard to products Page WorldPlan$")
	public void User_calculate_loard_time_for_VO_Dashboard_to_products_Page_WorldPlan() throws Throwable {
		totalTime=(endTime-startTime)/1000;
		data.put(VTOP_KEY, Double.toString(totalTime));
		db.update(table, data,RECORD_ID_KEY,currentTime);
	}

	
/*-----------------------------------REPORT CREATION----------------------------------------------*/
	
	@Given("^User Create the report$")
	public void User_Create_the_report() throws Throwable {
		excelHelper.write();
	    throw new PendingException();
	}

}
