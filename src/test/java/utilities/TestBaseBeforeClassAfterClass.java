package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.swing.*;
import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass {
 protected WebDriver driver ;
    protected Actions actions;
    // @BeforeClass ve @Afterclass notasyonlarini testNG dekullanirken Junit deki gibi static yapmaya gerek yok

    @BeforeClass
    public  void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions= new Actions(driver);

    }
    @AfterClass
    public  void tearDown() {

        driver.quit();
    }
}
