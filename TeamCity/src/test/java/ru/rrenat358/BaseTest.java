package ru.rrenat358;


import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    protected SoftAssertions softAssertions;

    @BeforeEach
    public void beforeTest() {
        softAssertions = new SoftAssertions();
    }


    @AfterEach
    public void afterTest() {
        // в конце тета разрешаем падение с исключением
        softAssertions.assertAll();
    }

}
