package com.zy.common.zangyuecommon.test;

import com.zy.common.zangyuecommon.util.excel.annotations.Export;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p></p>
 *
 * @author lhf
 * @since 2020/8/28 19:42
 */
@Service
public class TestServiceImpl implements TestService{
    @Override
    @Export(value = Demo.class,fileName = "test")
    public List<Demo> test() {

        List<Demo> list = new ArrayList<>();

        Demo demo = new Demo("lhf", 9, "张家口",new Date());
        Demo demo1 = new Demo("zjs", 19, "阳原",new Date());
        Demo demo2 = new Demo("hdz", 91, "中国",new Date());

        list.add(demo);
        list.add(demo1);
        list.add(demo2);

        return list;
    }
}
