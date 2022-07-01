//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package pages;

import helpers.BaseHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class KPHomePage extends BaseHelper {
    @FindBy(
            className = "c-button--link"
    )
    WebElement ulogujteSeBtn;
    WebDriver driver;

    public KPHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private void NavigateToPage() {
        this.driver.get("https://m.kupujemprodajem.com/");
    }

    private void clickOnUlogujteSe() {
        wdWait.until(ExpectedConditions.elementToBeClickable(this.ulogujteSeBtn));
        this.ulogujteSeBtn.click();
    }

    public void goToLoginPage() {
        this.NavigateToPage();
        this.clickOnUlogujteSe();
    }
}
