package homeWork8;

import io.qameta.allure.Attachment;

public class ScreenshotAllure {
    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }
}
