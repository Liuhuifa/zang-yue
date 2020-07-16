package com.zy.zangyueweb.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/7/15$ 15:31$
 */
@RestController
@RequestMapping("/test")
@Api(tags = "测试")
public class TestController {

    @GetMapping("hello")
    @ApiOperation(value = "测试")
    public String test() {
        return "hello";
    }
}
