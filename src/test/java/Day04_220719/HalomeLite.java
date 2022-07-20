package Day04_220719;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class HalomeLite {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Click Forms button
            MobileElement loginByHHLLBtnElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button"));
            loginByHHLLBtnElem.click();

            Thread.sleep(10000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
