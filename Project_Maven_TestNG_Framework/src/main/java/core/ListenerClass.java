package core;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends WebDriverHelper implements ISuiteListener, ITestListener {

	public void onStart(ISuite suite) {
		ReadPropertiesFile.loadPropertiesFile();
		Report.createReport();
	}

	public void onFinish(ISuite suite) {
		Report.flushProcess();
	}

	public void onTestStart(ITestResult result) {
		Report.testCase(result.getName());
		GlobalData.testScriptName = result.getName();
		WebDriverHelper.invokeBrowser();
	}

	public void onStart(ITestContext context) {
		
		
	
	}

	public void onTestSuccess(ITestResult result) {
		closeBrowser();
	}

	public void onTestFailure(ITestResult result) {
		closeBrowser();
		// not implemented
	}
}
