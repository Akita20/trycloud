package com.trycloud.test.base;

import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
   protected static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver("chrome");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("url"));
    }


    @AfterMethod
    public void teardownClass(){
        driver.close();
    }
    public void login() {
        String username= ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='submit-form']")).click();


    }
    public void loginInvalidPassword(){
        String username= ConfigurationReader.get("username");
   String password= ConfigurationReader.get("wrongPassword");
        driver.findElement(By.xpath("//input[@id='user']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='submit-form']")).click();

    }
}
