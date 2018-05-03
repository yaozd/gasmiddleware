package com.service;

import com.entity.GasEvent;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 15:21
 * @Desciption:
 */
public interface GasEventService {

    Integer process(GasEvent event) throws Exception;

}
