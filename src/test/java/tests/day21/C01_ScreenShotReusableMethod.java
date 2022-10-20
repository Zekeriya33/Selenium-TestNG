package tests.day21;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import tests.log4J.Log4jTest2;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {
    private static Logger logger = LogManager.getLogger(C01_ScreenShotReusableMethod.class.getName());
    @Test
    public void test01() throws IOException {
         logger.info("Hepsi Burada sitesini gidilir");
        // hepsiburada sayfasina gidiniz
        Driver.getDriver().get("https://www.hepsiburada.com");
        // ve Sayfanın resmini alınız
        logger.info("Sayfanın ekran goruntusunu alir");
        ReusableMethods.getScreenshot("hepsiburada");
        logger.warn("Driver kapatilir");
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
