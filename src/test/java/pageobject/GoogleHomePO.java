package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import driver.DriverFactory;

public class GoogleHomePO extends LoadableComponent<GoogleHomePO>{
	
	@FindBy(css = "input[name='q']")
	private WebElement searchTextBox;
	
	@FindBy(css="div[class='FPdoLc VlcLAe'] input[name='btnK']")
	private WebElement searchButton;
	
	@FindBy(css="img[alt='Google']")
	private WebElement googleImage;	
	
	public GoogleHomePO() {
		DriverFactory.getDriver().get("https://www.google.com/");
		PageFactory.initElements(DriverFactory.getDriver(), this);
	}

	public GoogleSearchPO performSearch(String search) {
		searchTextBox.sendKeys(search);
		googleImage.click();
		searchButton.click();
		return new GoogleSearchPO();
	}

	@Override
	protected void load() {
	}

	@Override
	protected void isLoaded() throws Error {
		
	}
}
