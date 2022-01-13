package DevigetAPI_Automation.DevigetAPI_Automation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.json.JSONObject;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.Scenario;
import io.restassured.path.json.JsonPath;

public class ValidateNASAAPI extends BaseTest {

	@FindBy(xpath = "//pre[contains(@style,'word-wrap')]")
	WebElement outputAPI;

	public ValidateNASAAPI() {

		PageFactory.initElements(driver, this);

	}

	public boolean validateNasaAPILaunch(String strArg1) {

		boolean blnRtnVal = false;
		try {
			driver.get(strArg1);
			Assert.assertTrue(outputAPI.isDisplayed());
			blnRtnVal = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return blnRtnVal;

	}

	public boolean validateAPIOutput() {
		int intValCtr = 0;
		boolean blnRtnVal = false;
		try {
			String strJsonReponse = outputAPI.getText();
			JSONObject jsonObject = new JSONObject(strJsonReponse);

			JsonPath js = new JsonPath(jsonObject.toString());
			String strID = js.getString("photos.id");
			int intLength = strID.length();
			ArrayList<String> MarsPhotos = new ArrayList<String>();

			for (int i = 0; i < intLength; i++) {

				String strSol = js.getString("photos.sol[" + i + "]").trim();
				String strRoverName = js.getString("photos.rover[" + i + "].name").trim();

				if (strSol.equals("1000") && strRoverName.equals("Curiosity")) {
					intValCtr++;
					MarsPhotos.add(js.getString("photos.img_src[" + i + "]"));
					if (intValCtr == 10) {
						break;
					}
				}
			}

			System.out.println(MarsPhotos);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return blnRtnVal;
	}

	public boolean getEarthDate() {
		boolean blnRtnVal = false;
		// converting sol to earth days
		String days = String.valueOf(1000 * 1.028);
		Date date;
		try {
			date = new SimpleDateFormat("D").parse(days);

			Date date2 = new SimpleDateFormat("yyyy-MM-dd")
					.parse("1028" + " " + Calendar.getInstance().get(Calendar.YEAR));
			System.out.println(date);
			System.out.println(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return blnRtnVal;
	}
}
