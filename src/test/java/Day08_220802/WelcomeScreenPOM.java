package Day08_220802;

import driver.DriverFactory;
import driver.Platforms;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.pages.*;

public class WelcomeScreenPOM {
    public static void main(String[] args) {
        AppiumDriver<MobileElement> appiumDriver = DriverFactory.getDriver(Platforms.android);

        try {
            // Navigate to Log in Anonymously Screen
            WelcomeScreen welcomeScreen = new WelcomeScreen(appiumDriver);
            welcomeScreen.clickOnLoginAnonymouslyBtn();

            // Navigate to Log in Enter Phone Number Screen
            LoginEnterPhoneNumberScreen loginEnterPhoneNumberScreen = new LoginEnterPhoneNumberScreen(appiumDriver);
            loginEnterPhoneNumberScreen.inputPhoneNumber("939086671");
            loginEnterPhoneNumberScreen.clickOnGetStartedBtn();

            // TODO: Navigate to Log in OTP in app Screen


            // TODO: Navigate to Log in SMS in app Screen
            LoginOtpInAppScreen loginOtpInAppScreen = new LoginOtpInAppScreen(appiumDriver);
            loginOtpInAppScreen.clickGetOtpInSmsElem();

            // TODO: Navigate to Home Screen
            LoginOtpInSmsScreen loginOtpInSmsScreen = new LoginOtpInSmsScreen(appiumDriver);
            loginOtpInSmsScreen.enterOtp();

            // TODO: At Home Screen, click Contact List Menu
            HomeScreen homeScreen = new HomeScreen(appiumDriver);
            homeScreen.clickMenuBtn();

            // Debug only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            appiumDriver.quit();
        }
    }
}
