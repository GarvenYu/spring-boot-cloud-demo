package com.freesia.multidatasource.secondway.mapper;

import com.freesia.multidatasource.secondway.entity.User;
import com.freesia.multidatasource.secondway.aop.SwitchDataSource;
import com.freesia.multidatasource.secondway.config.DataSourceConstants;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yukaibo
 */
@Repository
public interface MasterQueryMapper {

    @Select("select * from user")
    @SwitchDataSource(value = DataSourceConstants.DS_KEY_MASTER)
    List<User> selectUserFromMaster();
}
