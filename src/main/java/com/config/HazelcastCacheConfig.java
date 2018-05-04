package com.config;

import com.hazelcast.config.CacheSimpleConfig;
import com.hazelcast.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: RenQiQiang
 * @Date: 2018-05-04 13:25
 * @Desciption:
 * hzelcatst分布式缓存的配置
 */

@Configuration
public class HazelcastCacheConfig {

    @Bean
    public Config hazelCastConfig(){
        Config config = new Config();
        config.setInstanceName("hazelcastInstance");
        return config;
    }
}
