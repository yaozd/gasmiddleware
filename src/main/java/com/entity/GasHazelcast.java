package com.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 21:14
 * @Desciption:
 * hazelcast缓存
 */

@Getter
@Setter
@ToString
public class GasHazelcast implements Serializable {

    private String tenantId;

    private GasEvent gasEvent;

}
