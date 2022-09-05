package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TestPage{
	
WebDriver driver;
	
	public TestPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@FindBy(how = How.XPATH, using = "//input[@name='categorydata']") WebElement ADD_CATEGORY_FIELD_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@value='Add category']") WebElement ADD_CATEGORY_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(), 'Nevermind')]") WebElement NEVERMIND_BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@name='due_month']") WebElement DUEDATE_MONTHS_DROPDOWN_LIST_ELEMENT;
	
	public void addCategoryField(String Value) {
		ADD_CATEGORY_FIELD_ELEMENT.sendKeys(Value);
	}
	
	public void clickOnAddCategoryButton() {
		ADD_CATEGORY_BUTTON_ELEMENT.click();
	}
	
	public void assertion() {
		String duplicateName = driver.findElement(By.tagName("body")).getText();
		String [] arr=duplicateName.split(":");
		String ExpectedText=arr[0].trim();
		Assert.assertEquals(ExpectedText, "The category you want to add already exists");
	}
	
	public void clickOnNevermindButton() {
		NEVERMIND_BUTTON_ELEMENT.click();
	}
	
	public void clickDueDateMonthsDropdown(){
		Select sel = new Select(DUEDATE_MONTHS_DROPDOWN_LIST_ELEMENT);
		List<WebElement> fullList = sel.getOptions();{
		for (WebElement i : fullList) {
			System.out.println(i.getText());
		}
		
		}
	}


}
