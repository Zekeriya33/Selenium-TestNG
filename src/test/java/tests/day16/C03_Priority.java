package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
  // Testlerimizi calistirirken istedigimiz siraya gore calismasini istersek
  // priority methodunu kullaniriz
    @Test (priority = 1)
    public void youTubeTesti() {
        driver.get("https://www.youtube.com");

    }

    @Test (priority = 3)
    public void bestBuyTest() {

        driver.get("https://www.bestbuy.com");
    }

    @Test (priority = 2)
    public void amazonTest() {
        driver.get("https://amazon.com");
    }
}
