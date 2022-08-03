package models.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class HomeScreen {
    // TODO: Lab06

    private final AppiumDriver<MobileElement> appiumDriver;
    public HomeScreen(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
    }

    private final static By profileSel = MobileBy.id("com.halome.android.lite:id/contactList_userinfo");
    private final static By menuBtnSel = MobileBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]");
    public MobileElement profileElem() {
        return appiumDriver.findElement(profileSel);
    }
    public MobileElement menuBtnElem() {
        return appiumDriver.findElement(menuBtnSel);
    }

    public void openPersonalProfile() {
        profileElem().click();
    }
    public void clickMenuBtn(){
        menuBtnElem().click();
    }


}
