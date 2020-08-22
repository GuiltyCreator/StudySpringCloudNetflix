package com.dcone.springcloud.client.converter;

import com.dcone.springcloud.client.config.properties.PersonProperties;
import org.springframework.core.convert.converter.Converter;

/**
 * Account转换器
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-17
 */
public class AccountConverter implements Converter<String, PersonProperties.Account> {
    @Override
    public PersonProperties.Account convert(String s) {
        String[] strings = s.split("&");
        return new PersonProperties.Account(strings[0], strings[1], strings[2]);
    }
}
