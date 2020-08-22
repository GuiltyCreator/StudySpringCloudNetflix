package com.dcone.springcloud.server.http.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 入参
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "入参")
public class HelloReqDto {

    @ApiModelProperty(value = "消息")
    private String message;
}
