package com.dcone.springcloud.client.hystric;

import com.dcone.springcloud.client.FeignClient.ServiceFeign;
import com.dcone.springcloud.server.http.req.HelloReqDto;
import com.dcone.springcloud.server.http.resp.HelloRespDto;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;


/**
 * server-producer服务端test接口熔断器
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-06
 */
@Component
public class TestHystric implements ServiceFeign {
    @Override
    public HelloRespDto helloPost(HelloReqDto reqDto) {
        return new HelloRespDto("POST:码炸了");
    }

    @Override
    public HelloRespDto helloGet(@ModelAttribute HelloReqDto reqDto) {
        return new HelloRespDto("GET:码炸了");
    }
}
