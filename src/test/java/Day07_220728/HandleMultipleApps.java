package Day07_220728;

import driver.AppPackage;
import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class HandleMultipleApps {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // TODO: Click button Log in Anonymously
            MobileElement loginByHHLLBtnElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button"));
            loginByHHLLBtnElem.click();

            // TODO: Input Phone number
            MobileElement phoneNumberInputElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/phoneNumber_add_phone_num_edittext"));
            phoneNumberInputElem.sendKeys("939086671");

            // TODO: Click button Get started
            MobileElement getStartedBtnElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/phoneNumber_get_start_button"));
            getStartedBtnElem.click();

            // TODO: Click link "Send verification code via SMS"
            MobileElement txtSmsOtpElem = appiumDriver.findElement(MobileBy.id("com.halome.android.lite:id/txt_sms_otp"));
            txtSmsOtpElem.click();

            // TODO: Enter code "0000000"
            List<MobileElement> enterCodeInput = appiumDriver.findElements(MobileBy.xpath("//android.widget.EditText"));
            for (MobileElement mobileElement : enterCodeInput) {
                mobileElement.sendKeys("0");
            }

            // TODO: Put the Halome Lite app into background || similar with pressing home btn
            // https://appium.io/docs/en/commands/device/app/background-app/
            appiumDriver.runAppInBackground(Duration.ofSeconds(-1));

            // TODO: Switch to Settings app (create "AppPackage" interface file at "driver" package to use)
            // https://appium.io/docs/en/commands/device/app/activate-app/
            appiumDriver.activateApp(AppPackage.settings);

            // TODO: Find the way to turn off Wifi and Mobile network - 4G
            MobileElement wifiSettings = appiumDriver.findElement(MobileBy.xpath("//*[@text=\"Wi-Fi\"]"));
            wifiSettings.click();

            MobileElement wifiSwitchToggle = appiumDriver.findElement(MobileBy.id("android:id/switch_widget"));
            wifiSwitchToggle.click();



            // TODO: Comeback to Halome Lite app
            appiumDriver.activateApp(AppPackage.halomeLite);
            Thread.sleep(5000);

            // TODO: Take screenshot (Lost internet connection - Loading)
            File base64ScreenshotData = appiumDriver.getScreenshotAs(OutputType.FILE);
            String fileLocation = System.getProperty("user.dir").concat("/screenshots/").concat("LostConnection.png");
            FileUtils.copyFile(base64ScreenshotData, new File(fileLocation));


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
