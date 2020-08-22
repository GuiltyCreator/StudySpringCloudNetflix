package com.dcone.springcloud.client.controller;

import com.dcone.springcloud.client.FeignClient.ServiceFeign;
import com.dcone.springcloud.client.config.properties.PersonProperties;
import com.dcone.springcloud.server.http.req.HelloReqDto;
import com.dcone.springcloud.server.http.resp.HelloRespDto;
import com.netflix.config.DynamicListProperty;
import com.netflix.config.DynamicProperty;
import com.netflix.config.DynamicPropertyFactory;
import com.netflix.config.DynamicStringProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户端test接口
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-06
 */
@Api(tags = "客户端test接口")
@RestController
@RequestMapping("/test")
public class TestController {

    @Resource
    private ServiceFeign feign;





    @ApiOperation(value = "hello world",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, httpMethod = "GET",response = HelloRespDto.class)
    @GetMapping("/helloGet")
    public HelloRespDto hello(@ModelAttribute HelloReqDto reqDto){
        return feign.helloGet(reqDto);
    }

    @ApiOperation(value = "hello world",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, httpMethod = "POST",response = HelloRespDto.class)
    @PostMapping("/helloPost")
    public HelloRespDto helloPost(@RequestBody HelloReqDto reqDto){
        return feign.helloPost(reqDto);
    }

    @ApiOperation(value = "person",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, httpMethod = "GET",response = PersonProperties.class)
    @GetMapping("/test")
    public String  test(){
        return "test";
    }

    @ApiOperation(value = "测试Archaius",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, httpMethod = "GET",response = Map.class)
    @GetMapping("/archaius")
    public Map<String, String> getPropertiesFromDynamic(String key) {

        DynamicStringProperty property = DynamicPropertyFactory.getInstance().
                getStringProperty(key,"not found");
        Map<String, String> properties = new HashMap<>();
        properties.put(property.getName(), property.get());
        return properties;
    }


}
