package tests.Practice08;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HerOkuTestPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class P01 {

    HerOkuTestPage herOkuTestPage;
    Actions actions =   new Actions(Driver.getDriver());

    @Test
    public void test01() {
        //Go to https://testpages.herokuapp.com/styled/events/javascript-events.html
        Driver.getDriver().get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        //Click all the buttons and verify they are all clicked
         herOkuTestPage = new HerOkuTestPage();
        //kodlarımız yazarken clean code kapsamında daha sade kod yazabilmek amacı ile her test methodu içerisinde
        //ayrı bir object create etmektense bu objecti class seviyesinde instance olarak create edip
        //test methodlarında buna değer atamak ve kullanmak daha uygun bir yöntemdir

         herOkuTestPage.onblur.click();
         herOkuTestPage.onclick.click();
         herOkuTestPage.onclick.click();

         actions.contextClick(herOkuTestPage.contextmenu)
                 .doubleClick(herOkuTestPage.doubleClick)
                 .click(herOkuTestPage.onfocus)
                 .click(herOkuTestPage.keydown).sendKeys(Keys.ENTER)
                 .click(herOkuTestPage.keyup).sendKeys(Keys.ENTER)
                 .click(herOkuTestPage.keypress).sendKeys(Keys.ENTER)
                 .moveToElement(herOkuTestPage.mouseOver)
                 .moveToElement(herOkuTestPage.mouseLeave)
                 .moveToElement(herOkuTestPage.mouseOver)
                 .click(herOkuTestPage.mouseDown).perform();

                 List<WebElement> clicked = herOkuTestPage.eventTriggered;
        Assert.assertEquals(clicked.size(),11);







    }

}
