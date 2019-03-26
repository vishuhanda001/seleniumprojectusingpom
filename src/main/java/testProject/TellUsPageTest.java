package testProject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TellUsPageTest extends LearnMorePageTest {

	@FindBy(xpath = "//div[@class='main_title_all wow  flash  animated']/h2[1]")
	WebElement contactusTitle;

	@FindBy(xpath = "//section[@class='contact_form_fill']/div[@class='container' and 1]/div[@class='sub_titles' and 1]/h2[1]")
	WebElement contactusFormTitle;

	
	public void setupTest() {
		initializeDriver();
		PageFactory.initElements(driver, this);
		tellUsClickTest();

	}


	public void tellUsContactTitleTest() {
		Assert.assertEquals(contactusTitle.getText(), "CONTACT");
	}

	
	public void tellUsContactFormTitleTest() {
		Assert.assertEquals(contactusFormTitle.getText(), "CONTACT FORM");
	}

	
	
}
