package com.message;

import com.entity.GasEvent;
import com.google.gson.Gson;
import com.service.InfluxdbSerice;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;


/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 16:59
 * @Desciption:
 */

@Component
public class ConsumerListener {

    @Autowired
    InfluxdbSerice influxdbSerice;

    Gson gson = new Gson();

    @KafkaListener(topics = "gas")
    public void consumer(String message){
        System.out.println("---------------message------------------");
        GasEvent gasEvent = gson.fromJson(message,GasEvent.class);
        System.out.println(gasEvent.toString());

        //写入influxdb
        influxdbSerice.insert(gasEvent,"gas_");

        //todo 写入缓存
    }

//     implements MessageListener<String,String>
//    @Override
//    public void onMessage(ConsumerRecord<String, String> data) {
//        if(data.topic().equals())
//    }
}
