package com.freesia.multidatasource.secondway.controller;

import com.freesia.multidatasource.secondway.mapper.MasterQueryMapper;
import com.freesia.multidatasource.secondway.mapper.SlaveQueryMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author yukaibo
 */
@RestController
@Slf4j
public class TestController {

    @Resource
    private MasterQueryMapper masterQueryMapper;

    @Resource
    private SlaveQueryMapper slaveQueryMapper;

    @GetMapping("/api/v2/testMultiDatasource")
    public void testMultiDatasource(){
        log.info("query master2 datasource:{}", masterQueryMapper.selectUserFromMaster());
        log.info("query slave2 datasource:{}", slaveQueryMapper.selectUserFromSlave());
    }
}
