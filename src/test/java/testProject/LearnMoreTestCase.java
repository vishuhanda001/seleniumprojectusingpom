package testProject;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LearnMoreTestCase extends LearnMorePageTest {

	
	@BeforeMethod(groups="learnmorepage")
	public void setup(){
		setupTest();
	}
	
	@Test( groups= "learnmorepage")
	public void learnMoreTitleTestCase(){
//		System.out.println(abc +" -- "+ def);
		LearnMoreTitleTest();
	}
	@Test( )
	public void readMainHeadsTestCase(){
		readMainHeadsTest();
	}
	
	
	@AfterMethod(groups="learnmorepage")
	public void tearDown(){
		closeDriver();
	}
	
	
	
}
