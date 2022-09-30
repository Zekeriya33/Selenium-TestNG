package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FacebookPage {

    public FacebookPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//input[@id='email']")
    public WebElement email;

    @FindBy (xpath = "//input[@id='pass']")
    public WebElement password;

   @FindBy (xpath = "(//*[text()='Giriş Yap'])[1]")
    public WebElement girisYap;

   @FindBy (xpath = "//*[text()='Girdiğin e-posta bir hesaba bağlı değil. '] ")
    public WebElement girisYapilamadi;


}
