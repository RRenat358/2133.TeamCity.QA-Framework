package ru.rrenat358.TestData;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

    public static final int LENGTH_3 = 3;
    public static final int LENGTH_5 = 5;
    public static final int LENGTH_8 = 8;
    public static final int LENGTH_13 = 13;


    //==================================================
    // Test_[Aa-Zz]
    public static String getString_Test_3_AZ() {
        return "Test_" + RandomStringUtils.randomAlphabetic(LENGTH_3);
    }

    public static String getString_Test_5_AZ() {
        return "Test_" + RandomStringUtils.randomAlphabetic(LENGTH_5);
    }

    public static String getString_Test_8_AZ() {
        return "Test_" + RandomStringUtils.randomAlphabetic(LENGTH_8);
    }

    public static String getString_Test_13_AZ() {
        return "Test_" + RandomStringUtils.randomAlphabetic(LENGTH_13);
    }



    //==================================================
    // Test_[0-9]
    public static String getString_Test_3_09() {
        return "Test_" + RandomStringUtils.randomNumeric(LENGTH_3);
    }

    public static String getString_Test_5_09() {
        return "Test_" + RandomStringUtils.randomNumeric(LENGTH_5);
    }

    public static String getString_Test_8_09() {
        return "Test_" + RandomStringUtils.randomNumeric(LENGTH_8);
    }

    public static String getString_Test_13_09() {
        return "Test_" + RandomStringUtils.randomNumeric(LENGTH_13);
    }







}
