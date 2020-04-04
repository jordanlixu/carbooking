package com.example.cardemo;

import com.example.cardemo.common.Constants;
import com.example.cardemo.common.ResultEntity;
import com.example.cardemo.controller.CarbookingController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
//启动Spring
@SpringBootTest
public class CarbookingControllerTest {

    @Autowired
    private CarbookingController carbookingController;


    @Test
    public void querybookingTest() throws Exception {
        ResultEntity rs = carbookingController.querybooking("13760405566");
        Assert.assertEquals(Constants.SUCCESS_CODE, rs.getCode());
    }
    @Test
    public void bookTest() throws Exception {

        ResultEntity rs = carbookingController.book("888","13760405566","2020-04-09","2020-04-10");
        Assert.assertEquals(Constants.SUCCESS_CODE, rs.getCode());
    }


    @Test
    public void queryCarsTest() throws Exception {
        ResultEntity rs = carbookingController.queryCars();
        Assert.assertEquals(Constants.SUCCESS_CODE, rs.getCode());
    }
}