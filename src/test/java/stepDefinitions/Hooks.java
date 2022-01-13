package stepDefinitions;

import DevigetAPI_Automation.DevigetAPI_Automation.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseTest {

	@Before
	public void startDriver() {
		getDriver();
	}

	@After
	public void closeDriver(Scenario scenario) {

		getScreenShot(scenario);
		driver.quit();

	}
}
