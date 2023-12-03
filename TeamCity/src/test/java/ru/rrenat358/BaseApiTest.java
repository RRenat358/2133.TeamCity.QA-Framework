package ru.rrenat358;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.rrenat358.TestData.DataEntity;
import ru.rrenat358.TestData.DataGenerator;

public class BaseApiTest extends BaseTest {

    public  DataGenerator dataGenerator;
    public  DataEntity dataEntity;

    @BeforeEach
    public  void setupTest() {
        dataEntity = new DataGenerator().entityDataGenerator();
    }


    @AfterEach
    public void cleanTestData() {
        dataEntity.deleteNewProjectDescription();
    }




}
