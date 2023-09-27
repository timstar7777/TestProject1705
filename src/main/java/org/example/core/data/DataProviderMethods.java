package org.example.core.data;

import org.testng.annotations.DataProvider;

public class DataProviderMethods {
    @DataProvider
    public Object[][] dataForCreateAccountTest() {
        return  new Object[][] {
                {"", "", "", "", ""},
                {"", "test-lastname", "valid@mail.ua", "80121629", "123"},
                {"test-firstname", "", "", "P1629&*&1629P", "P1629&*&1629P"},
                {"Rostik", "Rudenko", "validmail@bing.com", "P1629&*&1629P", "P1629&*&1629P"}
        };
    }
    @DataProvider
    public Object[][] dataForLoginTest() {
        return new Object[][] {

        };
    }
    @DataProvider
    public Object[][] dataForRozetkaSearchTest() {
        return new Object[][]{
                {"процессор", 15},
                {"насос", 99},
                {"парацетамол", 6},
                {"электронная книга", 25},
        };
    }
}

