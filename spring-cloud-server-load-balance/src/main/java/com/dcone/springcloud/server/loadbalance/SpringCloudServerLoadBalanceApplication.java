package com.dcone.springcloud.server.loadbalance;

import com.spring4all.swagger.EnableSwagger2Doc;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

import java.net.InetAddress;

@Slf4j
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2Doc
public class SpringCloudServerLoadBalanceApplication {

    @SneakyThrows
    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(SpringCloudServerLoadBalanceApplication.class, args);

        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String path = env.getProperty("server.servlet.context-path");
        String serviceName = env.getProperty("spring.application.name");
        log.info("\n----------------------------------------------------------\n\t" +
                "Service:" + serviceName + " is running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                "swagger-ui: http://" + ip + ":" + port + path + "/swagger-ui.html\n" +
                "----------------------------------------------------------");
    }

}
