package Day04_220719;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HalomeSB {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Click Forms button
            MobileElement loginByHHLLBtnElem = appiumDriver.findElement(MobileBy.id("com.hahalolo.android.halome:id/hahalolo_bt"));
            loginByHHLLBtnElem.click();

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
