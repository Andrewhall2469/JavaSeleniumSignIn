package com.qa.example;

import org.apache.commons.lang3.ObjectUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

//public class Screenshot {
//
//    private static WebDriver driver;
//
//    public static void takeScreenshot() {
//
//        try {
//            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("C:\\Users\\QAC\\IdeaProjects\\java-selenium\\screenshot.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (NullPointerException e) {
//            e.printStackTrace();
//        }
//    System.out.println("The screenshot was taken successfully.");
//    }
//}
public class Screenshot {

    public void takeScreenshot() {

        try {
            Robot robot;
            robot = new Robot();
            String format = "jpg";
            String fileName = "Screenshot." + format;

            Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenFullImage = robot.createScreenCapture(screenRect);
            ImageIO.write(screenFullImage, format, new File(fileName));

        } catch (HeadlessException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}