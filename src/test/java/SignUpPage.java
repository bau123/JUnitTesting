import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage {
    /**
    @FindBy(css = "#lst-ib")
    public WebElement googleSearchBar;

    @FindBy(css = "#rso > div:nth-child(1) > div > div:nth-child(1) > div > div > h3 > a")
    private WebElement QALink;
     **/

    @FindBy (css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    private WebElement userTextField;

    @FindBy (css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    private WebElement passwordTextfield;

    @FindBy (css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > div > center > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    private WebElement saveBtn;


    public void signUp(String name, String password){
        userTextField.sendKeys(name);
        passwordTextfield.sendKeys(password);
    }

    public void clickSaveBtn(){
        saveBtn.click();
    }

}
