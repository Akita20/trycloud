package com.trycloud.test;

import com.trycloud.test.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class US1TC2 extends TestBase {

    @Override
    public void loginInvalidPassword() {
        loginInvalidPassword();
    }

    @Test
    public void invalidCredential () {

        String actualUrl= driver.getCurrentUrl();
        String expectedUrl= "http://qa.trycloud.net/index.php/login?clear=1";

          Assert.assertFalse(expectedUrl==actualUrl,"Wrong username or password."  );


    }
}
