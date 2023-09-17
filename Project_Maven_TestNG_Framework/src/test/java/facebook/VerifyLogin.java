package facebook;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import applicationLibrary.LoginPage;
import core.GlobalData;
import core.MySQLConnection;
import core.ReadPropertiesFile;
import core.Report;
import core.WebControls;
import core.WebDriverHelper;
import objectRepository.Common;

@Listeners(core.ListenerClass.class)
public class VerifyLogin {
	
	@Test
	public void loginPageVerification() {
		
		 
		LoginPage.login();
	}
	
	@Test
	public void verifyforgottenaccount() {
		
		var sqlQuery = "SELECT * FROM "+GlobalData.testScriptName;
		var data  = MySQLConnection.getData(sqlQuery);
		GlobalData .emailId = data.get("emaiID");
		System.out.println(GlobalData.emailId);
		WebControls.clickOnObject(Common.forgottenLink, "Click on 'Forgotten password link'");
		WebControls.inputText(Common.verifyEmail,GlobalData.emailId, "Entered Email ID");
		WebControls.clickOnObject(Common.btnSearch, "clicked on 'Search' button");
		//Assert.assertFalse(WebControls.isElementPresent(Common.txtNoSearchResult));
		if(WebControls.isElementPresent(Common.btnSearch))
			Report.verification("fail", "search result found");
		else
			Report.verification("pass", "search result not found");
	}

}
