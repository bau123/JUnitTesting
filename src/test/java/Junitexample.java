import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Junitexample {


    private WebDriver webDriver;
    private static final String BASE_URL = "http://thedemosite.co.uk";

    @BeforeClass
    public static void init(){
        System.out.println("Before Class");
    }

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
        webDriver.navigate().to(BASE_URL);

    }

    @Test
    public void printTest(){
        try{
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (Exception e){
            e.printStackTrace();
        }

        WebElement addUserButton = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(6)"));
        addUserButton.click();

        WebElement usernameTextField = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
        usernameTextField.sendKeys("My Dude");

        WebElement passwordTextField = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        passwordTextField.sendKeys("Dude My");

        WebElement saveButton = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
        saveButton.click();


        WebElement loginButtno = webDriver.findElement(By.cssSelector("body > div > center > table > tbody > tr:nth-child(2) > td > div > center > table > tbody > tr > td:nth-child(2) > p > small > a:nth-child(7)"));
        loginButtno.click();

        WebElement loginName = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input"));
        loginName.sendKeys("My Dude");
        WebElement loginPass = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]"));
        loginPass.sendKeys("Dude My");

        WebElement testLogin = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]"));
        //@FindBy (css = #l1st-ib")
        //private WebElement searchBar;

        testLogin.click();
        WebElement works = webDriver.findElement(By.cssSelector("body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center"));
        //Use this for anomalies
        Assert.assertEquals("Did not work", "**Successful Login**", works.getText());







        System.out.println("Test");
    }
    @After
    public void cleanUp(){
        //webDriver.close();

        System.out.println("After");
        webDriver.quit();

    }
    @AfterClass
    public static void tearDown(){
        System.out.println("After Class");
    }
}
