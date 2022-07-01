//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.KPAdsPage;
import pages.KPHomePage;
import pages.KPLoginPage;
import pages.KPchoosenAdPage;

public class KPAdresarTest extends BaseTest {
    public KPAdresarTest() {
    }

    @Test
    public void addToAdresarTest() throws InterruptedException {
        String username = "KP.test.adresar@gmail.com";
        String password = "kupujemprodajem";
        KPHomePage HomePage = new KPHomePage(driver);
        HomePage.goToLoginPage();
        KPLoginPage loginProcedure = new KPLoginPage(driver);
        loginProcedure.login(username, password);
        KPAdsPage pickAd = new KPAdsPage(driver);
        pickAd.chooseAd();
        KPchoosenAdPage AddToAdresar = new KPchoosenAdPage(driver);
        AddToAdresar.dodajUAdresar();
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("kpBoxMainHolder")));
        WebElement boxTitleHolder = driver.findElement(By.className("kpBoxMainHolder"));
        WebElement kpModal = boxTitleHolder.findElement(By.className("note-kpmodal"));
        WebElement boxHolder = kpModal.findElement(By.className("box-holder"));
        WebElement box = boxHolder.findElement(By.className("box"));
        WebElement boxTitle = box.findElement(By.className("title"));
        String adBoxTitle = "Korisnik dodat u adresar";
        Assert.assertTrue("[KPAdresarTest] addToAdresarTest failed, text is not found in box title", boxTitle.getText().contains(adBoxTitle));
        String izbaci = "Izbaci iz adresara";
        Assert.assertEquals("[KPAdresarTest] addToAdresarTest failed, last option text doesn't match string izbaci", KPchoosenAdPage.IzbaciIzAdresara, izbaci);
        Thread.sleep(2000L);
    }
}
