package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class WelcomeScreen {
    private final AppiumDriver<MobileElement> appiumDriver;
    public WelcomeScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }
    private final static By loginAnonymouslyBtnSel = MobileBy.id("com.halome.android.lite:id/selectLogin_anonymously_button");
    private final static By loginHHLLBtnSel = MobileBy.id("com.halome.android.lite:id/selectLogin_halome_button");
    private final static By languageBtnSel = MobileBy.id("com.halome.android.lite:id/selectLogin_default_language_name");


    public MobileElement loginAnonymouslyBtnElem(){
        return appiumDriver.findElement(loginAnonymouslyBtnSel);
    }

    public MobileElement loginHHLLBtnElem(){
        return appiumDriver.findElement(loginHHLLBtnSel);
    }

    public MobileElement languageBtnElem(){
        return appiumDriver.findElement(languageBtnSel);
    }

    public void clickOnLoginAnonymouslyBtn(){
        loginAnonymouslyBtnElem().click();
    }

    public void clickOnLoginHHLLBtn(){
        loginHHLLBtnElem().click();
    }

    public void clickOnLanguageBtn(){
        languageBtnElem().click();
    }
}
