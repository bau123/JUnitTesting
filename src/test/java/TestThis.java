import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestThis {

    private WebDriver webDriver;

    private String name = "My Dude";
    private String password = "Dude My";
    private static final String BASE_URL = "http://thedemosite.co.uk";
    private static ExtentReports report;
    private static SpreedSheetReader spreadSheetReader;
    private static String SPREAD_SHEET_FILE = System.getProperty("user.dir") + "\\src\\main\\resources\\Example_Spreadsheet.xlsx";







    @BeforeClass
    public static void preBefore(){
        String reportName = "Report";
        report = new ExtentReports();
        String filename = reportName+ ".html";
        String filePath = System.getProperty("user.dir") + File.separatorChar + filename;
        report.attachReporter(new ExtentHtmlReporter(filePath));

    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.navigate().to(BASE_URL);
        spreadSheetReader = new SpreedSheetReader(SPREAD_SHEET_FILE);
    }
    @After
    public void finish(){
        webDriver.quit();
    }

    @Test
    public void test() {
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ExtentTest test = report.createTest("MyFirstTest");
        test.log(Status.INFO, "My First Test is Starting ");
        for (int i = 1; i <= 5; i++) {

            List<String> something = spreadSheetReader.readRow(i, "Input Data");
            name = something.get(2);
            password = something.get(3);

            System.out.println(name + "," + password);


            test.log(Status.DEBUG, "On iteration: " + i);

            GoToLoginPage goToLoginPage = PageFactory.initElements(webDriver, GoToLoginPage.class);
            SignUpPage signUpPage = PageFactory.initElements(webDriver, SignUpPage.class);
            LoginPage loginPage = PageFactory.initElements(webDriver, LoginPage.class);
            LoginPage2 loginPage2 = PageFactory.initElements(webDriver, LoginPage2.class);
            goToLoginPage.goToAddUser();
            test.log(Status.DEBUG, "Clicked Add user");

            signUpPage.signUp(name, password);

            test.log(Status.DEBUG, "Add username and password with "  + name + ", " + password);
            signUpPage.clickSaveBtn();
            test.log(Status.DEBUG, "Sign-up button clicked");

            loginPage.clickLoginBtn();


            loginPage2.enterInfo(name, password);
            test.log(Status.DEBUG, "Trying to login with "  + name + ", " + password);
            loginPage2.clickLogin();
            test.log(Status.DEBUG, "Trying to log in");
            try{
                Assert.assertEquals("Failed Login", "**Successful Login**", loginPage2.getSuccessText());
                test.pass("Was able to login with" + name + ",  " + password);
            } catch (AssertionError e){
                test.warning("Could not log in");
                try{
                    //ScreenShot.take(webDriver, "FailedLogin-" + i);
                    test.addScreenCaptureFromPath(ScreenShot.take(webDriver, ("FailedLogin-" + i)));
                } catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }



    }
    @AfterClass
    public static void testFinished(){
        report.flush();
    }
}
