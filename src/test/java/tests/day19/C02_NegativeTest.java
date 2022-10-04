package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegativeTest {

    @Test (groups = "grup2")
    public void testName() {


    //  https://www.hotelmycamp.com/ adresine git
    HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

    Driver.getDriver().get(ConfigReader.getProperty("htlmycmpUrl"));
 //  login butonuna bas
        hotelMyCampPage.loginButonu.click();
 //  test data username: manager1 ,  test data password : manager1!
        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("htlmyWrongUsername"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("htlmyWrongPassword"));
        hotelMyCampPage.btnSubmit.click();
 //  Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPage.basarisizGiris.isDisplayed());

        Driver.closeDriver();
}
}