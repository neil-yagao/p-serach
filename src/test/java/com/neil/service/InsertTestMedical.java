package com.neil.service;

import com.neil.MedicalMatching;
import com.neil.pojo.Medical;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neil.Hu on 2017/4/12.
 */
@Test
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = MedicalMatching.class)
@DirtiesContext
public class InsertTestMedical extends AbstractTestNGSpringContextTests {

    @Autowired
    private MedicalInfo medicalInfo;

    @Test
    public void insertTestingMedical() {
        List<Medical> testingMedical = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            testingMedical.add(new Medical("药物" + i, i * 10.));
        }
        medicalInfo.insertOrUpdateMedicalInfo(testingMedical);
    }
}
