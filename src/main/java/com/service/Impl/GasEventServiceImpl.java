package com.service.Impl;

import com.entity.GasEvent;
import com.google.gson.Gson;
import com.message.ProducerMessage;
import com.service.GasEventService;
import com.service.InfluxdbSerice;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 16:41
 * @Desciption:
 */

@Service
public class GasEventServiceImpl implements GasEventService {

    //同级调用
    @Autowired
    InfluxdbSerice influxdbSerice;

    @Autowired
    private ProducerMessage producerMessage;

    Gson gson = new Gson();


    @Async
    @Override
    public void process(GasEvent gasEvent){
        producerMessage.send("gas",0,"message",gson.toJson(gasEvent));
    }
}
