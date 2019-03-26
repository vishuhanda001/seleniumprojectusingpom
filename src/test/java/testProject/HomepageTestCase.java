package testProject;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomepageTestCase extends Homepagetest {

	@BeforeMethod
	public void setup() {
		setupTest();
	}

	@Test
	public void homePageTitleTestCase() {
		Assert.assertEquals(homePageTitleTest(), "Software Development Company In USA | Appsimity Solution");
	}

	@Test
	public void homePageUrlTestCase() {
		homePageUrl();
	}

	@Test
	public void clickOnLearnMoreTestCase() {
		clickOnLearnMoreTest();

	}

	@AfterMethod
	public void teardown() {
		closeDriver();
	}

}
