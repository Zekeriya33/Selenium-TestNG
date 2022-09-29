package tests.Practice06;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;
import utilities.Driver;

public class P01 {
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Fill in capitals by country.


    @Test
    public void test01() {

        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        DhtmlgoodiesPage dhtmlgoodiesPage = new DhtmlgoodiesPage();
        Actions actions = new Actions(Driver.getDriver());

  //  actions.dragAndDrop(dhtmlgoodiesPage.copenhagen, dhtmlgoodiesPage.denmark).perform();
  //  actions.dragAndDrop(dhtmlgoodiesPage.oslo, dhtmlgoodiesPage.norway).perform();
  //  actions.dragAndDrop(dhtmlgoodiesPage.madrid, dhtmlgoodiesPage.spain).perform();
  //  actions.dragAndDrop(dhtmlgoodiesPage.seoul, dhtmlgoodiesPage.southKorea).perform();
  //  actions.dragAndDrop(dhtmlgoodiesPage.rome, dhtmlgoodiesPage.italy).perform();
  //  actions.dragAndDrop(dhtmlgoodiesPage.washington, dhtmlgoodiesPage.unitedStates).perform();
  //  actions.dragAndDrop(dhtmlgoodiesPage.stockholm, dhtmlgoodiesPage.sweden).perform();

       // 2 Yol

          actions.dragAndDrop(dhtmlgoodiesPage.oslo, dhtmlgoodiesPage.norway)
                .dragAndDrop(dhtmlgoodiesPage.madrid, dhtmlgoodiesPage.spain)
                .dragAndDrop(dhtmlgoodiesPage.rome, dhtmlgoodiesPage.italy)
                .dragAndDrop(dhtmlgoodiesPage.seoul, dhtmlgoodiesPage.southKorea)
                .dragAndDrop(dhtmlgoodiesPage.stockholm, dhtmlgoodiesPage.sweden)
                .dragAndDrop(dhtmlgoodiesPage.washington, dhtmlgoodiesPage.unitedStates)
                .dragAndDrop(dhtmlgoodiesPage.copenhagen, dhtmlgoodiesPage.denmark)
                .perform();

          Driver.closeDriver();




    }
}
