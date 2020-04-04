package com.example.cardemo;

import com.example.cardemo.bean.Carbooking;
import com.example.cardemo.mapper.CarbookingMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
//启动Spring
@SpringBootTest
public class CarbookingMapperTest {

    @Autowired
    private CarbookingMapper carbookingMapper;

    @Test
    public void insertTest() throws Exception {
        Carbooking carbooking = new Carbooking();
        carbooking.setCarid("888");
        carbooking.setPhonenum("13760405566");
        carbooking.setStarttime("2020-04-07");
        carbooking.setEndtime("2020-04-09");
        int rs = carbookingMapper.insert(carbooking);
        Assert.assertEquals(1, rs);
    }

    @Test
    public void findByPhoneNumTest() throws Exception {

        Carbooking carbooking = new Carbooking();
        carbooking.setCarid("888");
        carbooking.setPhonenum("13760405566");
        carbooking.setStarttime("2020-04-07");
        carbooking.setEndtime("2020-04-09");
        carbookingMapper.insert(carbooking);

        List<Carbooking> carbookings = carbookingMapper.findByPhoneNum("13760405566");
        for (Carbooking b :carbookings) {
            System.out.println(b.toString());
        }
    }

    @Test
    public void checkBookingInfoTest() throws Exception {
        Carbooking carbooking = new Carbooking();
        carbooking.setCarid("888");
        carbooking.setPhonenum("13760405566");
        carbooking.setStarttime("2020-04-10");
        carbooking.setEndtime("2020-04-11");
        carbookingMapper.insert(carbooking);

        int rs = carbookingMapper.checkBookingInfo("13760405566","888","2020-04-08","2020-04-10");
        Assert.assertEquals(1, rs);
    }


    @Test
    public void queryCarsTest() throws Exception {
        int rs = carbookingMapper.queryCars().size();
        Assert.assertEquals(3, rs);
    }
}
