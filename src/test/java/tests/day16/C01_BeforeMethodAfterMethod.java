package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void amazonTesti() {
        driver.get("https://amazon.com");

    }

    @Test
    public void bestBuyTest() {

        driver.get("https://www.bestbuy.com");
    }

    @Test
    public void techProTest() {
        driver.get("https://www.techproeducation.com");
    }
}
