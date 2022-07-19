package Day02_220713;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class FormInteraction {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Click Forms button
            MobileElement formBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Forms"));
            formBtnElem.click();

            // Input field
            MobileElement inputFieldElem = appiumDriver.findElement(MobileBy.AccessibilityId("text-input"));
            inputFieldElem.sendKeys("hello");

            // Switch
            MobileElement switchBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("switch"));
            switchBtnElem.click();

            // Select Dropdown
            MobileElement dropdownBtnElem = appiumDriver.findElement(MobileBy.AccessibilityId("Dropdown"));
            dropdownBtnElem.click();
            MobileElement itemElem = appiumDriver.findElement(MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.appcompat.widget.LinearLayoutCompat/android.widget.FrameLayout/android.widget.ListView/android.widget.CheckedTextView[4]"));
            itemElem.click();

            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
