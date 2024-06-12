import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;


public class ReportManager {
    private ExtentReports extent;
    private ExtentTest test;
    private WebDriver driver; // Instância do WebDriver para tirar os screenshots

    public void startReport() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public void setWebDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void createTest(String testName) {
        test = extent.createTest(testName);
    }

    public void logStatus(Status status, String message) {
        test.log(status, message);
    }

    public void endReport() {
        extent.flush();
    }
}
