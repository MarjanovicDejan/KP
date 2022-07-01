package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
public class BaseHelper
{
    protected static WebDriver driver = setUp();
    protected static WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(10));
    protected static JavascriptExecutor js = (JavascriptExecutor) driver;

    protected static WebDriver setUp()
    {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 393);
        deviceMetrics.put("height", 851);
        deviceMetrics.put("pixelRatio", 3.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        WebDriver driver = new ChromeDriver(chromeOptions);

        return driver;
    }

    public static WebElement returnElementAttValue (String attributeName, String attributeValue)
    {
        String selector = "[" + attributeName + "=" + attributeValue + "]";
        WebElement element = driver.findElement(By.cssSelector(selector));
        return element;
    }



}

