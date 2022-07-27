package Day05_220726;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;

import java.io.File;

public class TakingScreenshot {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            MobileElement loginAnonymouslyElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button"));
            loginAnonymouslyElem.click();

            // Whole screen
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginAnonymously.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));

            // An area
            MobileElement loginAnonymouslyFormElem = appiumDriver.findElement(MobileBy.id("android:id/content"));
            File base64loginFormData = loginAnonymouslyFormElem.getScreenshotAs(OutputType.FILE);
            String loginFormFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LoginAnonymouslyForm.png");
            FileUtils.copyFile(base64loginFormData, new File(loginFormFileLocation));

            // An element | button-Back
            MobileElement backBtnElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/back_login_phone_number"));
            File base64backBtnData = backBtnElem.getScreenshotAs(OutputType.FILE);
            String backBtnFileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("BackBtn.png");
            FileUtils.copyFile(base64backBtnData, new File(backBtnFileLocation));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
