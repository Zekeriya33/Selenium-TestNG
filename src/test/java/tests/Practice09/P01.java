package tests.Practice09;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchProductPage;
import utilities.Driver;
import utilities.TestBaseRapor;

import javax.swing.*;

public class P01  extends TestBaseRapor {

    // 2. 'http://automationexercise.com' url'sine gidin
// 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
// 4. 'Ürünler' butonuna tıklayın
// 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
// 6. Arama girişine ("blue top") ürün adını girin ve ara düğmesine tıklayın
// 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın
// 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın

   SearchProductPage searchProductPage;
   Actions actions;
    @Test
    public void searchProductPage() {
        // 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get("http://automationexercise.com");
        // 3. Ana sayfanın başarıyla görünür olduğunu doğrulayın

        String actualUrl = Driver.getDriver().getCurrentUrl();
        String expectedUrl = "https://automationexercise.com/";
        Assert.assertEquals(actualUrl,expectedUrl);

       searchProductPage = new SearchProductPage();

        // 4. 'Ürünler' butonuna tıklayın
        searchProductPage.products.click();
        // 5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın

        Assert.assertTrue(searchProductPage.allProducTitle.isDisplayed());

        String productPageUrl="https://automationexercise.com/products";
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(),productPageUrl);

        // 6. Arama girişine ("blue top") ürün adını girin ve ara düğmesine tıklayın
     actions = new Actions(Driver.getDriver());
        searchProductPage.searchBox.sendKeys("blue top");
        actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();

        // 7. 'ARARAN ÜRÜNLER'in görünür olduğunu doğrulayın

        Assert.assertTrue(searchProductPage.searchedProducts.isDisplayed());

        // 8. Aramayla ilgili ürünün ("blue top") görünür olduğunu doğrulayın

        searchProductPage.viewProduct.click();

        Assert.assertTrue(searchProductPage.blueTop.isDisplayed());

    }
}
