package collation.Defender.locators.Organization;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import collation.Defender.BaseClassSetup;
import collation.Defender.DropDown;
import collation.Defender.DynamicSelectDropdown;
import collation.Defender.LoginPage;

public class OrgAssets extends BaseClassSetup{
	
	LoginPage log;
	DropDown eve;
	DynamicSelectDropdown dndropdown;
	
//	private By menu=By.xpath("//li[@id=\"menus\"]/a/span");	
//	private By collation=By.xpath("//span[normalize-space()='Collation']");
//	private By Organization=By.xpath("//span[normalize-space()='Organization Master']");
	private By editselect=By.xpath("//i[@class='far fa-edit']");
//	private By inputsearch=By.xpath("//kendo-textbox[@placeholder=\"Search in selected column...\"]/input");
	private By save=By.xpath("//div[@class=\"ng-star-inserted\"]/button[@type=\"submit\"]");

	
	private By back=By.xpath("//button[normalize-space()='Back To List']");
	
	public OrgAssets() {
		PageFactory.initElements(driver, this);
	}
	
	public void OrgAssetslocators() throws InterruptedException, IOException {
		
		try {
		log=new LoginPage();
		eve=new DropDown();
		dndropdown=new DynamicSelectDropdown();
//		log.signin(prop.getProperty("username"), prop.getProperty("password"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
//		WebElement menus = wait.until(ExpectedConditions.visibilityOfElementLocated(menu));
//	    menus.click();
//	    WebElement collations = wait.until(ExpectedConditions.visibilityOfElementLocated(collation));
//	    collations.click();
//	    WebElement Organizations = wait.until(ExpectedConditions.visibilityOfElementLocated(Organization));
//	    Organizations.click();  
//	    eve.kendodropdownlist("displayName", "Name & Alias");
//	  	WebElement searchinput = wait.until(ExpectedConditions.visibilityOfElementLocated(inputsearch));
//	  	searchinput.click();
//	  	searchinput.sendKeys("Abdullah Azzam Brigades-Personnel");
		
		//Extra added
		WebElement backbuttons = wait.until(ExpectedConditions.visibilityOfElementLocated(back));
		backbuttons.click();
		//End here
		
	  	WebElement editinput = wait.until(ExpectedConditions.visibilityOfElementLocated(editselect));
	  	editinput.click();
	  	eve.kendotabstriptab("Assets");
	  	eve.kendosearchbar("assettype", "Cash");
		eve.kendodropdowntree("assetcategory", "Cash 2");
		eve.kendosearchbar("assetid", "Bundle");
		dndropdown.kendocombobox("assetstatus");
		eve.calender("statusdate", "15");
		WebElement saves = wait.until(ExpectedConditions.visibilityOfElementLocated(save));
		saves.click();
		//eve.validate();
		Thread.sleep(1000);
		dndropdown.autoselecttable(driver, "presentation", 5);
		dndropdown.kendocombobox("assetstatus");
		eve.calender("statusdate", "25");
		WebElement saveas = wait.until(ExpectedConditions.visibilityOfElementLocated(save));
		saveas.click();
		//eve.validate();
		
		}
		catch (Exception e) {
		    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(screenshot, new File("screenshots/failure_" + System.currentTimeMillis() + ".png"));
		    e.printStackTrace();
		}
	}

}
