package tests.day19;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_PozitifTest {

    @Test (groups = "grup1")
    public void test01() {


        // https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("htlmycmpUrl"));
        // login butonuna bas
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        hotelMyCampPage.loginButonu.click();
        //  test data username: manager ,

        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("htlmyUsername"));
        //  test data password : Manager1!
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("htlmyPassword"));

        hotelMyCampPage.btnSubmit.click();
        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et

        Assert.assertTrue(hotelMyCampPage.basariliGiris.isDisplayed());

        Driver.closeDriver();
    }
}
