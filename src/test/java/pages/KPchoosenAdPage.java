package pages;

import helpers.BaseHelper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class KPchoosenAdPage extends BaseHelper
{

    @FindBy(className = "no-padding-top")
    WebElement KPuserBox;
    WebDriver driver;
    public KPchoosenAdPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public String KPusersName;
    public static String IzbaciIzAdresara;
    public void dodajUAdresar()
    {
        wdWait.until(ExpectedConditions.presenceOfElementLocated(By.className("no-padding-top")));
        List<WebElement> KPuserInfo = KPuserBox.findElements(By.className("oglas-owner"));

        KPusersName = KPuserInfo.get(0).findElement(By.className("username")).getText();

        WebElement lastOption = KPuserInfo.get(KPuserInfo.size()-1);
        js.executeScript("arguments[0].scrollIntoView()", lastOption);
        switch (lastOption.getText())
        {
            case ("Dodaj u adresar"):
                wdWait.until(ExpectedConditions.elementToBeClickable(lastOption));
                lastOption.click();
                wdWait.until(ExpectedConditions.visibilityOfElementLocated(By.className("kpBoxMainHolder")));
                IzbaciIzAdresara = KPuserInfo.get(KPuserInfo.size()-1).getText();
                break;
            case ("Izbaci iz adresara"): System.out.println("Korisnik je vec u Adresaru!"); Assert.fail("Korisnik je vec u Adresaru!");
                break;
            default: System.out.println("Ovaj korisnik nije dozvolio da se doda u Adresar"); Assert.fail("Ovaj korisnik nije dozvolio da se doda u Adresar");
        }

    }
}
