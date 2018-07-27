package com.yunsheng;

import com.dangdang.config.service.ConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigGroup;
import com.dangdang.config.service.zookeeper.ZookeeperConfigProfile;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigToolkitConfig {
 
 
    /**
     * 配置zk管理中心
     * @param connectStr
     * @param rootNode
     * @param version
     * @return
     */
    @Bean
    public ZookeeperConfigProfile getConfigProfile(@Value("${config-toolkit.connect-str}") String connectStr,
                                                   @Value("${config-toolkit.root-node}") String rootNode,
                                                   @Value("${config-toolkit.version}") String version) {
        return new ZookeeperConfigProfile(connectStr, rootNode, version);
    }

 
    /**
     * dubbo配置
     * @param configProfile
     * @return
     */
    @Bean("dubboGroup")
    public ConfigGroup getDubboGroup(ZookeeperConfigProfile configProfile) {
        return new ZookeeperConfigGroup(configProfile, "api-dubbo-group-1");
    }
 
 

}