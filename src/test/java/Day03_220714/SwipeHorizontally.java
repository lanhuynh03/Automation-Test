package Day03_220714;

import Day04_220719.SwipeUtil;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SwipeHorizontally {
    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on nav swipe button
            MobileElement swipeBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Swipe"));
            swipeBtnElem.click();

            // Wait until on forms screen - Explicit Wait
            WebDriverWait wait = new WebDriverWait(appiumDriver, 10L);
            wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//android.widget.TextView[contains(@text, \"Swipe horizontal\")]")));

            //Swipe Horizontally
            SwipeUtil swipeUtil = new SwipeUtil(appiumDriver);
            swipeUtil.swipeFromRightToLeft(5);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
