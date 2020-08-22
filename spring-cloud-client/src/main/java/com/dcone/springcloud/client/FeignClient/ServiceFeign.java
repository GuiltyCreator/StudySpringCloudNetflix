package com.dcone.springcloud.client.FeignClient;

import com.dcone.springcloud.client.hystric.TestHystric;
import com.dcone.springcloud.server.http.req.HelloReqDto;
import com.dcone.springcloud.server.http.resp.HelloRespDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.*;

/**
 * server-producer服务端test接口
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-06
 */

/**
 * 这里对应的是服务端配置文件中的spring.application.name，不分大小写
 * path中的url需要相对应，才能找到服务端的controller
 */
@FeignClient(name = "SERVER-PRODUCER",path = "/server/test",fallback = TestHystric.class)
public interface ServiceFeign {
    @GetMapping("/helloGet")
    HelloRespDto helloGet(@SpringQueryMap HelloReqDto reqDto);

    @PostMapping("/helloPost")
    HelloRespDto helloPost(@RequestBody HelloReqDto reqDto);

}
