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

public class KPLoginPage extends BaseHelper {
    @FindBy(
            id = "email"
    )
    WebElement enterEmailAdress;
    @FindBy(
            id = "password"
    )
    WebElement enterPass;
    @FindBy(
            id = "submitButton"
    )
    WebElement touchUlogujtese;
    WebDriver driver;
    @FindBy(
            css = "a[href='/']"
    )
    WebElement adsPage;
    @FindBy(
            name = "i-understand"
    )
    WebElement cookieClose;

    public KPLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void enterEmail(String username)
    {
        this.enterEmailAdress.sendKeys(new CharSequence[]{username});
    }

    private void enterPass(String password) {
        this.enterPass.sendKeys(new CharSequence[]{password});
    }

    private void ulogujteSe() {
        wdWait.until(ExpectedConditions.elementToBeClickable(this.touchUlogujtese));
        this.touchUlogujtese.click();
        wdWait.until(ExpectedConditions.urlContains("welcome"));
        this.adsPage.click();
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.id("cookieConsentHolder")));
        this.cookieClose.click();
    }

    public void login(String username, String password) throws InterruptedException {
        this.enterEmail(username);
        this.enterPass(password);
        this.ulogujteSe();
    }
}
