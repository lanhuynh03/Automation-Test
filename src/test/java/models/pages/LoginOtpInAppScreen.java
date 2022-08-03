package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;


public class LoginOtpInAppScreen {
    // TODO: Lab06

    private final AppiumDriver<MobileElement> appiumDriver;
    public LoginOtpInAppScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    private final static By enterCodeSel = MobileBy.xpath("//android.widget.EditText");
    private final static By getOtpInSmsSel = MobileBy.id("com.halome.android.lite:id/txt_sms_otp");
    private final static By resensOtpSel = MobileBy.id("com.halome.android.lite:id/resent");


    public List<MobileElement> enterCodeElem() {
        List<MobileElement> editText = new ArrayList<>();
        for (MobileElement mobileElement : appiumDriver.findElements(enterCodeSel)) {
            editText.add(mobileElement);
        }
        return editText;
    }
    public MobileElement getOtpInSmsElem() {
        return appiumDriver.findElement(getOtpInSmsSel);
    }
    public MobileElement resendOtpElem() {
        return appiumDriver.findElement(resensOtpSel);
    }

    public void enterOtp(){
        for (MobileElement field : enterCodeElem()) {
            field.sendKeys("0");
        }
    }

    public void clickGetOtpInSmsElem() {
        getOtpInSmsElem().click();
    }

    public void clickResendOtpSms() {
        resendOtpElem().click();
    }




}
