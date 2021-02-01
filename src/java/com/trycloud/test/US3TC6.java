package com.trycloud.test;

import com.trycloud.test.base.TestBase;
import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalTime;

public  class US3TC6 extends TestBase {
    @Test( description = "US3TC6")
    public void createNewFolder() {
       login();

       // WebElement driver = null;
        WebElement addButton = driver.findElement(By.xpath("//a[@class='button new']"));
        // click add button
        addButton.click();

        // click "New Folder" button
        driver.findElement(By.xpath("//a[@data-action='folder']")).click();

        // write a folder name
        String folderName = "test" + LocalTime.now().getNano();  // adding time stamp to the file name to make it unique everytime
        driver.findElement(By.xpath("//input[@value='New folder']")).sendKeys(folderName);

        //Click submit icon
        driver.findElement(By.xpath("//input[@class='icon-confirm']")).click();

        BrowserUtils.sleep(2);

        WebElement newFolder = driver.findElement(By.xpath("//tr[@data-mime='httpd/unix-directory']//span[.='"+ folderName +"']"));

     // Assert.assertTrue(newFolder.isDisplayed(),"Folder is not added successfully");

        String actualFolderName = newFolder.getText();

        Assert.assertEquals(actualFolderName,folderName,"Folder name does not match");

    }
    }
