package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C04_DepensOnMethod extends TestBaseBeforeClassAfterClass {

    @Test
    public void test01() {
        // Amazon ana sayfasina gidin
        driver.get("https://amazon.com");
    }

    @Test (dependsOnMethods = "test01")
    public void test02() {
     // Nutella Aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
    }

    @Test (dependsOnMethods = "test02")
    public void test03() {
        // sonuc yazisinin amazon icerdigini test edelim
     WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertFalse(sonuc.getText().contains("amazon"));


    }
}
