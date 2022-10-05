package tests.day22;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BluerentalcarsPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_RaporluTest extends TestBaseRapor {
    /*
    -https://www.bluerentalcars.com/ adresine git
    -login butonuna bas
    -test data user email: customer@bluerentalcars.com ,
    -test data password : 12345 dataları girip login e basın
    -login butonuna tiklayin
    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
     */
   BluerentalcarsPage bluerentalcarsPage;
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test","Geçerli kullanıcı adı ve password ile giriş yapıldı");
//   -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Blue RentaCar sitesine gidildi");
//   -login butonuna bas
        bluerentalcarsPage = new BluerentalcarsPage();
        bluerentalcarsPage.login.click();
        extentTest.info("login butonuna basıldı");
//   -test data user email: customer@bluerentalcars.com ,
        bluerentalcarsPage.email.sendKeys(ConfigReader.getProperty("brcemail"));
//   -test data password : 12345 dataları girip login e basın
        bluerentalcarsPage.password.sendKeys(ConfigReader.getProperty("brcpassword"));
//   -login butonuna tiklayin
        bluerentalcarsPage.login2.click();
        extentTest.info("Doğru kullanıcı email ve password girildi");
        extentTest.info("Ikinci login butonuna basıldı");
//   -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = bluerentalcarsPage.basariliGiris.getText();
        String expectedUserName = "John Walker";
        Assert.assertEquals(actualUserName,expectedUserName);
        extentTest.pass("Sayfaya basarili sekilde girildi");

    }
}
