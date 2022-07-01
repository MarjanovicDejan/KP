//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pages;

import helpers.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Random;

public class KPAdsPage extends BaseHelper {
    @FindBy(
            className = "oglas-holder"
    )
    List<WebElement> allAdsOnPage;

    public KPAdsPage(WebDriver driver) {
        KPAdsPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void randomAd() {
        wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oglas-holder")));
        System.out.println("ukupan broj oglasa je " + this.allAdsOnPage.size());
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(30);
        WebElement choosenAd = (WebElement)this.allAdsOnPage.get(randomInt);
        System.out.println("Izabrani oglas je " + choosenAd.getText());
        WebElement clickOnchoosenAd = choosenAd.findElement(By.className("ed-description"));
        clickOnchoosenAd.click();
    }

    public void chooseAd() {
        this.randomAd();
    }
}
