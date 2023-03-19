package com.qpros;

import com.qpros.Utils.SystemPropertiesReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BaseClass {

    public static WebDriver driver;
    public String url = SystemPropertiesReader.getBaseUrl();


    @BeforeTest
    public void intialization() {
        WebDriverManager.chromedriver().targetPath("src/main/resources/Driver/version80/").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        if (SystemPropertiesReader.getHeadlessState()) options.addArguments("--headless");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
        driver.get(url);
        System.out.println("Application url is: " + url);
    }

    @AfterSuite
    public void cleanupSpec() {
        driver.quit();
    }

    @AfterTest
    public void cleanAfterSuite() {
        driver.get(url);
    }

}
