package com.dcone.springcloud.client.config;

import com.dcone.springcloud.client.config.properties.PersonProperties;
import com.dcone.springcloud.client.converter.AccountConverter;
import com.netflix.config.DynamicConfiguration;
import com.netflix.config.FixedDelayPollingScheduler;
import com.netflix.config.PolledConfigurationSource;
import com.netflix.config.sources.URLConfigurationSource;
import org.apache.commons.configuration.AbstractConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 一般配置类
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-18
 */
@Configuration
public class Config {

    @Bean
    @ConfigurationPropertiesBinding
    public AccountConverter accountConverter() {
        return new AccountConverter();
    }

    @Bean
    @ConditionalOnProperty(value = "person.enable",havingValue = "true",matchIfMissing = true)
    public PersonProperties personProperties(){
        return new PersonProperties();
    }

    /**
     * Archaius配置，修改路径,两种方法选一个即可
     * @return
     */
    static {
        System.setProperty("archaius.configurationSource.defaultFileName", "test1.properties");
    }
    /*@Bean
    public AbstractConfiguration addApplicationPropertiesSource() {
        PolledConfigurationSource source = new URLConfigurationSource("classpath:test1.properties");
        return new DynamicConfiguration(source, new FixedDelayPollingScheduler());
    }*/

}
