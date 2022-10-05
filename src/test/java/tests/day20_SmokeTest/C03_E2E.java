package tests.day20_SmokeTest;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_E2E {

    @Test
    public void E2ETest() throws InterruptedException {

 //   https://www.hotelmycamp.com adresine git.
        HotelMyCampPage hotelMyCampPage = new HotelMyCampPage();
        Driver.getDriver().get(ConfigReader.getProperty("htlmycmpUrl"));
        //   Login butonuna tıklayın.
        hotelMyCampPage.loginButonu.click();
 //   Username textbox ve password metin kutularını locate edin ve asagidaki verileri girin
        hotelMyCampPage.userName.sendKeys(ConfigReader.getProperty("htlmyUsername"));
        hotelMyCampPage.password.sendKeys(ConfigReader.getProperty("htlmyPassword"));
 //   Username : manager
 //   Password  : Manager1!
 //   Login butonuna tıklayın.
        hotelMyCampPage.btnSubmit.click();

 //   Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hotelMyCampPage.managementButonu.click();
        Thread.sleep(2000);
        hotelMyCampPage.roomReservationButonu.click();
        Thread.sleep(2000);
        hotelMyCampPage.addRoomReservationButonu.click();

 //   Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        Faker faker = new Faker();
        hotelMyCampPage.idUser.sendKeys("manager");
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys("Happy Hotel").
                sendKeys(Keys.TAB).sendKeys("1500").sendKeys(Keys.TAB).sendKeys("10/10/2022").
                sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys("10/13/2022").sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).
                sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).sendKeys(faker.phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).sendKeys(faker.internet().emailAddress()).sendKeys(Keys.TAB).sendKeys("asdasfas").
                sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).sendKeys(Keys.SPACE).sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).perform();

 //   Save butonuna tıklayın.
 //        “RoomReservation was inserted successfully” textinin göründüğünü test edin.
        Thread.sleep(3000);
        Assert.assertTrue(hotelMyCampPage.reservationAlert.isDisplayed());
 //   OK butonuna tıklayın.
        hotelMyCampPage.reservationAlertOkButonu.click();


    }
}
