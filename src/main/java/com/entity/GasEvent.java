package com.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-03 14:58
 * @Desciption:
 * 油气事件
 * 通过转化JSON的格式来传递数据
 */

@Getter
@Setter
@AllArgsConstructor
@ToString
public class GasEvent implements Serializable {

    private String hardwareId;//设备id

    private double temperature;//温度 temperature=23.63：温度，-20～100；

    private double pressure;//压强 pressure=311.41：压力，4BYTE

    private double standard;//标况  standard=1160.22：标况，

    private double running;//工况  running=382.06：工况，

    private double summary;//累计流量  summary=6264700.00：累计，0～999999999；

    private double surplus;//剩余流量   surplus=0.00：剩余流量，0～99999999；

    private double analog1;// analog1=1.10：模拟量，4BYTE 双精度；

    private double analog2;//analog2=1.10：模拟量，4BYTE 双精度；

    private double analog3;//analog3=0.71：模拟量，4BYTE 双精度；

    private double analog4; //analog4=0.73：模拟量，4BYTE 双精度；

    private int switch1;// switch1=关：开/关；

    private int switch2;// switch2=关：开/关；

    private int switch3;//switch3=关：开/关；

    private int switch4;//switch4=关：开/关；

    private int ac220;// ac220=有电/无电；

    private double battery;// battery=4.08，4BYTE;

    private double solar;//  solar=0.00:,4BYTE

    private String pointtime;//测点时间  pointtime=2017-10-10 20:33:28，有效时间

}
