package Day05_220726;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Set;

public class HalomeLite {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("chromedriverExecutable","/Users/admin/node_modules/appium/node_modules/appium-chromedriver/chromedriver/mac");

        try {
            // Click Forms button
            MobileElement loginByHHLLBtnElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_halome_button"));
            loginByHHLLBtnElem.click();

            Thread.sleep(5000);

            Set<String> contextNames = appiumDriver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println(contextName);
            }
            appiumDriver.context((String) contextNames.toArray()[1]);

            WebElement emailInputElem = appiumDriver.findElement(new By.ByCssSelector("input[id='accountId']"));
            emailInputElem.sendKeys("halome004@sktoi.tk");

            WebElement passwordInputElem = appiumDriver.findElement(new By.ByCssSelector("input[id='password']"));
            passwordInputElem.sendKeys("admin@123");

            WebElement loginBtnElem = appiumDriver.findElement(new By.ByXPath("//div[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/button"));
            loginBtnElem.click();

            appiumDriver.context("NATIVE_APP");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
