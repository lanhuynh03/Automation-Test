package Day03_220714;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

import java.sql.Driver;
import java.util.List;

public class XPathLearning {
    public static void main(String[] args) {
        // Get appium driver
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Find and click on nav login button
            MobileElement loginBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Login"));
            loginBtnElem.click();

            // Cach 1: Find all matching elements
            List<MobileElement> credInputFieldElems = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));

            // Cach 2: Find by text
            MobileElement emailInputElem = appiumDriver.findElement(MobileBy.xpath("//*[@text=\"Email\"]"));
            emailInputElem.sendKeys("123456");

            Thread.sleep(5000);

            // Cach 3:

            MobileElement loginInstrustionElem = appiumDriver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"When the device\")"));
            System.out.println(loginInstrustionElem.getText());

        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
