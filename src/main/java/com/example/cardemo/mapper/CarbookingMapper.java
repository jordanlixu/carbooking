package com.example.cardemo.mapper;

import com.example.cardemo.bean.Car;
import com.example.cardemo.bean.Carbooking;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CarbookingMapper {

    @Select({ "SELECT "
            + " count(1) "
            + " FROM "
            + " carbooking a "
            + " WHERE "
            + " a.phoneNum = #{phonenum}"
            + " and a.carid = #{carid}"
            + " and ((a.starttime <= parsedatetime(#{starttime},'yyyy-MM-dd')"
            + " and a.endtime >= parsedatetime(#{starttime},'yyyy-MM-dd'))"
            +"  or (a.starttime <= parsedatetime(#{endtime},'yyyy-MM-dd')"
            + " and a.endtime >= parsedatetime(#{endtime},'yyyy-MM-dd')))"
            + " and a.deleteFlag = 'N' "
    })
    int checkBookingInfo(String phonenum,String carid, String starttime, String endtime);


    @Insert("INSERT INTO carbooking (phonenum, carid, starttime,endtime) VALUES (#{phonenum}, #{carid}, parsedatetime(#{starttime},'yyyy-MM-dd'), parsedatetime(#{endtime},'yyyy-MM-dd'))")
    int insert(Carbooking carbooking);


    @Select({ "SELECT "
            +"  a.phonenum,"
            + " a.carid, "
            + " a.starttime , "
            + " a.endtime  "
            + " FROM "
            + " carbooking a "
            + " WHERE "
            + " a.phoneNum = #{phonenum}"
            +"  and parsedatetime(sysdate, 'yyyy-MM-dd') <= parsedatetime(a.starttime, 'yyyy-MM-dd')"
            + " and a.deleteFlag = 'N' "
            })
    List<Carbooking> findByPhoneNum(String phonenum);



    @Select({ "SELECT "
            + " c.carid, "
            + " c.model "
            + " FROM "
            + " car c "
            })
    public List<Car> queryCars();


}