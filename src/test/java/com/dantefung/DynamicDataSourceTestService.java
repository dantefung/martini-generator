/**
 * Copyright (c) 2016-2019 人人开源 All rights reserved.
 *
 * https://www.renren.io
 *
 * 版权所有，侵权必究！
 */

package com.dantefung;

import com.dantefung.datasource.annotation.DataSource;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 测试多数据源
 *
 * @author Mark sunlightcs@gmail.com
 */
@Service
//@DataSource("mysqlKey")
public class DynamicDataSourceTestService {

    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    @Transactional
    public List<Map<String,String>> query(Long id){
        String sql = "com.dantefung.dao.Test.queryList";
        return sqlSessionTemplate.selectList(sql, id);
    }

    @Transactional
    @DataSource("mysqlKey")
    public List<Map<String,String>> queryByMysqlKey(Long id){
        String sql = "com.dantefung.dao.Test.queryList";
        return sqlSessionTemplate.selectList(sql, id);
    }

    @Transactional
    @DataSource("sqliteKey")
    public List<Map<String,String>> queryBySqliteKey(Long id){
        String sql = "com.dantefung.dao.Test.queryList";
        return sqlSessionTemplate.selectList(sql, id);
    }

}