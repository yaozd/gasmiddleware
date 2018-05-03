package com.service.Impl;

import com.entity.GasEvent;
import com.service.InfluxdbSerice;
import org.influxdb.dto.Point;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.influxdb.InfluxDBTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 15:53
 * @Desciption:
 * Influxdb的服务实现
 */
@Service
public class InfluxdbSericeImpl implements InfluxdbSerice {

    @Autowired
    private InfluxDBTemplate<Point> influxDBTemplate;

    @PostConstruct
    public void init(){
        influxDBTemplate.createDatabase();
    }

    @Override
    public void insert(GasEvent gasEvent, String measurement) {
        //时间使用ponit todo
        final Point point = Point.measurement(measurement)
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                .addField("hardwareId",gasEvent.getHardwareId())
                .addField("pressure",gasEvent.getPressure())
                .addField("standard",gasEvent.getStandard())
                .addField("running",gasEvent.getRunning())
                .addField("summary",gasEvent.getSummary())
                .addField("surplus",gasEvent.getSurplus())
                .addField("analog1",gasEvent.getAnalog1())
                .addField("analog2",gasEvent.getAnalog2())
                .addField("analog3",gasEvent.getAnalog3())
                .addField("analog4",gasEvent.getAnalog4())
                .addField("switch1",gasEvent.getSwitch1())
                .addField("switch2",gasEvent.getSwitch2())
                .addField("switch3",gasEvent.getSwitch3())
                .addField("switch4",gasEvent.getSwitch4())
                .addField("ac220",gasEvent.getAc220())
                .addField("battery",gasEvent.getBattery())
                .addField("solar",gasEvent.getSolar())
                .addField("pointtime",gasEvent.getPointtime())
                .build();
         influxDBTemplate.write(point);
    }
}
