package Day04_220719;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class SwipeUtil {
    private AppiumDriver<MobileElement> appiumDriver;
    private TouchAction touchAction;
    private PointOption startPoint;
    private PointOption endPoint;

    public SwipeUtil(AppiumDriver<MobileElement> appiumDriver) {
        this.appiumDriver = appiumDriver;
        touchAction = new TouchAction(this.appiumDriver);

        // Get Mobile window size
        Dimension windowSize = this.appiumDriver.manage().window().getSize();
        int screenHeight = windowSize.getHeight();
        int screenWidth = windowSize.getWidth();

        // Calculate touch points
        int xStartPoint = 70 * screenWidth / 100;
        int xEndPoint = 10 * screenWidth / 100;

        int yStartPoint = 70 * screenHeight / 100;
        int yEndPoint = yStartPoint;

        // Convert coordinate -> PointOption
        this.startPoint = new PointOption().withCoordinates(xStartPoint, yStartPoint);
        this.endPoint = new PointOption().withCoordinates(xEndPoint, yEndPoint);
    }

    public void swipeFromRightToLeft(int times) {
        for(int i=0; i<times; i++) {
            this.swipeFromRightToLeft();
        }
    }

    public void swipeFromLeftToRight(int times) {
        for(int i=0; i<times; i++) {
            this.swipeFromRightToLeft();
        }
    }

    public void swipeFromRightToLeft() {
        touchAction
                .longPress(startPoint)
                .moveTo(endPoint)
                .release()
                .perform();
    }

    public void swipeFromLeftToRight() {
        touchAction
                .longPress(endPoint)
                .moveTo(startPoint)
                .release()
                .perform();
    }




}
