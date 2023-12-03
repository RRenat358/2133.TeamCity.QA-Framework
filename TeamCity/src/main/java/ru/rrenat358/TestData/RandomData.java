package ru.rrenat358.TestData;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

    public static final int LENGTH = 10;

    public static String getString() {
        return "Test-" + RandomStringUtils.randomAlphabetic(LENGTH);
    }



}
