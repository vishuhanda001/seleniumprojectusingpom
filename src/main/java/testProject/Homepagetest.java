package testProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Homepagetest extends BaseClass {

	@FindBy(xpath = "//button[@class='focus_default_button']")
	WebElement learnMoreBtn;

	public void setupTest() {
		initializeDriver();
		PageFactory.initElements(driver, this);
	}

	public String homePageTitleTest() {
//		Assert.assertEquals(getTitle(), "Software Development Company In USA | Appsimity Solutio");
		return getTitle();
	}

	public void homePageUrl() {
		System.out.println(getUrl());
	}

	public void clickOnLearnMoreTest() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)");
		clickElementWhenVisible(this.learnMoreBtn).click();
	}
	
	


}
