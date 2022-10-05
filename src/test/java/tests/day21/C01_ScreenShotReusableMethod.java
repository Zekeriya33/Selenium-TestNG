package tests.day21;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {

    @Test
    public void test01() throws IOException {
        // hepsiburada sayfasina gidiniz
        Driver.getDriver().get("https://www.hepsiburada.com");
        // ve Sayfanın resmini alınız
        ReusableMethods.getScreenshot("hepsiburada");
        Driver.closeDriver();
    }

    @Test
    public void test02() throws IOException {
        AmazonPage amazonPage = new AmazonPage();
        // Amazon sayfasina gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amznUrl"));
        // Nutella aratınız
        amazonPage.aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        // arama sonuc yazısınız Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("Nutella",amazonPage.aramaSonucWE);

        Driver.closeDriver();
    }


}
