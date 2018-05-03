package com.message;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 17:34
 * @Desciption:
 */

@Slf4j
@Component
public class ProducerMessage {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void send(String topic,Integer partition,String key, String value) {

        log.info("sending key='{}' to valye='{}'", key,value);

        kafkaTemplate.send(topic,partition, key,value);// "message"
    }
}
