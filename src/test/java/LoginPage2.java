import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage2 {

    @FindBy (css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(1) > td:nth-child(2) > p > input")
    private WebElement username;

    @FindBy (css =  "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(2) > p > input[type=\"password\"]")
    private WebElement password;

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > form > div > center > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(3) > td:nth-child(2) > p > input[type=\"button\"]")
    private WebElement loginBtn;

    @FindBy(css = "body > table > tbody > tr > td.auto-style1 > big > blockquote > blockquote > font > center")
    private WebElement resultText;

    public void enterInfo(String name, String password){
        username.sendKeys(name);
        this.password.sendKeys(password);
    }
    public void clickLogin(){
        loginBtn.click();
    }
    public String getSuccessText(){
        return resultText.getText();
    }

}
