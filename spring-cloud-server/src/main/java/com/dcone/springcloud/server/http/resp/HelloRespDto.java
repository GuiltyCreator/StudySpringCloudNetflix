package com.dcone.springcloud.server.http.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返参
 *
 * @author 肖晟鹏
 * @email xiaocpa@digitalchina.com
 * @date 2020-08-07
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "返参")
public class HelloRespDto {
    @ApiModelProperty(value = "消息")
    private String message;
}
