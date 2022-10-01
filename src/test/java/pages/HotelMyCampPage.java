package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelMyCampPage {

    public HotelMyCampPage() {


        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//*[text()='Log in']")
    public WebElement loginButonu;

    @FindBy (xpath = "//input[@id='UserName']")
    public WebElement userName;

    @FindBy (xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy (xpath = "//input[@id='btnSubmit']")
    public WebElement btnSubmit;

    @FindBy (xpath = "(//*[text()='ListOfUsers'])[2]")
    public WebElement basariliGiris;

    @FindBy (xpath = "//div[@id='divMessageResult']")
    public WebElement basarisizGiris;

    @FindBy (xpath = "//span[text()='Hotel Management']")
    public WebElement managementButonu;

    @FindBy (xpath = "(//*[@class='icon-calendar'])[4]")
    public WebElement roomReservationButonu;

    @FindBy (xpath = "//span[text()='Add Room Reservation ']")
    public WebElement addRoomReservationButonu;

    @FindBy (xpath = "//*[@id='IDUser']")
    public WebElement idUser;

    @FindBy (xpath = "//*[text()='RoomReservation was inserted successfully']")
    public WebElement reservationAlert;

    @FindBy (xpath = "//*[@class='btn btn-primary']")
    public WebElement reservationAlertOkButonu;


}
