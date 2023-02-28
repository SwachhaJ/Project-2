import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ExtentDemo {
    static ExtentTest test;
    static ExtentReports report;

    WebDriver driver;
    @BeforeClass
    public static void startTest() {
        report= new ExtentReports(System.getProperty("user.dir") + "//ExtentReportResults"+System.currentTimeMillis()+".html");
        test= report.startTest("Extent Demo");
    }
    @BeforeTest
    public void Beforetest()
    {
        driver=new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
    }
    @Test
    public void extentReportsDemo(){
        if (driver.getTitle().equals("Google")) {
            test.log(LogStatus.PASS, "Navigated to specified URL to Google.com");
        } else {
            test.log(LogStatus.FAIL,"Test Failed");
        }
    }
    @Test
    public void Testcase2(){
        if (driver.getTitle().equals("Account Login")) {
            test.log(LogStatus.PASS, "Navigated to specified URL to tutorialninja.com");
        } else {
            test.log(LogStatus.FAIL,"Test Failed");
        }
    }

    @AfterClass
    public static void endTest(){
        report.endTest(test);
        report.flush();

    }

    @AfterTest
    public void Aftermethod(){
        driver.close();
        driver.quit();
    }
}
