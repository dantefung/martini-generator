/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.dantefung;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 多数据源测试
 *
 * @author Mark sunlightcs@gmail.com
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DynamicDataSourceTest {

    @Autowired
    private DynamicDataSourceTestService dynamicDataSourceTestService;

    @Test
    public void test(){
        Long id = 1L;

        System.out.println(dynamicDataSourceTestService.query(id));
        System.out.println(dynamicDataSourceTestService.queryByMysqlKey(id));
        System.out.println(dynamicDataSourceTestService.queryBySqliteKey(id));
        Assert.assertTrue(dynamicDataSourceTestService.queryByMysqlKey(id).get(0).get("username").equals("admin"));
        Assert.assertTrue(dynamicDataSourceTestService.queryBySqliteKey(id).get(0).get("username").equals("sqlite"));
    }

}
