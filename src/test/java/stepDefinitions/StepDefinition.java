package stepDefinitions;

import org.junit.runner.RunWith;

import DevigetAPI_Automation.DevigetAPI_Automation.BaseTest;
import DevigetAPI_Automation.DevigetAPI_Automation.ValidateNASAAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class StepDefinition extends BaseTest {

	ValidateNASAAPI nasa = new ValidateNASAAPI();

	@Given("^User launches the API \"([^\"]*)\" and validates if API is launched$")
	public void user_launches_the_api_something_and_validates_if_api_is_launched(String strArg1) throws Throwable {

		nasa.validateNasaAPILaunch(strArg1);

	}

	@Then("^Retrieve the first 10 Mars photos made by Curiosity on 1000 Martian sol$")
	public void retrieve_the_first_10_mars_photos_made_by_something_on_1000_martian_sol() {

		nasa.validateAPIOutput();

	}

	@Given("^User is on the API page and converts 1000 sol to earth date$")
	public void user_is_on_the_api_page_and_converts_1000_sol_to_earth_date() throws Throwable {
		
	}

	@Then("^Retrieve the first 10 Mars photos made by Curiosity with Earth date equals 1000 sol$")
	public void retrieve_the_first_10_mars_photos_made_by_curiosity_with_earth_date_equals_1000_sol() throws Throwable {
		
	}

}