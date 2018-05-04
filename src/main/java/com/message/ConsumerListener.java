package com.message;

import com.entity.GasEvent;
import com.entity.GasHazelcast;
import com.google.gson.Gson;
import com.service.HazelcastService;
import com.service.InfluxdbSerice;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ConsumerListener {

    @Autowired
    InfluxdbSerice influxdbSerice;

    @Autowired
    HazelcastService hazelcastService;

    Gson gson = new Gson();

    @KafkaListener(topics = "gas")
    public void consumer(String message){
        log.info("---------------message------------------");
        GasEvent gasEvent = gson.fromJson(message,GasEvent.class);
        log.info(gasEvent.toString());

        String tenlentId = hazelcastService.getTenlent(gasEvent.getHardwareId());
        //写入influxdb
        //标记为gas_tenlentId
        influxdbSerice.insert(gasEvent,"gas_"+tenlentId);

        //todo 写入缓存
        GasHazelcast gasHazelcast = new GasHazelcast();
        gasHazelcast.setTenantId(tenlentId);
        gasHazelcast.setGasEvent(gasEvent);
        hazelcastService.add2List(gasHazelcast);

    }

//     implements MessageListener<String,String>
//    @Override
//    public void onMessage(ConsumerRecord<String, String> data) {
//        if(data.topic().equals())
//    }
}
