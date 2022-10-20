package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.List;

public class Bos {

Actions actions = new Actions(Driver.getDriver());
    @Test
    public void test01() throws InterruptedException {
        Driver.getDriver().get("https://hubcomfy.com/");
        Driver.getDriver().findElement(By.xpath("//*[.='Sign In']")).click();
        Driver.getDriver().findElement(By.xpath("//*[@id='username']")).
                sendKeys("bozkurt.zekeriya@gmail.com");
        actions.sendKeys(Keys.TAB).sendKeys("berra3346").sendKeys(Keys.ENTER)
                .perform();
        Driver.getDriver().findElement(By.xpath("//*[.='Sign Out']")).click();
        Driver.getDriver().findElement(By.xpath("//*[.='Store Manager']")).click();

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        Driver.getDriver().findElement(By.xpath("(//*[@class='text'])[4]")).click();

        Driver.getDriver().findElement(By.xpath("(//*[.='Add New'])[1]")).click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        List<WebElement> list = Driver.getDriver().findElements(By.xpath("//ul[@id='product_cats_checklist']"));

        for (WebElement w: list           ) {
            System.out.println(w.getText());

        }
    }
}
