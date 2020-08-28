package com.zy.common.zangyuecommon.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/28 19:33
 */
@RestController
public class TestController {


    @Resource
    private TestService service;

    @RequestMapping("test")
    public void test() {
        service.test();
    }

}
