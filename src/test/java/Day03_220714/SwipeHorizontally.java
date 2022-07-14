package Day03_220714;

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

            // Get Mobile window size
            Dimension windowSize = appiumDriver.manage().window().getSize();
            int screenHeight = windowSize.getHeight();
            int screenWidth = windowSize.getWidth();

            // Calculate touch points
            int xStartPoint = 70 * screenWidth / 100;
            int xEndPoint = 10 * screenWidth / 100;

            int yStartPoint = 70 * screenHeight / 100;
            int yEndPoint = 70 * screenHeight / 100;

            // Convert coordinate -> PointOption
            PointOption startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
            PointOption endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);

            // Using TouchAction to swipe
            TouchAction touchAction = new TouchAction(appiumDriver);

            // Swipe from right to left 5 times
            for (int i=0; i<5; i++) {
                touchAction
                        .longPress(startPoint)
                        .moveTo(endPoint)
                        .release()
                        .perform();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
