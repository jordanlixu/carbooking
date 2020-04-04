package com.example.cardemo.Service;

import com.example.cardemo.bean.Car;
import com.example.cardemo.bean.Carbooking;
import com.example.cardemo.mapper.CarbookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarbookingService {


    @Autowired
    private CarbookingMapper carbookingMapper;




    @Transactional(isolation = Isolation.SERIALIZABLE)
    public boolean bookcar(Carbooking carbooking){
        if(carbookingMapper.checkBookingInfo(carbooking.getPhonenum(),carbooking.getCarid(),carbooking.getStarttime(),carbooking.getEndtime())==0){
            carbookingMapper.insert(carbooking);
            return true;
        }
        return false;
    }

    public List<Carbooking> querybooking(String phonenum){
        return carbookingMapper.findByPhoneNum(phonenum);
    }


    public List<Car> queryCars(){
        return carbookingMapper.queryCars();
    }
}
