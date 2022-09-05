package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.TestPage;
import util.BrowserFactory;

public class TestNGPageTest{
	
	WebDriver driver;
	@Test
	public void testNGPageTest() {
		driver = BrowserFactory.init();

		
		TestPage testPage = PageFactory.initElements(driver, TestPage.class);

		testPage.addCategoryField("Tagore");
		testPage.clickOnAddCategoryButton();
		testPage.assertion();
		testPage.clickOnNevermindButton();
		testPage.clickDueDateMonthsDropdown();
		
		
		BrowserFactory.tearDown();
	}

}
