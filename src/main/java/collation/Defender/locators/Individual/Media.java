package collation.Defender.locators.Individual;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import collation.Defender.BaseClassSetup;
import collation.Defender.DropDown;
import collation.Defender.DynamicSelectDropdown;
import collation.Defender.LoginPage;

public class Media extends BaseClassSetup{
	
	LoginPage log;
	DropDown eve;
	DynamicSelectDropdown dndropdown;
	
	private By menu=By.xpath("//li[@id=\"menus\"]/a/span");	
	private By collation=By.xpath("//span[normalize-space()='Collation']");
	private By Individual=By.xpath("//span[normalize-space()='Individual Master']");
	private By inputsearch=By.xpath("//kendo-textbox[@placeholder=\"Search in selected column...\"]/input");
	private By edit=By.xpath("//button[@title=\"Edit Record\"]");
	private By filenm=By.xpath("//input[@id='filename']");
	private By filevr=By.xpath("//input[@id='fileversion']");
	private By save=By.xpath("(//button[@class='btn btn-theme form_button ms-3 ng-star-inserted'])[1]");
	
	private By back=By.xpath("//button[@title=\"Click to Go Back to List\"]");
	
	public Media() {
		PageFactory.initElements(driver, this);
	}
	
	public void Medialocators() throws InterruptedException {
		log=new LoginPage();
		eve=new DropDown();
		dndropdown=new DynamicSelectDropdown();
		//log.signin(prop.getProperty("username"), prop.getProperty("password"));
		WebDriverWait wait = new WebDriverWait(driver, 30);
//        WebElement menus = wait.until(ExpectedConditions.visibilityOfElementLocated(menu));
//        menus.click();
//        WebElement collations = wait.until(ExpectedConditions.visibilityOfElementLocated(collation));
//        collations.click();
//        WebElement Indivisuals = wait.until(ExpectedConditions.visibilityOfElementLocated(Individual));
//        Indivisuals.click();       
//        eve.kendodropdownlist("displayName", "Name & Alias");   
//		WebElement inputsearchs = wait.until(ExpectedConditions.visibilityOfElementLocated(inputsearch));
//		inputsearchs.click();
//		inputsearchs.sendKeys("p");
		
		//Extra added
		WebElement backbuttons = wait.until(ExpectedConditions.visibilityOfElementLocated(back));
		backbuttons.click();
		//End here
		
		WebElement edits = wait.until(ExpectedConditions.visibilityOfElementLocated(edit));
		edits.click();
		eve.kendotabstriptab("Media");
		WebElement filename = wait.until(ExpectedConditions.visibilityOfElementLocated(filenm));
		filename.clear();
		filename.sendKeys(DynamicSelectDropdown.name());
		WebElement filever = wait.until(ExpectedConditions.visibilityOfElementLocated(filevr));
		filever.clear();
		filever.sendKeys(eve.random());
		dndropdown.kendodropdownlist("filetype");
		WebElement saves = wait.until(ExpectedConditions.visibilityOfElementLocated(save));
		saves.click();
		eve.validate();
		Thread.sleep(1000);
		dndropdown.autoselecttable(driver, "presentation", 3);
		WebElement filenames = wait.until(ExpectedConditions.visibilityOfElementLocated(filenm));
		filenames.clear();
		filenames.sendKeys(DynamicSelectDropdown.name());
		WebElement saveas = wait.until(ExpectedConditions.visibilityOfElementLocated(save));
		saveas.click();
		//eve.validate();
		
	}
}
