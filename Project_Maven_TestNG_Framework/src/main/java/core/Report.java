package core;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report extends WebDriverHelper {
   private static String reportPath;
	
	static private ExtentReports extent;
	static private ExtentTest test;
	
	public static String getReportPath() {
		
		String reportPath = System.getProperty("user.dir")+"\\Reports\\CustomReport"+Utility.randomName();
		File file = new File(reportPath);
		if(!file.exists()) {
			if(file.mkdir()) {
				System.out.println("Directory is created!");
			}
			else {
				System.out.println("Failed to create directory!");
			}
						
		}
		return reportPath;
	}
	
	public static String takeScreenShot() {
		String fileName = Utility.randomName()+".png";
		File sourceFile;
		try {
			sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(sourceFile, new File(reportPath+"/"+fileName));
		}
		catch(Exception e) {
			System.out.println("Failed to take screen shot");
		}
		return fileName;
	}
	
	public static void createReport() {
		
		reportPath = getReportPath();
		extent = new ExtentReports();
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath+"/extent-report.html");
        extent.attachReporter(htmlReporter);
	}
	public static void testStep(String stepInfo) {
		test.log(Status.INFO, stepInfo);
	}
	public static void testCase(String testCaseName) {
		test = extent.createTest(testCaseName);
	}
	
	public static void verification(String  result,String stepName) {
		MediaEntityBuilder meb = MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot());
		
		if(result.equalsIgnoreCase("pass")) {
			test.log(Status.PASS, stepName,meb.build());
		}
		else {
			test.log(Status.FAIL, stepName,meb.build());
			Assert.fail();
		}
		
		//test.addScreenCaptureFromPath(takeScreenShot());
	
			
		
	}
	
	public static void flushProcess() {
		extent.flush();
	}

}
