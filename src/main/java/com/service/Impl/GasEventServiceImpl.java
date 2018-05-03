package com.service.Impl;

import com.entity.GasEvent;
import com.google.gson.Gson;
import com.message.ProducerMessage;
import com.service.GasEventService;
import com.service.InfluxdbSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
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

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private ProducerMessage producer;

    Gson gson = new Gson();

    @Async
    @Override
    public Integer process(GasEvent gasEvent) throws Exception {
        producer.send("gas",0,"message",gson.toJson(gasEvent));
        return null;
    }
}
