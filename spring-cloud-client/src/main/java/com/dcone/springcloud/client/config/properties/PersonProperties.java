package com.dcone.springcloud.client.config.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

/**
 * Person配置属性
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-18
 */

/**
 * 如果不想在application.yml文件中设定属性，可以用以下注解：
 * @PropertySource(value = {"classpath:person.yml"},ignoreResourceNotFound = false,encoding = "UTF-8",name = "person.yml")
 * 这里是指使用person.yml配置文件，注意person.yml文件与application.yml文件同级,否则需要更改value
 * 如value = {"classpath:static/person.yml"}就是指在static目录下的person.yml文件
 */
@ConfigurationProperties(prefix = "person")
@Data
public class PersonProperties {

    @NotEmpty
    private String name;

    @Min(0)
    @Max(200)
    private Integer age;

    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$")
    private String addr;

    private Detail detail = new Detail();

    private Account account;

    private boolean enable = false;

    @Data
    private static class Detail{

        private String company = "DigitalChina";

        private BigDecimal money = new BigDecimal(0);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Account {

        private String username;

        private String password;

        private String accountType;
    }
}
