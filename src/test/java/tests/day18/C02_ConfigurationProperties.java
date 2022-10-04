package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {

    @Test 
    public void test01() {
        // Amazon sayfasına ve facebook sayfasina  gidelim
        String urlamzn = ConfigReader.getProperty("amznUrl");
        String urlFace = ConfigReader.getProperty("faceUrl");

        Driver.getDriver().get(urlamzn);
        Driver.getDriver().get(urlFace);

        Driver.closeDriver();
    }
}
