package com.example.cardemo.controller;

import com.example.cardemo.Service.CarbookingService;
import com.example.cardemo.bean.Carbooking;
import com.example.cardemo.common.Constants;
import com.example.cardemo.common.ResultEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(description = "Car booking service API spec")
@RestController
@RequestMapping(value="assignment")
public class CarbookingController {

    @Autowired
    private CarbookingService carbookingService;

    @ApiOperation(value = "query car booking innfo", notes="通过手机号获取预订信息")
    @RequestMapping(value="/carbooking/{phonenum}",method=RequestMethod.GET)
    @ResponseBody
    public ResultEntity querybooking(@PathVariable("phonenum") String phonenum){
        return new ResultEntity(carbookingService.querybooking(phonenum));
    }

    @ApiOperation(value = "book a car", notes="以天为时间单位租车")
    @RequestMapping(value="/carbooking",method=RequestMethod.POST)
    @ResponseBody
    public ResultEntity book(@RequestParam("carid") String carid,
                             @RequestParam("phonenum") String phonenum,
                             @RequestParam("starttime") String stattime,
                             @RequestParam("endtime") String endtime){

        Carbooking booking = new Carbooking();
        booking.setCarid(carid);
        booking.setPhonenum(phonenum);
        booking.setStarttime(stattime);
        booking.setEndtime(endtime);
        if(carbookingService.bookcar(booking)) {
            return new ResultEntity(Constants.SUCCESS_CODE, "booking succeed！");
        }
        return  ResultEntity.getErrorEntity("Sorry,the car has been booked!");
    }

    @ApiOperation(value = "query car info", notes="查询出租的车辆信息")
    @RequestMapping(value="/carbooking/cars",method=RequestMethod.GET)
    @ResponseBody
    public ResultEntity queryCars(){
        return new ResultEntity(carbookingService.queryCars());
    }
}
