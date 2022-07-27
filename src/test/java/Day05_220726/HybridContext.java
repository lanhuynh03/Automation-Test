package Day05_220726;

import context.Contexts;
import context.WaitMoreThanOneContext;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class HybridContext {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("chromedriverExecutable","/Users/admin/node_modules/appium/node_modules/appium-chromedriver/chromedriver/mac");

        try {
            // Click Forms button
            MobileElement loginByHHLLBtnElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_halome_button"));
            loginByHHLLBtnElem.click();

            // Wait until we have more than one context
            WebDriverWait wait = new WebDriverWait(appiumDriver, 30);
            wait.until(new WaitMoreThanOneContext(appiumDriver));


            // Print context
            Set<String> contextNames = appiumDriver.getContextHandles();
            for (String contextName : contextNames) {
                System.out.println(contextName);
            }

            // Switch to web_view context
            appiumDriver.context(Contexts.WEB_VIEW);

            WebElement emailInputElem = appiumDriver.findElement(new By.ByCssSelector("input[id='accountId']"));
            emailInputElem.sendKeys("halome004@skyoi.tk");

            WebElement passwordInputElem = appiumDriver.findElement(new By.ByCssSelector("input[id='password']"));
            passwordInputElem.sendKeys("admin@123");

            WebElement loginBtnElem = appiumDriver.findElement(new By.ByCssSelector("[type='submit']"));
            loginBtnElem.click();

            // Switch to native context
            appiumDriver.context(Contexts.NATIVE);

            MobileElement continueBtnElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/btn_continue"));
            continueBtnElem.click();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
