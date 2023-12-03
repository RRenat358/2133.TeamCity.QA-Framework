package ru.rrenat358;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import ru.rrenat358.TestData.DataEntity;
import ru.rrenat358.TestData.DataGenerator;

public class BaseApiTest extends BaseTest {

    public static DataGenerator dataGenerator;
    public static DataEntity dataEntity;

    @BeforeAll
    public static void setupTest() {
        dataEntity = dataGenerator.entityDataGenerator();
    }


    @AfterAll
    public static void cleanTestData() {
        dataEntity.deleteNewProjectDescription();
    }




}
