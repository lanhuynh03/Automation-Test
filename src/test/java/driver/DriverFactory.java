package driver;

import Day04_220719.HalomeLite;
import Day04_220719.HalomeSB;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class DriverFactory implements MobileCapabilityTypeEx{
    public static AppiumDriver<MobileElement> getDriver(Platforms platform) {

        if (platform == null) {
            throw new IllegalArgumentException(
                    "Platform can't be null, you can provide one of these: " + Arrays.toString(Platforms.values()));
        }

        AppiumDriver<MobileElement> appiumDriver = null;
        Exception exception = null;

        try {
            // Desired Capabilities
            DesiredCapabilities desiredCaps = new DesiredCapabilities();
            desiredCaps.setCapability(PLATFORM_NAME, "Android");
            desiredCaps.setCapability(AUTOMATION_NAME, "uiautomator2");
            desiredCaps.setCapability(UDID, "7e32f544");

//            wdio demo app
//            desiredCaps.setCapability(APP_PACKAGE, "com.wdiodemoapp");
//            desiredCaps.setCapability(APP_ACTIVITY, "com.wdiodemoapp.MainActivity");


//            HalomeSB
//            desiredCaps.setCapability(APP_PACKAGE, "com.hahalolo.android.halome");
//            desiredCaps.setCapability(APP_ACTIVITY, "com.halo.presentation.startapp.start.StartAct");


//            HalomeLite
            desiredCaps.setCapability(APP_PACKAGE, "com.halome.android.lite");
            desiredCaps.setCapability(APP_ACTIVITY, "com.halome.android.lite.view.main.login.activity.SelectLoginTypeActivity");

            // Init appium session
            URL appiumServer = new URL("http://localhost:4723/wd/hub");

            switch (platform) {
                case android:
                    appiumDriver = new AndroidDriver<MobileElement>(appiumServer, desiredCaps);
                    break;
                case ios:
                    appiumDriver = new IOSDriver<MobileElement>(appiumServer, desiredCaps);
            }

        } catch (Exception e) {
            exception = e;
        }

        if (appiumDriver == null) {
            throw new RuntimeException(exception.getMessage());
        }

        // Add IMPLICIT WAIT HERE
        appiumDriver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);

        return appiumDriver;
    }
}
