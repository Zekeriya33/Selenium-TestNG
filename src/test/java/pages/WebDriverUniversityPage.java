package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class WebDriverUniversityPage {

    public WebDriverUniversityPage () {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@type='text']")
    public WebElement addNewTodo;

    @FindBy (xpath = "//li")
    public List<WebElement> todos;

    @FindBy (xpath = "//i[@class='fa fa-trash']")
    public List<WebElement> deleteButton;

    @FindBy (xpath = "//li")
    public List<WebElement> newtodos;


}
