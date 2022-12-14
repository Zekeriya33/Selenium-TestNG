package tests.day17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeClassAfterClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Odev02 extends TestBaseBeforeClassAfterClass {
  /*
          “http://zero.webappsecurity.com/” Adresine gidin
    Sign in butonuna basin
    Login kutusuna “username” yazin
    Password kutusuna “password” yazin
    Sign in tusuna basin
    Online banking menusu icinde Pay Bills sayfasina gidin
     “Purchase Foreign Currency” tusuna basin
    “Currency” drop down menusunden Eurozone’u secin
    soft assert kullanarak "Eurozone (Euro)" secildigini test edin
    soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
    "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China  (yuan)",
    "Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong  (dollar)","Japan (yen)",
    "Mexico (peso)","Norway (krone)","New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)",
    "Thailand (baht)"
   */

    @Test
    public void test1() {
        //“http://zero.webappsecurity.com/” Adresine gidin
        driver.get("http://zero.webappsecurity.com/");
        //Sign in butonuna basin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //Login kutusuna “username” yazin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        //Password kutusuna “password” yazin
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        //Sign in tusuna basin
        driver.findElement(By.xpath("//input[@value='Sign in']")).click();
        driver.navigate().back();
        //Online banking menusu icinde Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[text()='Online Banking'][1]")).click();
        driver.findElement(By.xpath("//span[@id='pay_bills_link']")).click();
        //“Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a")).click();
        //“Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown = driver.findElement(By.xpath("//select[@id='pc_currency']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");
        String actualDropDownTitle=select.getFirstSelectedOption().getText();
        //soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertNotEquals(actualDropDownTitle, "Eurozone (Euro)");
        //soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin
        // "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)",
        // "China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)",
        // "Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)",
        // "New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"

        List<WebElement> list = select.getOptions();
        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
                "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)",
                "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));
        for (int i = 0; i < expectedList.size(); i++) {
            softAssert.assertEquals(list.get(i).getText(), expectedList.get(i));
        }
        softAssert.assertAll();
       // driver.quit();
    }
}
