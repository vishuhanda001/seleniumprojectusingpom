package testProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LearnMorePageTest extends Homepagetest {

	@FindBy(xpath = "//div[1]/div[@class='blog_one_view_text' and 2]/div[@class='blog_one_view_text_detail' and 1]/h3[1]")
	WebElement whoweare;

	@FindBy(xpath = "//div[@id='main_slider']/div[@class='blog_one_view_text' and 2]/div[@class='blog_one_view_text_detail' and 1]/h3[1]")
	WebElement ourideology;

	@FindBy(xpath = "//div[3]/div[@class='blog_one_view_text' and 2]/div[@class='blog_one_view_text_detail' and 1]/h3[1]")
	WebElement ourfocus;

	@FindBy(xpath="//div[@class='col-md-6']/a[1]/button[1]")
	WebElement tellusbtn;
	
	public void setupTest() {
		initializeDriver();
		PageFactory.initElements(driver, this);
		clickOnLearnMoreTest();
	}

	public void LearnMoreTitleTest() {
		Assert.assertEquals(this.getTitle(), "Best Mobile App and Web Development Company | Appsimity");
	}

	public void readMainHeadsTest() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(whoweare.getText(),"WHO WE ARE");
		softAssert.assertEquals(ourideology.getText(),"OUR IDEOLOGY");
		softAssert.assertEquals(ourfocus.getText(),"OUR FOCUS");
	 softAssert.assertAll();
		
		
		Assert.assertEquals(whoweare.getText(),"WHO WE ARE");
		softAssert.assertAll();
	}
	
	public void tellUsClickTest() {
		clickElementWhenVisible(tellusbtn).click();
	}

}
