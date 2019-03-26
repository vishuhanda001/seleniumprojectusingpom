package testProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TellUsTestCase  extends TellUsPageTest{

	

	@BeforeMethod
	public void setup(){
		setupTest();
	}
	
	@Test
	public void tellUsTitleTestCase(){
		tellUsContactFormTitleTest();
	}
	@Test
	public void tellUsreadMainHeadsTestCase(){
		tellUsContactTitleTest();
	}
	
	
	@AfterMethod
	public void tearDown(){
		closeDriver();
	}
	
	
}
