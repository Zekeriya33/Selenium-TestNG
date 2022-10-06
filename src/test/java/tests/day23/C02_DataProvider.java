package tests.day23;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
 BluerentalcarsPage bluerentalcarsPage = new BluerentalcarsPage();

    @DataProvider
    public static Object[][] kullanicilar() {
        return new Object[][]{{"zeki@gmailcom","129873"},{"bozkurt@gmailcom","12346"},{"zekiboz@gmail.com","841214"}};
    }

    @Test (dataProvider = "kullanicilar")
    public void test01(String userEmail, String password) {

        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        //login butonuna bas
        bluerentalcarsPage.login.click();
        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
      bluerentalcarsPage.email.sendKeys(userEmail);
      bluerentalcarsPage.password.sendKeys(password);
        //login butonuna tiklayin
        bluerentalcarsPage.login2.click();
        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et

        Assert.assertTrue(bluerentalcarsPage.login2.isDisplayed());
    }
}
