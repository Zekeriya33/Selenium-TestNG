package tests.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebDriverUniversityPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
    // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
    // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
   //Tüm yapılacakların üzerini çiz.
   //Tüm yapılacakları sil.
   //Tüm yapılacakların silindiğini doğrulayın.


    @Test
    public void test01() throws InterruptedException {
        WebDriverUniversityPage webDriverUniversityPage = new WebDriverUniversityPage();
        // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("wuniversity"));
      // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
       webDriverUniversityPage.addNewTodo.click();
        List<String> isListesi = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka", "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));
        Actions actions =new Actions(Driver.getDriver());

        for (String w:isListesi   ) {
            actions.click(webDriverUniversityPage.addNewTodo).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }

        //Tüm yapılacakların üzerini çiz.
        List<WebElement>todos =webDriverUniversityPage.todos;
        for (WebElement w:todos    ) {
            w.click();

        }
        //Tüm yapılacakları sil.

        List<WebElement> delete = webDriverUniversityPage.deleteButton;
        for (WebElement w:delete   ) {
            w.click();

        }
        //Tüm yapılacakların silindiğini doğrulayın.
        Thread.sleep(3000);
        List<WebElement>newTodos = webDriverUniversityPage.newtodos;
        Assert.assertEquals(0,newTodos.size());
    }

}
