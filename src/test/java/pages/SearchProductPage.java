package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SearchProductPage {

    public SearchProductPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy (xpath = "//*[text()=' Products']")
    public WebElement products;

    @FindBy (xpath = "//*[text()='All Products']")
    public WebElement allProducTitle;

    @FindBy (xpath = "//*[@id='search_product']")
    public WebElement searchBox;

    @FindBy (xpath = "//*[text()='Searched Products']")
    public WebElement searchedProducts;

    @FindBy (xpath = "//*[text()='View Product']")
    public WebElement viewProduct;

    @FindBy (xpath = "//*[text()='Blue Top']")
    public WebElement blueTop;
}
