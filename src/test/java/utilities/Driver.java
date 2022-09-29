package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {

    static WebDriver driver;

    /*

    Testlerimizi calistirdigimizda her seferinde yeni driver olusturdugu icin her test
    Methodu icin yeni bir pencere(driver) aciyor. Eger driver a bir deger atanmamıs sa yani
     driver==null ise bir kere driver i calistir diyerek bir kere if icini calistiracak ve driver artık
     bir kere calistigi icin ve deger atandigi icin null olmayacak ve direk return edecek ve diger testlerimiz
     ayni pencere(driver) uzerinde calisacak

     */

    public static WebDriver getDriver() {
        if(driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;
    }

    public static void closeDriver() {
        if(driver!=null) { // driver a deger atanmissa kapat
            driver.close();
            driver=null; // Kapandıktan sonraki acmalari garanti altına almak icin driver i tekrar null yaptik
        }
    }

    public static void quitDriver() {
        if(driver!=null) {
            driver.quit();
        }
        driver=null;
    }
}