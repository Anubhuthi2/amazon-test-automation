package allureReports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.amazon.qa.base.TestBase;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener{

	private static WebDriver driver; // Your WebDriver instance

    public AllureListener(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Capture and attach screenshot on test failure
        saveScreenshot(TestBase.getDriver());
        saveTextLog(result.getMethod().getMethodName() + " failed!");
    }

    @Attachment(value = "Page Screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        // This method captures a screenshot and attaches it to the Allure report
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
    
    @Attachment(value = "Failure Log", type = "text/plain")
    public String saveTextLog(String message) {
        // Attach custom text logs to Allure report
        return message;
    }

}
