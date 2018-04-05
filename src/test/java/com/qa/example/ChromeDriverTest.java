package com.qa.example;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverTest {

    private static WebDriver cdriver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
        cdriver = new ChromeDriver();

    }

    @Test
    public void testGoogleSearch() throws InterruptedException {

        try {
            ApachePOIExcelWrite excelWrite = new ApachePOIExcelWrite();
            excelWrite.init();
            ExcelUtils excelUtils = new ExcelUtils();
            excelUtils.initialise();

            cdriver.get("http://www.google.com/");
            cdriver.manage().window().fullscreen();
            // Thread.sleep(5000); // Let the user actually see something!
            WebElement searchBox = cdriver.findElement(By.name("q"));
            searchBox.sendKeys("twitter log in");
            searchBox.submit();
            WebElement chromeDriverLink = cdriver
                    .findElement(By.linkText("Login on Twitter"));
            chromeDriverLink.click();
            //Thread.sleep(5000);

            WebElement enterEmail = cdriver.findElement(By.cssSelector("#page-container > div > div.signin-wrapper > form > fieldset > div:nth-child(2) > input"));
            enterEmail.sendKeys(excelUtils.getEmail());

            WebElement enterPassword = cdriver.findElement(By.cssSelector("#page-container > div > div.signin-wrapper > form > fieldset > div:nth-child(3) > input"));
            enterPassword.sendKeys(excelUtils.getPassword());

            Thread.sleep(2500);

            WebElement submit = cdriver.findElement(By.xpath("//*[@id=\"page-container\"]/div/div[1]/form/div[2]/button"));
            submit.click();

            Thread.sleep(2500);

            Screenshot screen = new Screenshot();
            screen.takeScreenshot();

        }
        finally
        {

        }
    }

    @After
    public void tearDown() {
        cdriver.quit();
    }

}
