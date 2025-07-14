package collation.Defender;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteOperation extends BaseClassSetup {
	
	private By back=By.xpath("//button[@title=\"Click to Go Back to List\"]");
	private By Dedata=By.xpath("//button[@title=\"Delete Record\"]");
	private By Delpopups=By.xpath("//button[normalize-space()='Yes']");
	 
	public DeleteOperation() {
		PageFactory.initElements(driver, this);
	}
	
	 public void DeleteIndividual() throws InterruptedException {
		 
		 WebDriverWait wait = new WebDriverWait(driver, 30);
		 WebElement backbuttons = wait.until(ExpectedConditions.visibilityOfElementLocated(back));
		 backbuttons.click();		 
		 WebElement Delbuttons = wait.until(ExpectedConditions.visibilityOfElementLocated(Dedata));
		 Delbuttons.click();
		 WebElement Delpopup = wait.until(ExpectedConditions.visibilityOfElementLocated(Delpopups));
		 Delpopup.click();
		 Thread.sleep(2000);
	 }
}
