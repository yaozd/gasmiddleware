package com.service;

import com.entity.GasHazelcast;

import java.util.List;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 21:21
 * @Desciption:
 * Hazelcast缓存服务
 */
public interface HazelcastService {

    String getTenlent(String hardwareId);

    List<GasHazelcast> getGasHazelcast();

    void add2Map(String hardwareId,String tenant);

    void add2List(GasHazelcast gasHazelcast);
}
