package com.service.Impl;

import com.entity.GasHazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import com.hazelcast.core.IMap;
import com.service.HazelcastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 21:22
 * @Desciption:
 */

@Service
public class HazelcastServiceImpl implements HazelcastService {

    /**
     * config 注入
     */
    @Autowired
    private HazelcastInstance hazelcastInstance;

    //由于租户 设备映射
    private IMap<String, String> map;

    private IList<GasHazelcast> gasEventIList;

    private String mapName = "tenlentmapId";
    private String listName = "listName";
    @PostConstruct
    public void init(){
        map = hazelcastInstance.getMap(mapName);
        gasEventIList = hazelcastInstance.getList(listName);
    }

    @Override
    public String getTenlent(String hardwareId) {
        return map.get(hardwareId);
    }

    @Override
    public List<GasHazelcast> getGasHazelcast() {
        return gasEventIList;
    }

    @Override
    public void add2Map(String hardwareId,String tenant) {
        map.put(hardwareId,tenant);
    }

    @Override
    public void add2List(GasHazelcast gasHazelcast) {
        gasEventIList.add(gasHazelcast);
    }


}
