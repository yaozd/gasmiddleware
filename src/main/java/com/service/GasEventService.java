package com.service;

import com.entity.GasEvent;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 15:21
 * @Desciption:
 */
public interface GasEventService {

    Integer process(GasEvent event) throws Exception;

}
