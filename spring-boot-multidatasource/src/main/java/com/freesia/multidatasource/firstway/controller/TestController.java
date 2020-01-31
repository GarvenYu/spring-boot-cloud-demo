package com.freesia.multidatasource.firstway.controller;

import com.freesia.multidatasource.firstway.mapper.master.MasterQueryMapper;
import com.freesia.multidatasource.firstway.mapper.slave.SlaveQueryMapper;
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

    @GetMapping("/api/v1/testMultiDatasource")
    public void testMultiDatasource(){
        log.info("query master datasource:{}", masterQueryMapper.selectUserFromMaster());
        log.info("query slave datasource:{}", slaveQueryMapper.selectUserFromSlave());
    }
}
