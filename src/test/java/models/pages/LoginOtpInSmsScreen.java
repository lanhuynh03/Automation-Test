package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

public class LoginOtpInSmsScreen {
    // TODO: Lab06

    private final AppiumDriver<MobileElement> appiumDriver;
    public LoginOtpInSmsScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    private final static By enterCodeSel = MobileBy.xpath("//android.widget.EditText");
    private final static By resendOtpSel = MobileBy.id("com.halome.android.lite:id/Resend");


    public List<MobileElement> enterCodeElem() {
        List<MobileElement> editText = new ArrayList<>();
        for (MobileElement mobileElement : appiumDriver.findElements(enterCodeSel)) {
            editText.add(mobileElement);
        }
        return editText;
    }
    public MobileElement resendOtpElem(){
        return appiumDriver.findElement(resendOtpSel);
    }

    public void enterOtp(){
        for (MobileElement field : enterCodeElem()) {
            field.sendKeys("0");
        }
    }

    public void clickResendOtp(){
        resendOtpElem().click();
    }
}
