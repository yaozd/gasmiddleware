package com.controller;

import com.entity.GasEvent;
import com.service.GasEventService;
import com.service.InfluxdbSerice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 17:10
 * @Desciption:
 */

@RequestMapping("event")
@RestController
@Slf4j
public class GasEventController {

    @Autowired
    GasEventService gasEventService;

    @RequestMapping("/add")
    public Object addEvent(GasEvent gasEvent){
        try {
            gasEventService.process(gasEvent);
        } catch (Exception e) {
            log.error(e.getMessage());
            return new HashMap<String, String>().put("fail","false");
        }
        return new HashMap<String, String>().put("success","true");
    }

}
