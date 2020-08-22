package com.dcone.springcloud.server.loadbalance.controller;

import com.dcone.springcloud.server.loadbalance.http.req.HelloReqDto;
import com.dcone.springcloud.server.loadbalance.http.resp.HelloRespDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * test控制器
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-06
 */
@Api(tags = "test控制器")
@RestController
@RequestMapping("/test")
public class TestController {
    @ApiOperation(value = "hello world",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, httpMethod = "GET",response = HelloRespDto.class)
    @GetMapping("/helloGet")
    public HelloRespDto helloGet(@ModelAttribute HelloReqDto reqDto){
        HelloRespDto respDto = new HelloRespDto();
        respDto.setMessage("LB GET:" + reqDto.getMessage());
        return  respDto;
    }

    @ApiOperation(value = "hello world",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, httpMethod = "POST",response = HelloRespDto.class)
    @PostMapping("/helloPost")
    public HelloRespDto helloPost(@RequestBody HelloReqDto reqDto){
        HelloRespDto respDto = new HelloRespDto();
        respDto.setMessage("LB POST:" + reqDto.getMessage());
        return  respDto;
    }

    @ApiOperation(value = "hello world",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, httpMethod = "GET",response = HelloRespDto.class)
    @GetMapping("/hello")
    public HelloRespDto helloG(@ModelAttribute HelloReqDto reqDto){
        HelloRespDto respDto = new HelloRespDto();
        respDto.setMessage("Hello GET:" + reqDto.getMessage());
        return  respDto;
    }

    @ApiOperation(value = "hello world",produces = MediaType.APPLICATION_JSON_UTF8_VALUE, httpMethod = "GET",response = HelloRespDto.class)
    @PostMapping("/hello")
    public HelloRespDto helloP(@RequestBody HelloReqDto reqDto){
        HelloRespDto respDto = new HelloRespDto();
        respDto.setMessage("Hello POST:" + reqDto.getMessage());
        return  respDto;
    }
}
