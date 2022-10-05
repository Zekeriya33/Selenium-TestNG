package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class CrossDriver {



    private CrossDriver() {   // Default constructor'u devre dısı bırakmak yani SingletonPattern yapmak icin kullanılıyor

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {

        //Eger browser a bir deger atanmamıssa configreader daki browser calissin
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;


        // Testlerimizi xml file dan farklı browserlar ile calistirabilmek icin getDriver() methoduna parametre
        // atamamız gerekir
        if(driver == null) {
            switch (browser){
                // CrossBrowser icin bizim gonderdigimiz browser uzerinden calismasi icin
                // buraya parametre olarak  girdigimiz degeri yazdik
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari" :
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();


            }

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
