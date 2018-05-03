package com.service;

import com.entity.GasEvent;

import java.util.List;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 15:22
 * @Desciption:
 */
public interface InfluxdbSerice {

    /**
     * 数据插入kafka
     * @param gasEvent
     * @param measurement
     * @return
     */
    void insert(GasEvent gasEvent, String measurement);

//    List<GasEvent> query(String tenant, String hardwareId, long begin, long end);

}
