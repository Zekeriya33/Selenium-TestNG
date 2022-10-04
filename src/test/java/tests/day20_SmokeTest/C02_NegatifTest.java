package tests.day20_SmokeTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_NegatifTest {

    @Test (priority = 1)
    public void yanlisKullanici() throws InterruptedException {
        //  https://www.hotelmycamp.com/ adresine git
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        Driver.getDriver().get(ConfigReader.getProperty("htlmycmpUrl"));
        //  login butonuna bas
        hotelMyCampPage.loginButonu.click();
        //  test data username: manager1 ,  test data password : manager1!
        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("htlmyWrongUsername"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("htlmyPassword"));
        Thread.sleep(3000);
        hotelMyCampPage.btnSubmit.click();
        //  Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPage.basarisizGiris.isDisplayed());

        Driver.closeDriver();

    }

    @Test (priority = 2)
    public void yanlisSifre() throws InterruptedException {
        //  https://www.hotelmycamp.com/ adresine git
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        Driver.getDriver().get(ConfigReader.getProperty("htlmycmpUrl"));
        //  login butonuna bas
        hotelMyCampPage.loginButonu.click();
        //  test data username: manager1 ,  test data password : manager1!
        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("htlmyUsername"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("htlmyWrongPassword"));
        Thread.sleep(3000);
        hotelMyCampPage.btnSubmit.click();
        //  Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPage.basarisizGiris.isDisplayed());

        Driver.closeDriver();

    }

    @Test (priority = 3)
    public void yanlisKullaniciSifre() throws InterruptedException {
        //  https://www.hotelmycamp.com/ adresine git
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();

        Driver.getDriver().get(ConfigReader.getProperty("htlmycmpUrl"));
        //  login butonuna bas
        hotelMyCampPage.loginButonu.click();
        //  test data username: manager1 ,  test data password : manager1!
        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("htlmyWrongUsername"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("htlmyWrongPassword"));
        Thread.sleep(300);
        hotelMyCampPage.btnSubmit.click();
        //  Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPage.basarisizGiris.isDisplayed());

        Driver.closeDriver();
    }
}
